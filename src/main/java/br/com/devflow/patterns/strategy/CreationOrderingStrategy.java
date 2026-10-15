package br.com.devflow.patterns.strategy;

import br.com.devflow.task.Task;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("creationOrdering")
public class CreationOrderingStrategy implements TaskOrderingStrategy {
    public List<Task> order(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(Task::getCreatedAt,
            Comparator.nullsLast(Comparator.naturalOrder()))).toList();
    }
    public String name() { return "createdAt"; }
}
