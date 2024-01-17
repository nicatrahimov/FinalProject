package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.request.ContactRequestDto;
import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactResponseDto>> getAllContacts() {
        List<ContactResponseDto> contacts = contactService.getAllContact();
        return new
                ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<ContactResponseDto> getContactById(@PathVariable String id) {

        return new
                ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody ContactRequestDto contact) {

        return new
                ResponseEntity<>(contactService.addContact(contact), HttpStatus.OK);
    }


}
