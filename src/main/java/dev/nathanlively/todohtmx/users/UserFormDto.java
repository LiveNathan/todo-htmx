package dev.nathanlively.todohtmx.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFormDto {
    private String email;
    private String first_name;
    private String last_name;
}
