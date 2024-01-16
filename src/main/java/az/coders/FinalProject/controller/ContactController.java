package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.response.ContactResponseDto;
import az.coders.FinalProject.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    @GetMapping
    public ResponseEntity<List<ContactResponseDto>> getAllContacts(){
        List<ContactResponseDto> contacts = contactService.getAllContact();
            return new
                    ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ContactResponseDto> getContactById(@PathVariable String id){

        return new ResponseEntity<>(contactService.getContactById(id),HttpStatus.OK);
    }


}
