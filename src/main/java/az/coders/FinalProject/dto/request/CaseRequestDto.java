package az.coders.FinalProject.dto.request;

import az.coders.FinalProject.dto.response.PracticeAreaResponseDto;
import az.coders.FinalProject.enums.CaseStage;
import az.coders.FinalProject.enums.Office;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.model.PracticeArea;
import az.coders.FinalProject.model.Task;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaseRequestDto {
    String id;
    String name;
    String phoneNumber;
    String caseNumber;
    String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dueDate;
    @Pattern(regexp = "OPEN|IN_PROGRESS|CLOSED", message = "Case stage should be OPEN, IN_PROGRESS or CLOSED")
    String office;
    @Pattern(regexp = "Head Office|Branch Office|Regional Office|Home Office", message = "Case stage should be Head Office, Branch Office, Regional Office or Home Office")
    String caseStage;
    String base64;
    String practiceAreaId;
}
