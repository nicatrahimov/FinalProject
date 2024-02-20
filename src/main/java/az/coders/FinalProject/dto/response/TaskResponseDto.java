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
public class TaskResponseDto {
    String id;
    String name;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Baku")
    LocalDate dueDate;
    String description;
    String priority;
    ReminderResponseDto reminder;
    CaseResponseDto caseDto;
}
