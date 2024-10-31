package org.project.springtask12.factory.impl;

import org.project.springtask12.model.Task;
import org.project.springtask12.factory.TaskFactory;

public class NormalTaskFactory implements TaskFactory {
    @Override
    public Task createTask(String title, String description) {
        return new Task(title, description);
    }
}

