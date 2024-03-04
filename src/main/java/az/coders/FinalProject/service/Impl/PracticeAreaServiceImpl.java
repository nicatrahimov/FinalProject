package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.PracticeAreaDtoConverter;
import az.coders.FinalProject.dto.request.PracticeAreaRequestDto;
import az.coders.FinalProject.dto.response.PracticeAreaResponseDto;
import az.coders.FinalProject.model.PracticeArea;
import az.coders.FinalProject.repository.PracticeAreaRepository;
import az.coders.FinalProject.service.PracticeAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PracticeAreaServiceImpl implements PracticeAreaService {

    private final PracticeAreaRepository practiceAreaRepository;
    private final PracticeAreaDtoConverter paConverter;
    @Override
    public List<PracticeAreaResponseDto> getAll() {
        List<PracticeAreaResponseDto> dtos = new ArrayList<>();
        for(PracticeArea practiceArea : practiceAreaRepository.findAll()){
            PracticeAreaResponseDto responseDto = paConverter.toResponseDto(practiceArea);
            dtos.add(responseDto);
        }
        return dtos;
    }

    @Override
    public String addPracticeArea(PracticeAreaRequestDto practiceAreaRequestDto) {
        PracticeArea practiceArea = paConverter.toEntity(practiceAreaRequestDto);
        practiceAreaRepository.save(practiceArea);
        return "Practice area added or edited successfully";
    }
}
