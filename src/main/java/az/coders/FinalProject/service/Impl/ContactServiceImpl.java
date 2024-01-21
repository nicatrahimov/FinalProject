package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.CompanyDtoConverter;
import az.coders.FinalProject.dto.converter.ContactDtoConverter;
import az.coders.FinalProject.dto.request.ContactRequestDto;
import az.coders.FinalProject.dto.response.CompanyResponseDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.enums.PeopleGroup;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.ContactRepository;
import az.coders.FinalProject.service.CompanyService;
import az.coders.FinalProject.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactDtoConverter contactDtoConverter;
    private final CompanyService companyService;
    private final CompanyDtoConverter companyDtoConverter;

    @Override
    public List<ContactResponseDto> getAllContact() {

        List<Contact> all = contactRepository.findAll();
        List<ContactResponseDto>allDto = new ArrayList<>();

        for(Contact contact:all){
            ContactResponseDto contactDto = contactDtoConverter.toContactRespDto(contact);
            allDto.add(contactDto);
        }
        return allDto;
    }

    @Override
    public ContactResponseDto getContactById(String id) {
        Contact contact = contactRepository.findById(id).orElseThrow(ContactNotFound::new);
        return contactDtoConverter.toContactRespDto(contact);
    }

    @Override
    public String editContact(ContactRequestDto contactDto) {
        if (contactDto != null && contactDto.getId()!=null) {
            Contact contact = contactRepository.findById(contactDto.getId()).orElseThrow(ContactNotFound::new);
            contact.setFirstName(contactDto.getFirstName());
            contact.setLastName(contactDto.getLastName());
            contact.setCity(contactDto.getCity());
            contact.setCountry(contactDto.getCountry());
            contact.setAddress(contactDto.getAddress());
            contact.setEmail(contactDto.getEmail());
            contact.setPeopleGroup(PeopleGroup.valueOf(contactDto.getPeopleGroup().toUpperCase()));
            contact.setImage(
                    Image.builder()
                    .base64(contactDto.getImage().getBase64())
                    .build());
            if (contactDto.getCompanyId()!=null){
                contact.setCompany(companyService.getCompanyEntityById(contactDto.getCompanyId()));
            }
            contactRepository.save(contact);
            return "Successfully edited";
        }else return "Unsuccessfully";
    }



    @Override
    public String addContact(ContactRequestDto from) {
        Contact contact = contactDtoConverter.contactReqToEntity(from);
        contactRepository.save(contact);
        return "Successfully added";
    }

    @Override
    public String deleteContactById(String id) {
        return null;
    }
}
