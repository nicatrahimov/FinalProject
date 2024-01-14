package az.coders.FinalProject.model;

import az.coders.FinalProject.enums.PeopleGroup;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String firstName;
    String lastName;
    String email;
    String address;
    String city;
    String country;
    @Enumerated(EnumType.STRING)
    PeopleGroup peopleGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id" ,referencedColumnName = "id")
    Image image;

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    Company company;
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
    Set<Email>receivedEmails;
}
