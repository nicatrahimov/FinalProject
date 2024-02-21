package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.response.TaskCaseDto;
import az.coders.FinalProject.model.Case;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CaseDtoConverter {

    private final ImageDtoConverter imageDtoConverter;
    private final PracticeAreaDtoConverter practiceAreaDtoConverter;

    public TaskCaseDto toResponseDTO(Case caseEntity) {
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
                .practiceArea(practiceAreaDtoConverter.toResponseEntity(caseEntity.getPracticeArea()))
                .build();
        // TODO
    }
}
