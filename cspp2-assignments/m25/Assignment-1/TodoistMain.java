import java.util.Scanner;
/**
  * write your code below this comment
  */
class Todoist {
	/**
	 * the task object to collect all objects.
	 */
	private List<Task> taskObj;
	/** this is a constructor.
	*/
	Todoist () {
			taskObj = new List<Task>();
	}
	/** the method is to
	*add the tasks to the list;
	*@param task Task
	*/
	public void addTask(final Task task) {
		taskObj.add(task);
	}
	/**
	 * this method is to give the next task.
	 * to be done
	 * @param      name  The name
	 *
	 * @return     The next task.
	 */
	public Task getNextTask(final String name) {
		for (int i = 0; i < taskObj.size(); i++) {
			if (name.equals(taskObj.get(i).getAssignedTo())) {
				if ("todo".equals(taskObj.get(i).getStatus())) {
					if (("Important".equals(
						taskObj.get(i).getImportant())) &&
						"Urgent".equals(taskObj.get(i).getUrgent())) {
						return taskObj.get(i);
					} else if (("Important".equals(
						taskObj.get(i).getImportant())) &&
					"Not Urgent".equals(taskObj.get(i).getUrgent())) {
						return taskObj.get(i);
					}
				}
			}
		}
		return null;
	}
	/**
	 * this method is to give the next n tasks.
	 *
	 * @param      name   The name
	 * @param      count  The count
	 *
	 * @return     The next task.
	 */
	public List getNextTask(final String name, final int count) {
		List<String> array = new List<String>();
		for (int i = 0; i < taskObj.size(); i++) {
			for (int j = 0; j < count; j++) {
			if (name.equals(taskObj.get(i).getAssignedTo())) {
				if ("todo".equals(taskObj.get(i).getStatus())) {
					array.add(taskObj.get(i).toString());
				}
				}
			}
		}
		return array;
	}
	/**
	 * this method is to give the total time to do tasks.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int totalTime4Completion() {
	int total = 0;
	for (int i = 0; i < taskObj.size(); i++) {
		if ("todo".equals(taskObj.get(i).getStatus())) {
			total += taskObj.get(i).getTime();
		}
	}
	return total;
	}
	/**this method is to print all the objects.
	*/
	public String toString() {
		String str = "";
		for (int i = 0; i < taskObj.size(); i++) {
			str += taskObj.get(i).toString() + "\n";
		}
		return str;
	}
}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    // Task[] tasks = todo.getNextTask(tokens[1], n);
                    // System.out.println(Arrays.deepToString(tasks));
                    System.out.println(todo.getNextTask(tokens[1], n));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        if (title.length() == 0) {
        	throw new Exception("Title not provided");
        }
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        if (timeToComplete < 0) {
        	throw new Exception("Invalid timeToComplete -1");
        }
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        if (status.equals("todo") || status.equals("done")){
        } else {
        	throw new Exception("Invalid status dud");
        }
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
/**
 * this class is to specify particular task.
 */
class Task {
	/** this is empty constructor
	*/
	Task() {

	}
	/**
	 * this variable is to store title.
	 */
	private String title;
	/**
	 * this variable is to store person name.
	 */
	private String assignedTo;
	/**
	 * this variable is to store time.
	 */
	private int timeToComplete;
	/**
	 * this variable is to store important or not.
	 */
	private boolean important;
	/**
	 * this variable is to store urgent or not.
	 */
	private boolean urgent;
	/**
	 * this variable is to store status.
	 */
	private String status;
	/**
	 * this variable is to store message.
	 */
	private String message;
	/**
	 * this variable is to store warning.
	 */
	private String warning;
	/**
	 * overloaded constructor to initialize variables.
	 *
	 * @param      title           The title
	 * @param      assignedTo      The assigned to
	 * @param      timeToComplete  The time to complete
	 * @param      important       The important
	 * @param      urgent          The urgent
	 * @param      status          The status
	 */
	Task(final String title, final String assignedTo,
		final int timeToComplete,
		final boolean important, final boolean urgent,
		final String status) {
		this.title = title;
		this.assignedTo = assignedTo;
		this.timeToComplete = timeToComplete;
		this.important = important;
		this.status = status;
		this.urgent = urgent;
		this.message = "";
		this.warning = "";
	}
	/**
	 * Gets the title.
	 *
	 * @return     The title.
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * Gets the assigned to person name.
	 *
	 * @return     The assigned to.
	 */
	public String getAssignedTo() {
		return this.assignedTo;
	}
	/**
	 * Gets the time.
	 *
	 * @return     The time.
	 */
	public int getTime() {
		return this.timeToComplete;
	}
	/**
	 * Gets the status.
	 *
	 * @return     The status.
	 */
	public String getStatus() {
		return this.status;
	}
	/**
	 * gives whether it is important or not.
	 *
	 * @return     message.
	 */
	public String getImportant() {
		if (this.important == true) {
			this.message = "Important";
		} else {
			this.message = "Not Important";
		}
		return this.message;
	}
	/**
	 * Gives urgent or not.
	 *
	 * @return     The urgent.
	 */
	public String getUrgent() {
		if (this.urgent == true) {
			this.warning = "Urgent";
		} else {
			this.warning = "Not Urgent";
		}
		return this.warning;
	}
	/** this method is to give the.
	*representaion of all task
	*/
	public String toString() {
		return this.title + ", " + this.assignedTo + ", "
		+ this.timeToComplete + ", " + getImportant() + ", "
		+ getUrgent() + ", " + this.status;
	}
}
