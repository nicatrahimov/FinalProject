package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.request.CaseRequestDto;
import az.coders.FinalProject.dto.response.CaseResponseDto;
import az.coders.FinalProject.dto.response.TaskCaseDto;
import az.coders.FinalProject.model.Case;
import az.coders.FinalProject.repository.CaseRepository;
import az.coders.FinalProject.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/case")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @GetMapping
    public ResponseEntity<List<CaseResponseDto>> getAll() {
        return new ResponseEntity<>(caseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseResponseDto> getCaseById(@PathVariable String id) {
        return new ResponseEntity<>(caseService.getCaseById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addCase(@RequestBody CaseRequestDto caseRequestDto) {
        return new ResponseEntity<>(caseService.addCase(caseRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCase(@PathVariable String id) {
        return new ResponseEntity<>(caseService.deleteCase(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> editCase(@RequestBody CaseRequestDto caseRequestDto) {
        return new ResponseEntity<>(caseService.editCase(caseRequestDto), HttpStatus.OK);
    }


}
