package dev.nathanlively.todohtmx.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoItemFormData {

    private String userId;
    private String name;
    private String description;
    private Boolean completed;

    public TodoItemFormData(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.description = "description";
        this.completed = false;
    }
}
