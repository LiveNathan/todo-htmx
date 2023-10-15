package dev.nathanlively.todohtmx.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetUsersResponse(

	@JsonProperty("data")
	List<GetUserDataItem> data,

	@JsonProperty("error")
	GetUserError getUserError,

	@JsonProperty("status")
	String status
) {
}