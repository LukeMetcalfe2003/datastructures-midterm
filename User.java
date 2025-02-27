public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        setName(name);
        this.taskList = new TaskList();
    }

    public void addTask(String description) {
        System.out.println(name + " is adding a new task...");
        taskList.addTask(description);
    }

    public boolean markTaskCompleted(String description) {
        boolean result = taskList.markTaskCompleted(description);
        if (result) {
            System.out.println(name + " has completed the task: " + description);
        } else {
            System.out.println("Task not found for " + name + ": " + description);
        }
        return result;
    }

    public void printTasks() {
        System.out.println("\n--- Task List for " + name + " ---");
        taskList.printTasks();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty.");
        }
        this.name = name.trim();
    }

    public TaskList getTaskList() {
        return taskList;
    }
}

