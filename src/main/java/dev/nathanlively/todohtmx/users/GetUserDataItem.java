package dev.nathanlively.todohtmx.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetUserDataItem(

	@JsonProperty("updated_at")
	long updatedAt,

	@JsonProperty("last_name")
	String lastName,

	@JsonProperty("created_at")
	long createdAt,

	@JsonProperty("id")
	int id,

	@JsonProperty("first_name")
	String firstName,

	@JsonProperty("email")
	String email
) {
}