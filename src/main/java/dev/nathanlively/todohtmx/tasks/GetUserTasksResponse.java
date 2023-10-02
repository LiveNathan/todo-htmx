package dev.nathanlively.todohtmx.tasks;

import java.util.List;

public record GetUserTasksResponse(List<TaskRecord> data, Error error, String status)
{
}