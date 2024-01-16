package az.coders.FinalProject.model;

import az.coders.FinalProject.enums.Priority;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate startTime;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate finishTime;

    String description;

    @Enumerated(EnumType.STRING)
    Priority priority;
}
