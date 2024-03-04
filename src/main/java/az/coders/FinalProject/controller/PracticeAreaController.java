package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.request.PracticeAreaRequestDto;
import az.coders.FinalProject.dto.response.PracticeAreaResponseDto;
import az.coders.FinalProject.service.PracticeAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practice-area")
@RequiredArgsConstructor
public class PracticeAreaController {

    private final PracticeAreaService practiceAreaService;

    @GetMapping
    public ResponseEntity<List<PracticeAreaResponseDto>> getAll() {
        return new ResponseEntity<>(practiceAreaService.getAll(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<String> addPracticeArea(@RequestBody PracticeAreaRequestDto practiceAreaResponseDto) {
        return new ResponseEntity<>(practiceAreaService.addPracticeArea(practiceAreaResponseDto), HttpStatusCode.valueOf(200));
    }

//    TODO edit practice area with id or name

}
