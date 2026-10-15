package br.com.devflow.patterns.chain;

import br.com.devflow.task.TaskRequest;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class DueDateValidationHandler extends TaskValidationHandler {
    protected void validate(TaskRequest request) {
        if (request.dueDate() != null && request.dueDate().isBefore(LocalDate.now()))
            throw new IllegalArgumentException("O prazo não pode estar no passado.");
    }
}
