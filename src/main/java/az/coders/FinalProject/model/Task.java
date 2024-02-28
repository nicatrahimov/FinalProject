package az.coders.FinalProject.model;

import az.coders.FinalProject.enums.Priority;
import az.coders.FinalProject.util.LocalDateTimeWithoutSecondsSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonIgnore
    final LocalDateTime createdAt = LocalDateTime.now();

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime dueDate;

    String description;

    @Enumerated(EnumType.STRING)
    Priority priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reminder_id", referencedColumnName = "id")
    Reminder reminder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id")
    Case aCase;
}
