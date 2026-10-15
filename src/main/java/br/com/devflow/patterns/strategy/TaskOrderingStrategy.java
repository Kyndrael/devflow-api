package br.com.devflow.patterns.strategy;

import br.com.devflow.task.Task;
import java.util.List;

public interface TaskOrderingStrategy {
    List<Task> order(List<Task> tasks);
    String name();
}
