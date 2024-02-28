package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.MailDto;
import org.springframework.stereotype.Service;

@Service
public interface MailSenderService {
    String sendEmail(MailDto mailDto);
}
