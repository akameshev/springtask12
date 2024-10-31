package org.project.springtask12.service;

import org.project.springtask12.model.Task;
import org.project.springtask12.observer.TaskObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskManager {
    private static TaskManager instance;

    private List<Task> tasks;
    private List<TaskObserver> observers;

    private TaskManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers(task);
    }

    private void notifyObservers(Task task) {
        for (TaskObserver observer : observers) {
            observer.update(task);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
