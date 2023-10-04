package dev.nathanlively.todohtmx.task;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostUserTaskResponse(
		@JsonProperty("data") PostTaskRecord postTaskRecord,
		@JsonProperty("error") Error error,
		@JsonProperty("status") String status
) {}