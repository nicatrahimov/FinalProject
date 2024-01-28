package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.ContactRequestDto;
import az.coders.FinalProject.dto.response.ContactCompanyDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.enums.PeopleGroup;
import az.coders.FinalProject.exception.CompanyNotFound;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactDtoConverter {

    private final ImageDtoConverter imageDtoConverter;
    private final CompanyRepository companyRepository;

    public ContactResponseDto toContactRespDto(Contact contact) {
        if (contact != null) {
            return ContactResponseDto.builder()
                    .id(contact.getId())
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
        }else return new ContactResponseDto();
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
                .build();


    }

    public Contact contactReqToEntity(ContactRequestDto contactDto) {
        if (contactDto!=null){
            Contact contact = Contact.builder()
                    .id(contactDto.getId())
                    .firstName(contactDto.getFirstName())
                    .lastName(contactDto.getLastName())
                    .address(contactDto.getAddress())
                    .country(contactDto.getCountry())
                    .email(contactDto.getEmail())
                    .city(contactDto.getCity())
                    .peopleGroup(PeopleGroup.valueOf(contactDto.getPeopleGroup().toUpperCase()))
                    .image(Image.builder()
                            .base64(contactDto.getImage().getBase64())
                            .build())
                    .build();
            try{
                contact.setCompany(companyRepository.findById(contactDto.getCompanyId()).orElseThrow(CompanyNotFound::new));
            }catch (Exception ignored){
            }finally {
                return contact;
            }
        }else {
            return null;
        }
    }
    private ContactCompanyDto contactCompanyDto(Company company) {
        if (company != null) {
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
        } else return new ContactCompanyDto();
    }
}
