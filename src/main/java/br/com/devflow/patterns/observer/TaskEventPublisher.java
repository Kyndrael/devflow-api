package br.com.devflow.patterns.observer;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TaskEventPublisher {
    private final ApplicationEventPublisher publisher;
    public TaskEventPublisher(ApplicationEventPublisher publisher) { this.publisher = publisher; }
    public void publish(Long id, String title, String action) {
        publisher.publishEvent(new TaskEvent(id, title, action));
    }
}
