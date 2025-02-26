public class TaskList {
    private Task head;

    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
            return;
        }
        if (taskExists(description)) {
            System.out.println("Error: Task already exists.");
            return;
        }

        Task newTask = new Task(description);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.getNextTask() != null) {
                current = current.getNextTask();
            }
            current.setNextTask(newTask);
        }
        System.out.println("Task added: " + description);
    }

    public boolean markTaskCompleted(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Invalid task description.");
            return false;
        }

        Task current = head;
        while (current != null) {
            if (current.getDescription().equalsIgnoreCase(description)) {
                current.complete();
                return true;
            }
            current = current.getNextTask();
        }
        System.out.println("Task not found: " + description);
        return false;
    }

    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        Task current = head;
        System.out.println("Task List:");
        while (current != null) {
            System.out.println("- " + current);
            current = current.getNextTask();
        }
    }

    private boolean taskExists(String description) {
        Task current = head;
        while (current != null) {
            if (current.getDescription().equalsIgnoreCase(description)) {
                return true;
            }
            current = current.getNextTask();
        }
        return false;
    }
}

