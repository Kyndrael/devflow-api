package br.com.devflow.patterns.chain;

import br.com.devflow.task.TaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TitleValidationHandler extends TaskValidationHandler {
    protected void validate(TaskRequest request) {
        if (request.title() == null || request.title().isBlank())
            throw new IllegalArgumentException("O título da tarefa é obrigatório.");
    }
}
