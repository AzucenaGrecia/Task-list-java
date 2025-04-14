package dev.devtalles.proyecto;

import dev.devtalles.proyecto.task.controller.TaskController;
import dev.devtalles.proyecto.task.model.TaskRepository;
import dev.devtalles.proyecto.task.view.TaskView;

public class Main {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();
        TaskController taskController = new TaskController(taskRepository);
        TaskView taskView = new TaskView(taskController);

        taskView.showMenu();

    }
}