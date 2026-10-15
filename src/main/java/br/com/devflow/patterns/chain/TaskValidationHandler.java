package br.com.devflow.patterns.chain;

import br.com.devflow.task.TaskRequest;

public abstract class TaskValidationHandler {
    private TaskValidationHandler next;
    public TaskValidationHandler linkWith(TaskValidationHandler next) {
        this.next = next; return next;
    }
    public final void handle(TaskRequest request) {
        validate(request);
        if (next != null) next.handle(request);
    }
    protected abstract void validate(TaskRequest request);
}
