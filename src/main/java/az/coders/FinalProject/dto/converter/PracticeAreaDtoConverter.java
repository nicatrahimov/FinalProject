package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.response.PracticeAreaResponseDto;
import az.coders.FinalProject.model.PracticeArea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PracticeAreaDtoConverter {

    private final ImageDtoConverter imageDtoConverter;

    public PracticeAreaResponseDto toResponseDto(PracticeArea practiceArea){
        return PracticeAreaResponseDto.builder()
                .id(practiceArea.getId())
                .name(practiceArea.getName())
                .city(practiceArea.getCity())
                .isActiveCase(practiceArea.getIsActiveCase())
                .image(imageDtoConverter.toImageResponseDto(practiceArea.getImage()))
                .build();
    }

}
