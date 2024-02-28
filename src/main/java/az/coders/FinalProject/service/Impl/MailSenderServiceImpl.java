package az.coders.FinalProject.service.Impl;

import az.coders.FinalProject.dto.MailDto;
import az.coders.FinalProject.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderServiceImpl implements MailSenderService {

    private final JavaMailSender javaMailSender;
    @Override
    public String sendEmail(MailDto mailDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(mailDto.getTo());
        simpleMailMessage.setSubject("Sehife admininden size mesaj var!!");
        simpleMailMessage.setText(mailDto.getBody());

        javaMailSender.send(simpleMailMessage);

        return "Email sent successfully";

    }
}
