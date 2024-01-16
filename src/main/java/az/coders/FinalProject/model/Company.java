package az.coders.FinalProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    @Email
    String email;

    String website;
    String phoneNumber;
    String faxNumber;
    String city;
    String address;
    String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id" ,referencedColumnName = "id")
    Image image;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    Set<Contact> contacts =new HashSet<>();

}
