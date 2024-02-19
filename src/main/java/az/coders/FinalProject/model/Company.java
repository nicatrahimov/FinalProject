package az.coders.FinalProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company",orphanRemoval = true)
    List<Contact> contacts =new ArrayList<>();


    public void addContact(Contact contact) {
        contacts.add(contact);
        contact.setCompany(this);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        contact.setCompany(null);
    }
}
