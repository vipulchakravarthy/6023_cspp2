import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Todoist {
	private List<Task> taskObj;
	Todoist () {
			taskObj = new List<Task>();
	}
	public void addTask(final Task task) {
		taskObj.add(task);
	}
	public Task getNextTask(String name) {
		for (int i = 0; i < taskObj.size(); i++) {
			if (name.equals(taskObj.get(i).getAssignedTo())) {
				if ("todo".equals(taskObj.get(i).getStatus())) {
					if (("Important".equals(taskObj.get(i).getImportant())) && "Not Urgent".equals(taskObj.get(i).getUrgent())) {
						return taskObj.get(i);
					} else if (("Important".equals(taskObj.get(i).getImportant())) && "Urgent".equals(taskObj.get(i).getUrgent())) {
						return taskObj.get(i);
					}
				}
			}
		}
		return null;
	}
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
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
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
class Task {
	Task() {

	}
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private boolean important;
	private boolean urgent;
	private String status;
	private String message;
	private String warning;
	Task(String title, String assignedTo,
		int timeToComplete, boolean important, boolean urgent, String status) {
		this.title = title;
		this.assignedTo = assignedTo;
		this.timeToComplete = timeToComplete;
		this.important = important;
		this.status = status;
		this.urgent = urgent;
		this.message = "";
		this.warning = "";
	}
	public String getTitle() {
		return this.title;
	}
	public String getAssignedTo() {
		return this.assignedTo;
	}
	public int getTime() {
		return timeToComplete;
	}
	public String getStatus() {
		return status;
	}
	public String getImportant() {
		if (this.important == true) {
			message += "Important";
		} else {
			message += "Not Important";
		}
		return message;
	}
	public String getUrgent() {
		if (this.urgent == true) {
			warning += "Urgent";
		} else {
			warning += "Not Urgent";
		}
		return warning;
	}
	public String toString() {
		return this.title + ", " + this.assignedTo + ", " + this.timeToComplete + ", " + getImportant() + ", " + getUrgent() + ", " + this.status;
	}
}
