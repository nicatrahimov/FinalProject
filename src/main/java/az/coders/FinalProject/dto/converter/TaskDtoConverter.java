package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.TaskRequestDto;
import az.coders.FinalProject.dto.response.TaskResponseDto;
import az.coders.FinalProject.enums.Priority;
import az.coders.FinalProject.exception.CaseNotFoundException;
import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.model.Task;
import az.coders.FinalProject.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskDtoConverter {
    private final CaseDtoConverter caseDtoConverter;
    private final ReminderDtoConverter reminderDtoConverter;
    private final CaseRepository caseRepository;

    public TaskResponseDto convertToDto(Task task) {
        return TaskResponseDto.builder()
                .id(task.getId())
                .name(task.getName())
                .priority(task.getPriority().toString())
                .description(task.getDescription())
                .caseDto(caseDtoConverter.toResponseDTO(task.getACase()))
                .dueDate(task.getDueDate())
                .reminder(reminderDtoConverter.toResponseDto(task.getReminder()))
                .build();
    }

    public Task convertToEntity(TaskRequestDto task) {
        Case aCase = caseRepository.findById(task.getCaseId()).orElseThrow(() -> new CaseNotFoundException("Case not found with id: " + task.getCaseId()));
        return Task.builder()
                .description(task.getDescription())
                .name(task.getName())
                .dueDate(task.getDueDate())
                .reminder(reminderDtoConverter.toEntity(task.getReminder()))
                .priority(Priority.valueOf(task.getPriority()))
                .aCase(aCase)
                .build();
    }
}
