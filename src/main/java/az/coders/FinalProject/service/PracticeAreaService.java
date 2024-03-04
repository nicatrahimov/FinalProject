package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.request.PracticeAreaRequestDto;
import az.coders.FinalProject.dto.response.PracticeAreaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PracticeAreaService {
    List<PracticeAreaResponseDto> getAll();

    String addPracticeArea(PracticeAreaRequestDto practiceAreaRequestDto);
}
