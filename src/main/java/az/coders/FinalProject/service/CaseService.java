package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.request.CaseRequestDto;
import az.coders.FinalProject.dto.response.CaseResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CaseService {


    List<CaseResponseDto> getAll();
    CaseResponseDto getCaseById(String id);

    String addCase(CaseRequestDto caseRequestDto);

    String deleteCase(String id);

    String editCase(CaseRequestDto caseRequestDto);
}
