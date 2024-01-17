package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.converter.ContactDtoConverter;
import az.coders.FinalProject.dto.request.ContactRequestDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.exception.ContactNotFound;
import az.coders.FinalProject.model.Contact;
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
            ContactResponseDto contactDto = dtoConverter.toContactRespDto(contact);
            allDto.add(contactDto);
        }
        return allDto;
    }

    @Override
    public ContactResponseDto getContactById(String id) {
        Contact contact = contactRepository.findById(id).orElseThrow(ContactNotFound::new);
        return dtoConverter.toContactRespDto(contact);
    }

    @Override
    public String editContact(ContactResponseDto contactDto) {
        return null;
    }

    @Override
    public String addContact(ContactRequestDto from) {
        Contact contact = dtoConverter.contactReqToEntity(from);
        contactRepository.save(contact);
        return "Successfully added";
    }

    @Override
    public String deleteContactById(String id) {
        return null;
    }
}
