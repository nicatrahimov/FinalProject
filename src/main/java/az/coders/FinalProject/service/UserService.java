package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.request.LoginRequest;
import az.coders.FinalProject.dto.request.SignUpRequest;
import az.coders.FinalProject.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    String registerUser(SignUpRequest signUpRequest);
    String loginUser(LoginRequest loginRequest);


}
