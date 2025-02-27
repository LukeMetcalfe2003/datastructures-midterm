import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTo-Do List Manager:");
            System.out.println("1. Create User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1: 
                    createUser();
                    break;
                case 2: 
                    addTaskToUser();
                    break;
                case 3: 
                    markTaskCompleted();
                    break;
                case 4: 
                    viewTasks();
                    break;
                case 5: 
                    exitProgram();
                    break;
                default: 
                    System.out.println("Invalid choice! Please choose a number between 1 and 5.");
                    break;
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter username: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Error: Username cannot be empty.");
            return;
        }
        if (findUserByName(name) != null) {
            System.out.println("Error: User already exists.");
            return;
        }

        users.add(new User(name));
        System.out.println("User '" + name + "' created successfully.");
    }

    private static void addTaskToUser() {
        User user = findUser();
        if (user == null) return;

        System.out.print("Enter task description: ");
        String taskDesc = scanner.nextLine().trim();

        if (taskDesc.isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
            return;
        }

        user.addTask(taskDesc);
        System.out.println("Task added successfully.");
    }

    private static void markTaskCompleted() {
        User user = findUser();
        if (user == null) return;

        System.out.print("Enter task description to mark as completed: ");
        String taskDesc = scanner.nextLine().trim();

        if (taskDesc.isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
            return;
        }

        if (user.markTaskCompleted(taskDesc)) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void viewTasks() {
        User user = findUser();
        if (user == null) return;

        user.printTasks();
    }

    private static User findUser() {
        System.out.print("Enter username: ");
        String name = scanner.nextLine().trim();

        User user = findUserByName(name);
        if (user == null) {
            System.out.println("User not found!");
        }
        return user;
    }

    private static User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    private static void exitProgram() {
        System.out.println("Exiting... Thanks for using the to-do list manager!");
        scanner.close();
        System.exit(0);
    }
}
