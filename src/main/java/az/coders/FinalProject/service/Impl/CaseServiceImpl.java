package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.CaseDtoConverter;
import az.coders.FinalProject.dto.request.CaseRequestDto;
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
        return caseRepository
                .findAll()
                .stream()
                .map(caseDtoConverter::toResponseDto)
                .toList();
    }

    @Override
    public CaseResponseDto getCaseById(String id) {
        if(id==null){
            throw new NullPointerException("Case Id can not be null");
        }
        Case aCase = caseRepository.findById(id).orElseThrow(() -> new RuntimeException("Case not found with id: " + id));
        return caseDtoConverter.toResponseDto(aCase);
    }

    @Override
    public String addCase(CaseRequestDto caseRequestDto) {
        if (caseRequestDto==null){
            throw new NullPointerException("Case can not be null");
        }
        Case aCase = caseDtoConverter.toEntity(caseRequestDto);
        caseRepository.save(aCase);
        return "Case added successfully";
    }

    @Override
    public String deleteCase(String id) {
        if (id == null) {
            throw new NullPointerException("Id can not be null");
        }
        caseRepository.findById(id).orElseThrow(() -> new RuntimeException("Case not found with id: " + id));
        caseRepository.deleteById(id);
        return "Successfully deleted:" + id;
    }
}
