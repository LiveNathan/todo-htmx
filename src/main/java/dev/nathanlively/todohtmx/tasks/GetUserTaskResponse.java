package dev.nathanlively.todohtmx.tasks;

import java.util.List;

public record GetUserTaskResponse(TaskRecord taskRecord, Error error, String status)
{
}