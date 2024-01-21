package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.request.CompanyRequestDto;
import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<CompanyResponseDto> getAllCompanies();
    CompanyResponseDto getCompanyById(String id);

    Company getCompanyEntityById(String id);

    String editCompany(CompanyRequestDto requestDto);

    String deleteCompany(CompanyRequestDto requestDto);

    String addCompany(CompanyRequestDto requestDto);
}
