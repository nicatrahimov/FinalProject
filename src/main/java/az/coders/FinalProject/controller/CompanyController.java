package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    public CompanyService companyService;

    @GetMapping
    public CompanyResponseDto getAllCompanies(){
        companyService.getAllCompanies();
    }







}
