package az.coders.FinalProject.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaseTaskDto {
    String id;
    String name;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime dueDate;
    String description;
    @Pattern(regexp = "LOW|MEDIUM|HIGH", message = "Priority should be LOW, MEDIUM or HIGH")
    String priority;
    ReminderResponseDto reminder;
}
