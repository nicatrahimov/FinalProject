package az.coders.FinalProject.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private String address;
   private String username;
   private String password;
   private String email;
}
