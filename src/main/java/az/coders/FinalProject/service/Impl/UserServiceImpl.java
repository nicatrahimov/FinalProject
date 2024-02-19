package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.request.LoginRequest;
import az.coders.FinalProject.dto.request.SignUpRequest;
import az.coders.FinalProject.model.User;
import az.coders.FinalProject.repository.UserRepository;
import az.coders.FinalProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(SignUpRequest sign) {
        if (sign.getEmail()!=null && sign.getPassword()!=null) {
            User checkUser = userRepository.findUserByEmail(sign.getEmail()).orElse(null);
            if (checkUser != null) {
                throw new NullPointerException("User already exists");
            }else {
                if (sign!=null){
                    User user = User.builder()
                            .firstName(sign.getFirstName())
                            .lastName(sign.getLastName())
                            .phoneNumber(sign.getPhoneNumber())
                            .username(sign.getUsername())
                            .email(sign.getEmail())
                            .address(sign.getAddress())
                            .password(passwordEncoder.encode(sign.getPassword()))
                            .build();
                    userRepository.save(user);
                    return "User created successfully. ID: "+user.getId();
                }else throw new NullPointerException("User can not be null");
            }
        }else throw new NullPointerException("Email and password can not be empty");
    }

    @Override
    public String loginUser(LoginRequest loginRequest) {
        if (loginRequest.getEmail()!=null && loginRequest.getPassword()!=null){
            User user = userRepository.findUserByEmail(loginRequest.getEmail()).orElseThrow(() -> new NullPointerException("Wrong email"));
            if (user!= null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()) ) {
                return "Login is successful";
            }else throw new NullPointerException("Wrong email or password");
        }else throw new NullPointerException("Email and password can not be empty");
    }
}
