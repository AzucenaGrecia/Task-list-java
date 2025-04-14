package dev.devtalles.proyecto.task.view;

import dev.devtalles.proyecto.task.controller.TaskController;
import dev.devtalles.proyecto.task.exceptions.TaskException;
import dev.devtalles.proyecto.task.exceptions.TaskValidationException;
import dev.devtalles.proyecto.task.model.Task;

import java.util.Scanner;

public class TaskView {
    private final TaskController taskController;
    private final Scanner scanner;

    public TaskView(TaskController taskController) {
        this.taskController = taskController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n Task Management Menu: ");
            System.out.println("1. Create Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Update Task");
            System.out.println("4. Show all tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addTaskView();
                break;
                case "2":
                    removeTaskView();
                break;
                case "3":
                    updateTaskView();
                break;
                case "4":
                    showTaskView();
                break;
                case "0":
                    System.out.println("Goodbye!");
                return;
                default:
                    System.out.println("Invalid choice, please try again");
                break;

            }
        }
    }

    public void addTaskView(){
        try {
            Task task = getTaskInput();
            taskController.addTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());
            System.out.println("Task added successfully!");
        }
        catch (TaskException | TaskValidationException e) {
            System.out.println("Error : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error, please try to contact the support team." );
            e.printStackTrace();
        }

    }

    public void removeTaskView(){
        try {
            System.out.println("Enter Task ID to remove: ");
            String id = scanner.nextLine();
            this.taskController.removeTask(id);
            System.out.println("Task removed successfully!");
        }
        catch (TaskException | TaskValidationException e) {
            System.out.println("Error : " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unexpected error, please try to contact the support team." );
            e.printStackTrace();
        }
    }


    public void showTaskView(){
        try {
            System.out.println("\nList of Tasks: ");
            this.taskController.showTasks();
        }
        catch (TaskException | TaskValidationException e) {
            System.out.println("Error : " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unexpected error, please try to contact the support team." );
            e.printStackTrace();
        }
    }


    public void updateTaskView(){
        try {
           Task task = getTaskInput();
           taskController.updateTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());
           System.out.println("Task updated successfully!");
        }
        catch (TaskException | TaskValidationException e) {
            System.out.println("Error : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error, please try to contact the support team." );
            e.printStackTrace();
        }
    }

    private Task getTaskInput(){
        System.out.println("Enter Task ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter Task Title: ");
        String title = scanner.nextLine();

        System.out.println("Enter Task Description: ");
        String description = scanner.nextLine();

        System.out.println("Is Task Completed ? (true/false): ");
        Boolean completed = Boolean.parseBoolean(scanner.nextLine());

        return new Task(id, title, description, completed);
    }
}
