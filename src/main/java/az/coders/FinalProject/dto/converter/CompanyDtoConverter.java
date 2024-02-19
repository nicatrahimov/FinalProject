package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.CompanyRequestDto;
import az.coders.FinalProject.dto.response.CompanyContactDto;
import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.enums.PeopleGroup;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.exception.ImageNotFound;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.ContactRepository;
import az.coders.FinalProject.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyDtoConverter {

    private final ImageDtoConverter imageDtoConverter;
    private final ContactRepository contactRepository;
    private final ImageRepository imageRepository;


    public CompanyResponseDto toResponseDto(Company company) {
        CompanyResponseDto companyResponse = CompanyResponseDto.builder()
                .id(company.getId())
                .email(company.getEmail())
                .city(company.getCity())
                .name(company.getName())
                .address(company.getAddress())
                .description(company.getDescription())
                .faxNumber(company.getFaxNumber())
                .phoneNumber(company.getPhoneNumber())
                .contacts(company.getContacts().stream().map(this::toCompanyContactDto).collect(Collectors.toSet()))
                .build();
        if (company.getImage() != null) {
            companyResponse.setImage(imageDtoConverter.toImageResponseDto(company.getImage()));
        }
        return companyResponse;
    }


    public Company toEntity(CompanyRequestDto dto) {

        Company company = Company.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .faxNumber(dto.getFaxNumber())
                .website(dto.getWebsite())
                .description(dto.getDescription())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .city(dto.getCity())
                .build();


        if (dto.getImage() != null && dto.getImage().getBase64() != null) {
            Image image = new Image();
            image.setBase64(dto.getImage().getBase64());
            company.setImage(image);
        }
        if (dto.getContacts() != null) {
            company.getContacts().addAll(dto.getContacts().stream().map(this::toEntityFromCompanyContactDto).collect(Collectors.toSet()));
        }
        return company;
    }


    private Contact toEntityFromCompanyContactDto(CompanyContactDto dto) {

        if (dto != null && dto.getId() != null) {
            Image image = imageRepository.findById(dto.getImage().getId()).orElseThrow(() -> new ImageNotFound("Image not found with id: " + dto.getImage().getId()));

            Contact contact = contactRepository.findById(dto.getId()).orElseThrow(() -> new ContactNotFound("Contact not found with id: " + dto.getId()));
            contact.setFirstName(dto.getFirstName());
            contact.setLastName(dto.getLastName());
            contact.setCountry(dto.getCountry());
            contact.setCity(dto.getCity());
            contact.setEmail(dto.getEmail());
            contact.setPeopleGroup(PeopleGroup.valueOf(dto.getPeopleGroup()));
            contact.setAddress(dto.getAddress());
            contact.setImage(image);
            return contact;

        } else throw new NullPointerException("Contact can not be null");

    }


    private CompanyContactDto toCompanyContactDto(Contact c) {
        CompanyContactDto dto = new CompanyContactDto();
        if (c != null && c.getId() != null) {
            dto.setId(c.getId());
            dto.setCity(c.getCity());
            dto.setAddress(c.getAddress());
            dto.setEmail(c.getEmail());
            dto.setFirstName(c.getFirstName());
            dto.setLastName(c.getLastName());
            dto.setCountry(c.getCountry());
            dto.setPeopleGroup(c.getPeopleGroup().toString().toUpperCase());
            dto.setImage(imageDtoConverter.toImageResponseDto(c.getImage()));
        }
        return dto;
    }

}
