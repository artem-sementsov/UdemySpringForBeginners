package org.artemsementsov.udemyspringforbeginners.controllers;

import org.artemsementsov.udemyspringforbeginners.mail.MailSender;
import org.artemsementsov.udemyspringforbeginners.mail.MockMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

    private MailSender mailSender;

    @Autowired
    public MailController(MailSender smtp) {
        this.mailSender = smtp;
    }

    @RequestMapping("/mail")
    public String mail() throws MessagingException {
        mailSender.send("mail@example.com", "A test mail", "Body of the test mail");
        return "Mail sent";
    }
}
