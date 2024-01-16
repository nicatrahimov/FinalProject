package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.response.ContactCompanyDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactDtoConverter {

    private final ImageDtoConverter imageDtoConverter;

    public ContactResponseDto toContactDto(Contact contact){

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


    private ContactCompanyDto contactCompanyDto(Company company){
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
