package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.response.CaseResponseDto;
import az.coders.FinalProject.dto.response.TaskCaseDto;
import az.coders.FinalProject.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/case")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @GetMapping("/all")
    public ResponseEntity<List<CaseResponseDto>> getAll() {
        return new ResponseEntity<>(caseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseResponseDto> getCaseById(@PathVariable String id) {
        return new ResponseEntity<>(caseService.getCaseById(id), HttpStatus.OK);
    }

}
