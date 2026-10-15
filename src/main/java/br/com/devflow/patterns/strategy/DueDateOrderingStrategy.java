package br.com.devflow.patterns.strategy;

import br.com.devflow.task.Task;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("dueDateOrdering")
public class DueDateOrderingStrategy implements TaskOrderingStrategy {
    public List<Task> order(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparing(
            Task::getDueDate, Comparator.nullsLast(Comparator.naturalOrder()))).toList();
    }
    public String name() { return "dueDate"; }
}
