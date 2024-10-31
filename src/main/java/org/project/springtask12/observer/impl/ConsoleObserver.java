package org.project.springtask12.observer.impl;

import org.project.springtask12.model.Task;
import org.project.springtask12.observer.TaskObserver;

public class ConsoleObserver implements TaskObserver {
    @Override
    public void update(Task task) {
        System.out.println("Task updated: " + task);
    }
}
