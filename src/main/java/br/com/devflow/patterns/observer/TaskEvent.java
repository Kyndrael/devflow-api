package br.com.devflow.patterns.observer;

public record TaskEvent(Long taskId, String taskTitle, String action) {}
