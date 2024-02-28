package az.coders.FinalProject.model;

import az.coders.FinalProject.enums.PeopleGroup;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
            String id;
    String firstName;
    String lastName;
    String email;
    String address;
    String city;
    String country;
    @Enumerated(EnumType.STRING)
    PeopleGroup peopleGroup;
    @PrePersist
    public void prePersist(){
        if (peopleGroup==null){
            peopleGroup=PeopleGroup.CLIENT;
        }
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id" ,referencedColumnName = "id")
    Image image;
}
