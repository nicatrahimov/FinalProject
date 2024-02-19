package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.request.LoginRequest;
import az.coders.FinalProject.dto.request.SignUpRequest;
import az.coders.FinalProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;



    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<String>register(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(userService.registerUser(signUpRequest));
    }
}
