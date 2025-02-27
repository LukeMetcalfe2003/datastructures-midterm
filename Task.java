public class Task {
    private String description;
    private boolean isCompleted;
    private Task nextTask;

    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
        }
        this.description = description;
        this.isCompleted = false;
        this.nextTask = null;
    }

    public void complete() {
        if (!isCompleted) {
            isCompleted = true;
            System.out.println("Task marked as completed: " + description);
        } else {
            System.out.println("Task is already completed.");
        }
    }

    public void reset() {
        if (isCompleted) {
            isCompleted = false;
            System.out.println("Task reset to pending: " + description);
        } else {
            System.out.println("Task is already pending.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        if (newDescription == null || newDescription.trim().isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
        }
        this.description = newDescription;
    }

    public Task getNextTask() {
        return nextTask;
    }

    public void setNextTask(Task nextTask) {
        this.nextTask = nextTask;
    }

    @Override
    public String toString() {
        return "Task: " + description + " | Status: " + (isCompleted ? "Completed" : "Pending");
    }
}
