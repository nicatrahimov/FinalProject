package az.coders.FinalProject.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {
    String id;
    String name;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime dueDate;
    String description;
    String priority;
    ReminderResponseDto reminder;
    TaskCaseDto caseDto;
}
