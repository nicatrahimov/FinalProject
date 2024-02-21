package az.coders.FinalProject.dto.request;

import az.coders.FinalProject.enums.Priority;
import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.model.Reminder;
import az.coders.FinalProject.util.LocalDateTimeWithoutSecondsSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    @NotBlank(message = "Task id cannot be empty")
    String id;
    @NotBlank(message = "Task name cannot be empty")
    private String name;

    @NotBlank(message = "Due date cannot be empty")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dueDate;

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
