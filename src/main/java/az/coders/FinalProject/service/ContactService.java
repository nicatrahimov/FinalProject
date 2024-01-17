package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.request.ContactRequestDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

 List<ContactResponseDto>getAllContact();
 ContactResponseDto getContactById(String id);

 String editContact(ContactResponseDto contactDto);
 String addContact(ContactRequestDto contact);

 String deleteContactById(String id);

}
