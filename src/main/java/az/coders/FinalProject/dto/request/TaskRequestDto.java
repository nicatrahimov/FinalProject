package az.coders.FinalProject.dto.request;

import az.coders.FinalProject.enums.Priority;
import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.model.Reminder;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    @NotBlank(message = "Task name cannot be empty")
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotBlank(message = "Due date cannot be empty")
    private LocalDate dueDate;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Priority cannot be empty")
    @Enumerated(EnumType.STRING)
    @Pattern(regexp = "LOW|MEDIUM|HIGH", message = "Priority should be LOW, MEDIUM or HIGH")
    private String priority;

    @NotNull(message = "Reminder cannot be empty")
    private ReminderRequestDto reminder;

    @NotBlank(message = "Case id cannot be empty")
    private String caseId;
}
