package taskmanagement.service;

import taskmanagement.model.JWTToken;
import taskmanagement.model.request.UserCreateRequest;
import taskmanagement.model.request.UserSignInRequest;

public interface UserService {
    JWTToken signUp(UserCreateRequest accountCreateRequest);

    JWTToken signIn(UserSignInRequest userSignInRequest);
}