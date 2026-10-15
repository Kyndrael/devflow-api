package br.com.devflow.task;
import jakarta.validation.constraints.NotNull;
public record StatusRequest(@NotNull TaskStatus status) {}
