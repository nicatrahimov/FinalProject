package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.PracticeAreaDtoConverter;
import az.coders.FinalProject.dto.request.PracticeAreaRequestDto;
import az.coders.FinalProject.dto.response.PracticeAreaResponseDto;
import az.coders.FinalProject.exception.PracticeAreaNotFound;
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
    public PracticeAreaResponseDto getById(String id) {
        PracticeArea practiceArea = practiceAreaRepository.findById(id).orElseThrow(() -> new PracticeAreaNotFound("Practice area not found with id: " + id));
        return paConverter.toResponseDto(practiceArea);
    }

    @Override
    public String addPracticeArea(PracticeAreaRequestDto practiceAreaRequestDto) {
        PracticeArea practiceArea = paConverter.toEntity(practiceAreaRequestDto);
        practiceAreaRepository.save(practiceArea);
        return "Practice area added successfully";
    }

    @Override
    public String editPracticeArea(PracticeAreaRequestDto practiceAreaRequestDto) {
        PracticeArea practiceArea = paConverter.toEntity(practiceAreaRequestDto);
        practiceAreaRepository.save(practiceArea);
        return "Practice area edited successfully";
    }

    @Override
    public String deletePracticeArea(String id) {
        practiceAreaRepository.deleteById(id);
        return "Practice area deleted successfully";
    }
}
