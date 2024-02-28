package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.CaseRequestDto;
import az.coders.FinalProject.dto.response.CaseResponseDto;
import az.coders.FinalProject.dto.response.CaseTaskDto;
import az.coders.FinalProject.enums.CaseStage;
import az.coders.FinalProject.enums.Office;
import az.coders.FinalProject.exception.PracticeAreaNotFound;
import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.model.Task;
import az.coders.FinalProject.repository.PracticeAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CaseDtoConverter {

    private final ImageDtoConverter imageDtoConverter;
    private final PracticeAreaDtoConverter practiceAreaDtoConverter;
    private final ReminderDtoConverter reminderDtoConverter;
    private final PracticeAreaRepository practiceAreaRepository;


    public CaseResponseDto toResponseDto(Case caseEntity) {
        return CaseResponseDto.builder()
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
                .taskList(
                        caseEntity
                                .getTaskList()
                                .stream()
                                .map(this::toCaseTaskDto)
                                .toList()
                )
                .build();
    }


    private CaseTaskDto toCaseTaskDto(Task task){
        return CaseTaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .priority(task.getPriority().toString().toUpperCase())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .reminder(reminderDtoConverter.toResponseDto(task.getReminder()))
                .build();
    }

    public Case toEntity(CaseRequestDto caseRequestDto) {
        return Case.builder()
                .description(caseRequestDto.getDescription())
                .caseNumber(caseRequestDto.getCaseNumber())
                .phoneNumber(caseRequestDto.getPhoneNumber())
                .caseStage(CaseStage.valueOf(caseRequestDto.getCaseStage()))
                .office(Office.valueOf(caseRequestDto.getOffice()))
                .name(caseRequestDto.getName())
                .dueDate(caseRequestDto.getDueDate())
                .practiceArea(practiceAreaRepository.findById(caseRequestDto.getPracticeAreaId())
                        .orElseThrow(()->new PracticeAreaNotFound("Practice area not found")))
                .build();

    }


}
