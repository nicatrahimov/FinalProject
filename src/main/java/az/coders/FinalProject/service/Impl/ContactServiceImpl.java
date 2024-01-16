package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.ContactDtoConverter;
import az.coders.FinalProject.dto.response.ContactCompanyDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.dto.response.ImageResponseDto;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.model.Company;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import az.coders.FinalProject.repository.ContactRepository;
import az.coders.FinalProject.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactDtoConverter dtoConverter;

    @Override
    public List<ContactResponseDto> getAllContact() {

        List<Contact> all = contactRepository.findAll();
        List<ContactResponseDto>allDto = new ArrayList<>();

        for(Contact contact:all){
            ContactResponseDto contactDto = dtoConverter.toContactDto(contact);
            allDto.add(contactDto);
        }
        return allDto;
    }

    @Override
    public ContactResponseDto getContactById(String id) {
        Contact contact = contactRepository.findById(id).orElseThrow(ContactNotFound::new);
        return dtoConverter.toContactDto(contact);
    }

    @Override
    public String editContact(ContactResponseDto contactDto) {
        return null;
    }

    @Override
    public String addContact(Contact contact) {
        return null;
    }

    @Override
    public String deleteContactById(String id) {
        return null;
    }
}
