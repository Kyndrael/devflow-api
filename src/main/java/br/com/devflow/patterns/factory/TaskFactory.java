package br.com.devflow.patterns.factory;

import br.com.devflow.task.Task;
import br.com.devflow.task.TaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {
    public Task create(TaskRequest request) {
        return new Task(request.title().trim(), request.description(),
            request.priority(), request.dueDate());
    }
}
