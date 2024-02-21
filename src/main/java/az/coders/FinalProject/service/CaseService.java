package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.response.CaseResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CaseService {


    List<CaseResponseDto> getAll();
    CaseResponseDto getCaseById(String id);
}
