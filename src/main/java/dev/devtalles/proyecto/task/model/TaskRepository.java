package dev.devtalles.proyecto.task.model;

import dev.devtalles.proyecto.task.exceptions.TaskException;
import dev.devtalles.proyecto.task.persistence.TaskPersistence;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    List<Task> tasks;

    public TaskRepository() {
        tasks = TaskPersistence.loadTasks();
    }

    public void save(Task task) throws TaskException {
        if(tasks.contains(task)) {
            throw new TaskException("The task already exists");
        }
        tasks.add(task);
        TaskPersistence.saveTask(tasks);
    }

    public Task findByID(String id) {
        for(Task task : tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> findCompletedTask() throws TaskException {
        List<Task> completedTasks = new ArrayList<>();

        for(Task task : tasks) {
            if(task.getCompleted()) {
                completedTasks.add(task);
            }
        }

        if(completedTasks.isEmpty()) {
            throw new TaskException("There is any completed Task!");
        }
        return completedTasks;
    }

    public List<Task> findPendingTask() throws TaskException {
        List<Task> pendingTasks = new ArrayList<>();

        for(Task task : tasks) {
            if(!task.getCompleted()) {
                pendingTasks.add(task);
            }
        }

        if(pendingTasks.isEmpty()) {
            throw new TaskException("There is any pending Task!");
        }
        return pendingTasks;
    }

    public void remove(Task task ) throws TaskException {
        if(task==null) {
            throw new TaskException("The task could not be null");
        }

        if(!tasks.contains(task)) {
            throw new TaskException("The task does not exist on the list");
        }

        tasks.remove(task);
        TaskPersistence.saveTask(tasks);
    }

    public void remove(String id ) throws TaskException {
        Task task = findByID(id);

        if(task==null) {
            throw new TaskException("The task could not be null");
        }

        tasks.remove(task);
        TaskPersistence.saveTask(tasks);
    }

    public List<Task> findAll() throws TaskException {
        if(tasks.isEmpty()) {
            throw new TaskException("The task list is empty");
        }
        return tasks;
    }

    public int findIndexById(String id) {
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    public void updateTask(Task updatedTask) throws TaskException {
        if(updatedTask==null) {
            throw new TaskException("The task could not be null");
        }
        int index = findIndexById(updatedTask.getId());

        if(index==-1) {
            throw new TaskException("The index is not found");
        }
        tasks.set(index, updatedTask);
        TaskPersistence.saveTask(tasks);
    }

    public void updateTaskStatus(String id, Boolean completed) throws TaskException {
        int index = findIndexById(id);

        if(index==-1) {
            throw new TaskException("The index is not found");
        }

        tasks.get(index).setCompleted(completed);
        TaskPersistence.saveTask(tasks);
    }
}
