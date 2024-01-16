package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

public List<ContactResponseDto>getAllContact();
public ContactResponseDto getContactById(String id);

public String editContact(ContactResponseDto contactDto);
public String addContact(Contact contact);

public String deleteContactById(String id);

}
