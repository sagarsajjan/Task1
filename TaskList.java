import java.util.LinkedList;
import java.util.Scanner;

public class TaskList {
    private LinkedList<String> tasks;
    private Scanner scanner;

    public TaskList() {
        tasks = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. List tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private void removeTask() {
        System.out.print("Enter task number to remove: ");
        int taskNum = scanner.nextInt();
        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.remove(taskNum - 1);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        new TaskList().start();
    }
}
