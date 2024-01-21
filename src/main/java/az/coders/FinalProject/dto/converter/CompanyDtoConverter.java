package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.response.CompanyContactDto;
import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.enums.PeopleGroup;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyDtoConverter {

    private final ImageDtoConverter imageDtoConverter;

    public CompanyResponseDto toResponseDto(Company company) {
        return CompanyResponseDto.builder()
                .id(company.getId())
                .email(company.getEmail())
                .city(company.getCity())
                .name(company.getName())
                .address(company.getAddress())
                .image(imageDtoConverter.toImageResponseDto(company.getImage()))
                .description(company.getDescription())
                .faxNumber(company.getFaxNumber())
                .phoneNumber(company.getPhoneNumber())
                .contacts(company.getContacts().stream().map(this::toCompanyContactDto).collect(Collectors.toSet()))
                .build();
    }

//    public Contact toEntityFromResponse(CompanyResponseDto responseDto) {
//        if (responseDto != null && responseDto.getId() != null) {
//            return Company.builder()
//                    .id(responseDto.getId())
//                    .email(responseDto.getEmail())
//                    .city(responseDto.getCity())
//                    .name(responseDto.getName())
//                    .address(responseDto.getAddress())
//                    .image(imageDtoConverter.toImage(responseDto.getImage()))
//                    .description(responseDto.getDescription())
//                    .faxNumber(responseDto.getFaxNumber())
//                    .phoneNumber(responseDto.getPhoneNumber())
//                    .contacts()
//                    .build();
//
//        }
//
//    }

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
