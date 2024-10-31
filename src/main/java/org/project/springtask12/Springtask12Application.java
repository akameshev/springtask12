package org.project.springtask12;

import org.project.springtask12.factory.impl.NormalTaskFactory;
import org.project.springtask12.factory.TaskFactory;
import org.project.springtask12.factory.impl.UrgentTaskFactory;
import org.project.springtask12.model.Task;
import org.project.springtask12.observer.impl.ConsoleObserver;
import org.project.springtask12.service.TaskManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springtask12Application {

	public static void main(String[] args) {
		SpringApplication.run(Springtask12Application.class, args);
	}
	@Bean
	public CommandLineRunner run(TaskManager taskManager) {
		return args -> {
			// Создание наблюдателя
			ConsoleObserver consoleObserver = new ConsoleObserver();
			taskManager.addObserver(consoleObserver);

			// Создание фабрики
			TaskFactory normalTaskFactory = new NormalTaskFactory();
			TaskFactory urgentTaskFactory = new UrgentTaskFactory();

			// Создание задач
			Task normalTask = normalTaskFactory.createTask("Normal Task", "This is a normal task.");
			Task urgentTask = urgentTaskFactory.createTask("Urgent Task", "This is an urgent task.");

			// Добавление задач в менеджер
			taskManager.addTask(normalTask);
			taskManager.addTask(urgentTask);

			// Завершение задачи
			normalTask.complete();
			taskManager.addTask(normalTask);
		};
	}

}
