package az.coders.FinalProject.model;

import az.coders.FinalProject.enums.Priority;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonIgnore
    final LocalDate createdAt = LocalDate.now();

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dueDate;

    String description;

    @Enumerated(EnumType.STRING)
    Priority priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reminder_id", referencedColumnName = "id")
    Reminder reminder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="case_id",referencedColumnName = "id")
    Case aCase;
}
