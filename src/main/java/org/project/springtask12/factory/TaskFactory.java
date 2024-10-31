package org.project.springtask12.factory;

import org.project.springtask12.model.Task;

public interface TaskFactory {
    Task createTask(String title, String description);
}
