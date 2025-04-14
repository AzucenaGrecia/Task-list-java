package dev.devtalles.proyecto.task.controller;

import dev.devtalles.proyecto.task.exceptions.TaskException;
import dev.devtalles.proyecto.task.exceptions.TaskValidationException;
import dev.devtalles.proyecto.task.model.Task;
import dev.devtalles.proyecto.task.model.TaskRepository;

import java.util.List;

public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String id, String title, String description, Boolean completed) throws TaskException, TaskValidationException {
        validateTaskData(id, title, description, completed);
        Task task = new Task(id, title, description, completed);
        this.taskRepository.save(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(String id) throws TaskException, TaskValidationException {
        if(id == null || id.trim().isEmpty()){
            throw new TaskValidationException("Task id cannot be empty");
        }
        this.taskRepository.remove(id);
    }

    public void showTasks() throws TaskValidationException, TaskException {
        List<Task> tasks = this.taskRepository.findAll();

        if(tasks.isEmpty()){
            throw new TaskValidationException("The Task list cannot be empty");
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void showTasksCompleted() throws  TaskException {
        List<Task> completedTasks = this.taskRepository.findCompletedTask();
        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }

    public void showTasksPending() throws  TaskException {
        List<Task> pendingTasks = this.taskRepository.findPendingTask();
        for (Task task : pendingTasks) {
            System.out.println(task);
        }
    }

    public void updateTask(String id, String title, String description, Boolean completed) throws TaskException, TaskValidationException {
        validateTaskData(id, title, description, completed);
        Task updatedTask = new Task(id, title, description, completed);

        this.taskRepository.updateTask(updatedTask);
        System.out.println("Task updated: " + updatedTask);
    }

    public void updateTask(String id, Boolean completed) throws TaskException, TaskValidationException {
        validateTaskData(id, completed);

        this.taskRepository.updateTaskStatus(id, completed);
        System.out.println("Task status updated: " + completed);
    }


    private void validateTaskData(String id, String title, String description, Boolean completed) throws TaskValidationException {
        if(id == null || id.trim().isEmpty()){
            throw new TaskValidationException("Task id cannot be empty");
        }

        if(title == null || title.trim().isEmpty()){
            throw new TaskValidationException("Task title cannot be empty");
        }

        if(description == null || description.trim().isEmpty()){
            throw new TaskValidationException("Task description cannot be empty");
        }

        if(completed == null){
            throw new TaskValidationException("Task completed cannot be null");
        }

    }

    private void validateTaskData(String id, Boolean completed) throws TaskValidationException {
        if(id == null || id.trim().isEmpty()){
            throw new TaskValidationException("Task id cannot be empty");
        }

        if(completed == null){
            throw new TaskValidationException("Task completed cannot be null");
        }

    }
}
