package br.com.devflow.patterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskAuditListener {
    private static final Logger log = LoggerFactory.getLogger(TaskAuditListener.class);
    @EventListener
    public void onTaskEvent(TaskEvent event) {
        log.info("Evento de tarefa: action={}, id={}, title='{}'",
            event.action(), event.taskId(), event.taskTitle());
    }
}
