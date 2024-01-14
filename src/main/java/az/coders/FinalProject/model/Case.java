package az.coders.FinalProject.model;


import az.coders.FinalProject.enums.CaseStage;
import az.coders.FinalProject.enums.Office;
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
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;
    String phoneNumber;
    String caseNumber;
    String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    final LocalDate createdAt=LocalDate.now();
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    Office office;
    @Enumerated(EnumType.STRING)
    CaseStage caseStage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    Image image;

    @OneToOne
    @JoinColumn(name = "practiceArea_id", referencedColumnName = "id")
    PracticeArea practiceArea;
}
