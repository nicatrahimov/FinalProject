package az.coders.FinalProject.model;


import az.coders.FinalProject.enums.CaseStage;
import az.coders.FinalProject.enums.Office;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    final LocalDate createdAt = LocalDate.now();
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    Office office;
    @Enumerated(EnumType.STRING)
    CaseStage caseStage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    Image image;


    @ManyToOne
    @JoinColumn(name = "practice_area_id")
    PracticeArea practiceArea;

    @OneToMany(mappedBy = "aCase", fetch = FetchType.LAZY)
    List<Task> taskList;


    @OneToOne(mappedBy = "aCase", fetch = FetchType.LAZY)
    @JsonIgnore
    Company company;

}
