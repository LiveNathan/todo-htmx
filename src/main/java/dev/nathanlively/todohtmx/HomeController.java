package dev.nathanlively.todohtmx;

import dev.nathanlively.todohtmx.users.GetUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final RestTemplate restTemplate;

    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @GetMapping("users")
    public String showAllUsers(Model model) {

        ResponseEntity<GetUsersResponse> response = restTemplate.exchange(
                "http://demo.codingnomads.co:8080/tasks_api/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        GetUsersResponse responseBody = response.getBody();

        assert responseBody != null;
        model.addAttribute("users", responseBody.data());
        return "users";
    }
}
