package az.coders.FinalProject.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCaseDto {
    String id;
    String name;
    String phoneNumber;
    String caseNumber;
    String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dueDate;
    String office;
    String caseStage;
    ImageResponseDto image;
    PracticeAreaResponseDto practiceArea;
}
