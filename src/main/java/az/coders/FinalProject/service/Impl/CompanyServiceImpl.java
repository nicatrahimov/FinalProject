package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.CompanyDtoConverter;
import az.coders.FinalProject.dto.request.CompanyRequestDto;
import az.coders.FinalProject.dto.request.EditContactRequest;
import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.exception.CompanyNotFound;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.CompanyRepository;
import az.coders.FinalProject.repository.ContactRepository;
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
    private final ContactRepository contactRepository;

    @Override
    public List<CompanyResponseDto> getAllCompanies() {
        List<Company> all = repository.findAll();
        List<CompanyResponseDto> dtos = new ArrayList<>();
        for (Company company : all) {
            CompanyResponseDto responseDto = companyDtoConverter.toResponseDto(company);
            dtos.add(responseDto);
        }
        return dtos;
    }

    @Override
    public CompanyResponseDto getCompanyById(String id) {
        if (id != null) {
            Company company = repository.findById(id).orElseThrow(() -> new CompanyNotFound("Company not found with id: " + id));
            return companyDtoConverter.toResponseDto(company);
        } else throw new NullPointerException("Id can not be null");
    }

    @Override
    public Company getCompanyEntityById(String id) {
        return repository.findById(id).orElseThrow(() -> new CompanyNotFound("Company not found with id: " + id));
    }

    @Override
    public String editCompany(CompanyRequestDto requestDto) {
        if (requestDto.getId() != null) {
            Company company = repository.findById(requestDto.getId()).orElseThrow(() -> new CompanyNotFound("Company not found with id: " + requestDto.getId()));

            if (requestDto.getName() != null) {
                company.setName(requestDto.getName());
            }if (requestDto.getCity() != null) {
                company.setCity(requestDto.getCity());
            }if (requestDto.getEmail() != null) {
                company.setEmail(requestDto.getEmail());
            }if (requestDto.getDescription() != null) {
                company.setDescription(requestDto.getDescription());
            }if (requestDto.getAddress() != null) {
                company.setAddress(requestDto.getAddress());
            }if (requestDto.getPhoneNumber() != null) {
                company.setPhoneNumber(requestDto.getPhoneNumber());
            }if (requestDto.getFaxNumber() != null) {
                company.setFaxNumber(requestDto.getFaxNumber());
            }if (requestDto.getWebsite() != null) {
                company.setWebsite(requestDto.getWebsite());
            }if (requestDto.getImage() != null) {
                company.setImage(Image.builder().base64(requestDto.getImage().getBase64()).build());
            }
            repository.save(company);
            return "Successfully edited:" + company.getId();
        }else throw new NullPointerException("Id or object can not be null");
    }


        @Override
        public String deleteCompany (String id){
            if (id!=null){
                repository.deleteById(id);
                return "Successfully deleted:" + repository.findById(id).orElseThrow(()->new CompanyNotFound("Company not found with id: "+id));
            }else throw new  NullPointerException("Id can not be null");
        }

        @Override
        public String addCompany (CompanyRequestDto requestDto){
            if (requestDto!= null) {
                Company company = companyDtoConverter.toEntity(requestDto);
                repository.save(company);
                return "Successfully added:" + company.getId();
            } else throw new NullPointerException("Object can not be null");

        }
}
