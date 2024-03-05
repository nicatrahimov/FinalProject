package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.PracticeAreaRequestDto;
import az.coders.FinalProject.dto.response.PracticeAreaResponseDto;
import az.coders.FinalProject.exception.PracticeAreaNotFound;
import az.coders.FinalProject.model.PracticeArea;
import az.coders.FinalProject.repository.PracticeAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PracticeAreaDtoConverter {

    private final ImageDtoConverter imageDtoConverter;
    private final PracticeAreaRepository practiceAreaRepository;


    public PracticeAreaResponseDto toResponseDto(PracticeArea practiceArea) {

        PracticeAreaResponseDto build = PracticeAreaResponseDto.builder()
                .id(practiceArea.getId())
                .name(practiceArea.getName())
                .city(practiceArea.getCity())
                .image(imageDtoConverter.toImageResponseDto(practiceArea.getImage()))
                .build();
        if (practiceArea.getCases().isEmpty()) {
            practiceArea.setIsActiveCase(false);
            build.setIsActiveCase(false);
            practiceAreaRepository.save(practiceArea);
        } else{
            practiceArea.setIsActiveCase(true);
            build.setIsActiveCase(true);
            practiceAreaRepository.save(practiceArea);
        }
        return build;
    }

    public PracticeArea toEntity(PracticeAreaRequestDto practiceAreaRequestDto) {
        if (practiceAreaRequestDto.getId() != null) {
            PracticeArea practiceArea = practiceAreaRepository.findById(practiceAreaRequestDto.getId()).orElseThrow(() -> new PracticeAreaNotFound("Practice area not found"));
            if (practiceArea.getName() != null) {
                practiceArea.setName(practiceAreaRequestDto.getName());
            }
            if (practiceArea.getCity() != null) {
                practiceArea.setCity(practiceAreaRequestDto.getCity());
            }
            if (practiceArea.getImage() != null) {
                practiceArea.setImage(imageDtoConverter.toImage(practiceAreaRequestDto.getImage()));
            }
            return practiceArea;
        } else {
            return setter(practiceAreaRequestDto);
        }

    }

    private PracticeArea setter(PracticeAreaRequestDto practiceAreaRequestDto) {

        return PracticeArea.builder()
                .name(practiceAreaRequestDto.getName())
                .city(practiceAreaRequestDto.getCity())
                .image(imageDtoConverter.toImage(practiceAreaRequestDto.getImage()))
                .isActiveCase(false)
                .build();
    }
}
