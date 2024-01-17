package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.ContactRequestDto;
import az.coders.FinalProject.dto.response.ContactCompanyDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.enums.PeopleGroup;
import az.coders.FinalProject.exception.CompanyNotFound;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.CompanyRepository;
import az.coders.FinalProject.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactDtoConverter {

    private final ImageDtoConverter imageDtoConverter;
    private final CompanyRepository companyRepository;

    public ContactResponseDto toContactRespDto(Contact contact) {

        return ContactResponseDto.builder()
                .lastName(contact.getLastName())
                .firstName(contact.getFirstName())
                .city(contact.getCity())
                .email(contact.getEmail())
                .address(contact.getAddress())
                .country(contact.getCountry())
                .peopleGroup(contact.getPeopleGroup().toString())
                .image(imageDtoConverter.toImageResponseDto(contact.getImage()))
                .company(contactCompanyDto(contact.getCompany()))
                .build();
    }

    public ContactRequestDto toContactReqDto(Contact contact) {
        return ContactRequestDto.builder()
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .address(contact.getAddress())
                .city(contact.getCity())
                .image(imageDtoConverter.toImageRequestDto(contact.getImage()))
                .peopleGroup(contact.getPeopleGroup().toString().toUpperCase())
                .country(contact.getCountry())
                .companyId(contact.getCompany().getId())
                .build();

    }

    public Contact contactReqToEntity(ContactRequestDto contactDto) {
        Contact contact1 = Contact.builder()
                .firstName(contactDto.getFirstName())
                .lastName(contactDto.getLastName())
                .address(contactDto.getAddress())
                .country(contactDto.getCountry())
                .email(contactDto.getEmail())
                .city(contactDto.getCity())
                .peopleGroup(PeopleGroup.valueOf(contactDto.getPeopleGroup().toUpperCase()))
                .build();
        if (contactDto.getCompanyId() != null) {
            Company company = companyRepository
                    .findById(contactDto.getCompanyId())
                    .orElseThrow(() -> new CompanyNotFound("Company Not found"));
            contact1.setCompany(company);
        }
        if (contactDto.getImage() != null) {
            contact1.setImage(
                    Image.builder()
                            .base64(contactDto.getImage().getBase64())
                            .build());
        }

    }


    private ContactCompanyDto contactCompanyDto(Company company) {
        return ContactCompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .phoneNumber(company.getPhoneNumber())
                .website(company.getWebsite())
                .description(company.getDescription())
                .faxNumber(company.getFaxNumber())
                .city(company.getCity())
                .email(company.getEmail())
                .image(imageDtoConverter.toImageResponseDto(company.getImage()))
                .build();

    }
}
