import java.util.Scanner;
/**
  * write your code below this comment.
  */
class Todoist {
    /**
     * the task object to collect all objects.
     */
    private List<Task> taskObj;
    /** this is a constructor.
    */
    Todoist() {
            taskObj = new List<Task>();
    }
    /** the method is to.
    *add the tasks to the list.
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
                if (("todo".equals(taskObj.get(i).getStatus())) &&("Important".equals(taskObj.get(i).getImportant())) && ("Urgent".equals(taskObj.get(i).getUrgent()))) {
                        return taskObj.get(i);
                } else if (("todo".equals(taskObj.get(i).getStatus())) && ("Important".equals(taskObj.get(i).getImportant())) && ("Not Urgent".equals(taskObj.get(i).getUrgent()))) {
                        return taskObj.get(i);
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
                if ("todo".equals(taskObj.get(i).getStatus()) && ("Important".equals(taskObj.get(i).getImportant())) && ("Not Urgent".equals(taskObj.get(i).getUrgent()))) {
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
     * @return total which is the total time
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
     *@return str String
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
final class TodoistMain {
    /** this is an empty contructor.
    */
    private TodoistMain() {

    }
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
        final int two =  2;
        final int three = 3;
        final int four  = 4;
        final int five = 5;
        final int six  = 6;
        String title = tokens[1];
        if (title.length() == 0) {
            throw new Exception("Title not provided");
        }
        String assignedTo = tokens[two];
        int timeToComplete = Integer.parseInt(tokens[three]);
        if (timeToComplete < 0) {
            throw new Exception("Invalid timeToComplete -1");
        }
        boolean important = tokens[four].equals("y");
        boolean urgent = tokens[five].equals("y");
        String status = tokens[six];
        if (status.equals("todo") || status.equals("done")) {
            String a = "";
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
    /** this is empty constructor.
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
     * @param      task           The title
     * @param      assigned      The assigned to
     * @param      time  The time to complete
     * @param      importantOR       The important
     * @param      urgentOR          The urgent
     * @param      statusReport          The status
     */
    Task(final String task, final String assigned,
        final int time,
        final boolean importantOR, final boolean urgentOR,
        final String statusReport) {
        this.title = task;
        this.assignedTo = assigned;
        this.timeToComplete = time;
        this.important = importantOR;
        this.status = statusReport;
        this.urgent = urgentOR;
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
     *@return string representation of task
    */
    public String toString() {
        return this.title + ", " + this.assignedTo + ", "
        + this.timeToComplete + ", " + getImportant() + ", "
        + getUrgent() + ", " + this.status;
    }
}
