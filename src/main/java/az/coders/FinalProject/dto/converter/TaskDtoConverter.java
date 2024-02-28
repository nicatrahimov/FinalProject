package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.TaskRequestDto;
import az.coders.FinalProject.dto.response.TaskCaseDto;
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
    private final ReminderDtoConverter reminderDtoConverter;
    private final CaseRepository caseRepository;
    private final ImageDtoConverter imageDtoConverter;
    private final PracticeAreaDtoConverter practiceAreaDtoConverter;

    public TaskResponseDto convertToDto(Task task) {
        return TaskResponseDto.builder()
                .id(task.getId())
                .name(task.getName())
                .priority(task.getPriority().toString())
                .description(task.getDescription())
                .caseDto(toTaskCaseDto(task.getACase()))
                .dueDate(task.getDueDate())
                .reminder(reminderDtoConverter.toResponseDto(task.getReminder()))
                .build();
    }

    public Task convertToEntity(TaskRequestDto task) {
        return Task.builder()
                .description(task.getDescription())
                .name(task.getName())
                .dueDate(task.getDueDate())
                .reminder(reminderDtoConverter.toEntity(task.getReminder()))
                .priority(Priority.valueOf(task.getPriority()))
                .build();
    }

    private TaskCaseDto toTaskCaseDto(Case caseEntity) {
        return TaskCaseDto.builder()
                .id(caseEntity.getId())
                .name(caseEntity.getName())
                .phoneNumber(caseEntity.getPhoneNumber())
                .caseNumber(caseEntity.getCaseNumber())
                .description(caseEntity.getDescription())
                .dueDate(caseEntity.getDueDate())
                .office(caseEntity.getOffice().toString())
                .caseStage(caseEntity.getCaseStage().toString())
                .image(imageDtoConverter.toImageResponseDto(caseEntity.getImage()))
                .practiceArea(practiceAreaDtoConverter.toResponseDto(caseEntity.getPracticeArea()))
                .build();
    }
}
