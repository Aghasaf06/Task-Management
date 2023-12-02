package taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taskmanagement.model.JWTToken;
import taskmanagement.model.request.UserCreateRequest;
import taskmanagement.model.request.UserSignInRequest;
import taskmanagement.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public JWTToken signUp(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        return userService.signUp(userCreateRequest);
    }

    @PostMapping("/sign-in")
    public JWTToken signIn(@RequestBody @Valid UserSignInRequest userSignInRequest) {
        return userService.signIn(userSignInRequest);
    }
}