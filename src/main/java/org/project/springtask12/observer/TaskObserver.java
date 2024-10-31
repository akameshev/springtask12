package org.project.springtask12.observer;

import org.project.springtask12.model.Task;

public interface TaskObserver {
    void update(Task task);
}
