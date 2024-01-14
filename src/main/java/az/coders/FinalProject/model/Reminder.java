package az.coders.FinalProject.model;

import az.coders.FinalProject.enums.TimeType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Integer timePeriod;
    @Enumerated(EnumType.STRING)
    TimeType timeType;
}
