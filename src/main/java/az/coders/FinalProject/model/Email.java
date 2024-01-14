package az.coders.FinalProject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String title;
    String body;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    Contact contact;
}
