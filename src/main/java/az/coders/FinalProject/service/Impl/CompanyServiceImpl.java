package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.CompanyDtoConverter;
import az.coders.FinalProject.dto.request.CompanyRequestDto;
import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.exception.CompanyNotFound;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.repository.CompanyRepository;
import az.coders.FinalProject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    private final CompanyDtoConverter companyDtoConverter;

    @Override
    public List<CompanyResponseDto> getAllCompanies() {
        List<Company> all = repository.findAll();
        List<CompanyResponseDto>dtos=new ArrayList<>();
        for (Company company:all){
            CompanyResponseDto responseDto = companyDtoConverter.toResponseDto(company);
            dtos.add(responseDto);
        }
        return dtos;
    }

    @Override
    public CompanyResponseDto getCompanyById(String id) {
        if (id!=null){
            Company company = repository.findById(id).orElseThrow(CompanyNotFound::new);
            return companyDtoConverter.toResponseDto(company);
        }else return new CompanyResponseDto();
    }

    @Override
    public Company getCompanyEntityById(String id) {
        return repository.findById(id).orElseThrow(CompanyNotFound::new);
    }

    @Override
    public String editCompany(CompanyRequestDto requestDto) {
        return null;
    }

    @Override
    public String deleteCompany(CompanyRequestDto requestDto) {
        return null;
    }

    @Override
    public String addCompany(CompanyRequestDto requestDto) {



    }
}
