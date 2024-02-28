package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.MailDto;
import az.coders.FinalProject.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailSender {

    private final MailSenderService mailSenderService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody MailDto mailDto) {
        return new
                ResponseEntity<>(mailSenderService.sendEmail(mailDto), HttpStatus.OK);
    }
}
