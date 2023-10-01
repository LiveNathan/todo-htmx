package dev.nathanlively.todohtmx.tasks;

import java.util.List;

public record GetUserTasksResponse(List<DataItem> data, Error error, String status)
{
}