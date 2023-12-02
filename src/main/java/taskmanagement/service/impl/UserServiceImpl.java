package taskmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import taskmanagement.dao.entity.User;
import taskmanagement.dao.repository.UserRepository;
import taskmanagement.mapper.UserMapper;
import taskmanagement.model.JWTToken;
import taskmanagement.model.request.UserCreateRequest;
import taskmanagement.model.request.UserSignInRequest;
import taskmanagement.security.JWTProvider;
import taskmanagement.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;
    @Override
    public JWTToken signUp(UserCreateRequest userCreateRequest) {
        var isExist = userRepository.existsByEmailAndIsActiveTrue(userCreateRequest.getEmail());
        if (isExist) {
            throw new RuntimeException("User exist with this email");
        }
        User user = buildUser(userCreateRequest);
        userRepository.save(user);

        return jwtProvider.getJWTToken(user.getUsername(), userCreateRequest.getIsRememberMe());
    }

    @Override
    public JWTToken signIn(UserSignInRequest userSignInRequest) {
        User user = userRepository.findByEmailAndIsActiveTrue(userSignInRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User is not found with this email"));
        boolean isMatch = passwordEncoder.matches(userSignInRequest.getPassword(), user.getPassword());

        if (isMatch)
            return jwtProvider.getJWTToken(user.getUsername(), userSignInRequest.getIsRememberMe());
        throw new RuntimeException("Bad Credentials");
    }
    private User buildUser(UserCreateRequest userCreateRequest) {
        User user = UserMapper.INSTANCE.userCreateRequesttoUser(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}
