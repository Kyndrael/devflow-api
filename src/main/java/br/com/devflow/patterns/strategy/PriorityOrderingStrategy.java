package br.com.devflow.patterns.strategy;

import br.com.devflow.task.Task;
import br.com.devflow.task.TaskPriority;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("priorityOrdering")
public class PriorityOrderingStrategy implements TaskOrderingStrategy {
    private static final java.util.Map<TaskPriority, Integer> WEIGHTS = java.util.Map.of(
        TaskPriority.URGENT, 0, TaskPriority.HIGH, 1, TaskPriority.MEDIUM, 2, TaskPriority.LOW, 3);
    public List<Task> order(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparingInt(t -> WEIGHTS.get(t.getPriority()))).toList();
    }
    public String name() { return "priority"; }
}
