package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.CaseDtoConverter;
import az.coders.FinalProject.dto.response.CaseResponseDto;
import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.repository.CaseRepository;
import az.coders.FinalProject.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;
    private final CaseDtoConverter caseDtoConverter;
    @Override
    public List<CaseResponseDto> getAll() {
        return null;
    }

    @Override
    public CaseResponseDto getCaseById(String id) {
        Case aCase = caseRepository.findById(id).orElseThrow(() -> new RuntimeException("Case not found with id: " + id));
        caseDtoConverter.toResponseDTO(aCase);
        return


    }
}
