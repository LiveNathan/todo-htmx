package dev.nathanlively.todohtmx.task;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostTaskRecord(
		@JsonProperty("createdAt") long createdAt,
		@JsonProperty("name") String name,
		@JsonProperty("description") String description,
		@JsonProperty("id") int id,
		@JsonProperty("completed") boolean completed,
		@JsonProperty("userId") int userId,
		@JsonProperty("updatedAt") long updatedAt
) {}