package dev.nathanlively.todohtmx;

import dev.nathanlively.todohtmx.task.PostUserTaskResponse;
import dev.nathanlively.todohtmx.tasks.GetUserTasksResponse;
import dev.nathanlively.todohtmx.tasks.TodoItemFormData;
import dev.nathanlively.todohtmx.users.GetUsersResponse;
import dev.nathanlively.todohtmx.users.UserFormDto;
import io.github.wimdeblauwe.hsbt.mvc.HxRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @HxRequest
    @GetMapping("users")
    public String showAllUsersHtmx(Model model) {

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
        return "fragments/usersFragment :: combinedFragment";
    }

    @HxRequest
    @GetMapping("users/create")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userFormDto", new UserFormDto());
        return "fragments/registrationFormFragment :: registrationFormFragment";
    }

    @HxRequest
    @PostMapping("users/create")
    public String submitRegistrationForm(@ModelAttribute UserFormDto userFormDto, Model model) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserFormDto> entity = new HttpEntity<>(userFormDto, headers);

        restTemplate.exchange(
                "http://demo.codingnomads.co:8080/tasks_api/users",
                HttpMethod.POST,
                entity,
                Void.class
        );

        return "redirect:/users";
    }

    @HxRequest
    @GetMapping("users/tasks")
    public String showUsersTaks(Model model, @RequestParam String userId) {

        ResponseEntity<GetUserTasksResponse> response = restTemplate.exchange(
                "http://demo.codingnomads.co:8080/tasks_api/users/" + userId + "/tasks",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        GetUserTasksResponse responseBody = response.getBody();

        assert responseBody != null;
        model.addAttribute("tasks", responseBody.data());
        model.addAttribute("task", new TodoItemFormData(userId, ""));
        return "fragments/tasksFragment :: tasksFragment";
    }

    @HxRequest
    @PostMapping("tasks")
    public String addTodoItem(TodoItemFormData task, Model model) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TodoItemFormData> entity = new HttpEntity<>(task, headers);

        ResponseEntity<PostUserTaskResponse> taskResponse = restTemplate.exchange(
                "http://demo.codingnomads.co:8080/tasks_api/tasks",
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {}
        );
        PostUserTaskResponse responseBody = taskResponse.getBody();

        assert responseBody != null;
        model.addAttribute("task", responseBody.postTaskRecord());

//        response.setHeader("HX-Trigger", "itemAdded");
        return "fragments/taskFragment :: taskFragment";
    }

}
