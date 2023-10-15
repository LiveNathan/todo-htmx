package dev.nathanlively.todohtmx.tasks;

public record TaskRecord(String createdAt, String name, String description, int id, boolean completed, int userId, String updatedAt) {
}
