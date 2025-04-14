package dev.devtalles.proyecto.task.model;

import dev.devtalles.proyecto.task.exceptions.TaskException;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    List<Task> tasks = new ArrayList<>();

    public void save(Task task) throws TaskException {
        if(task==null) {
            throw new TaskException("The task could not be null");
        }
        tasks.add(task);
    }

    public Task findByID(String id) {
        for(Task task : tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public void remove(Task task ) throws TaskException {
        if(task==null) {
            throw new TaskException("The task could not be null");
        }

        if(!tasks.contains(task)) {
            throw new TaskException("The task does not exist on the list");
        }

        tasks.remove(task);
    }

    public void remove(String id ) throws TaskException {
        Task task = findByID(id);

        if(task==null) {
            throw new TaskException("The task could not be null");
        }

        tasks.remove(task);
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
    }
}
