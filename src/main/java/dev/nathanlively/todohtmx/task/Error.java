package dev.nathanlively.todohtmx.task;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Error(
		@JsonProperty("message") String message
) {}