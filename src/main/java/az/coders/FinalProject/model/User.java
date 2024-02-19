package az.coders.FinalProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @NotBlank(message = "First name cannot be empty")
    String firstName;
    @NotBlank(message = "Last name cannot be empty")
    String lastName;
    @NotBlank(message = "Phone number cannot be empty")
    String phoneNumber;
    @NotBlank(message = "Address cannot be empty")
    String address;

    @NotBlank(message = "Username cannot be empty")
    String username;

    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password must meet the criteria")
    String password;

    @NotBlank(message = "Email cannot be empty")
    @Email
    String email;
}
