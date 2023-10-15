package dev.nathanlively.todohtmx.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetUserError(

	@JsonProperty("message")
	String message
) {
}