package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.request.CompanyRequestDto;
import az.coders.FinalProject.dto.request.EditContactRequest;
import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    public final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyResponseDto>> getAllCompanies(){
       return new
               ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCompanyById(@PathVariable String id){
        return new
                ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody CompanyRequestDto requestDto){
        return new
                ResponseEntity<>(companyService.addCompany(requestDto),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>editCompany(@RequestBody CompanyRequestDto requestDto){
    return new
            ResponseEntity<>(companyService.editCompany(requestDto),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteCompanyById(@PathVariable String id){
        return new
                ResponseEntity<>(companyService.deleteCompany(id),HttpStatus.OK);
    }
}
