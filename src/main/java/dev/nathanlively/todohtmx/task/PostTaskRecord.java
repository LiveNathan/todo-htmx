package dev.nathanlively.todohtmx.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostTaskRecord {

    @JsonProperty("createdAt")
    long createdAt;

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("id")
    int id;

    @JsonProperty("completed")
    boolean completed;

    @JsonProperty("userId")
    int userId;

    @JsonProperty("updatedAt")
    long updatedAt;

    public String getUpdatedAtAsDateTime() {
        return convertLongToFormattedDate(updatedAt);
    }

    public String getCreatedAtAsDateTime() {
        return convertLongToFormattedDate(createdAt);
    }

    private String convertLongToFormattedDate(long dateInMillis) {
        Instant instant = Instant.ofEpochMilli(dateInMillis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MMM-yyyy");
        return dateTime.format(formatter);
    }
}