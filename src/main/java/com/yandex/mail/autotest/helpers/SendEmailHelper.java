package com.yandex.mail.autotest.helpers;


import com.yandex.mail.autotest.domain.TestUser;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.ServerConfig;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendEmailHelper {

    @Autowired
    private TestUser testUser;

    private static final String SENDER_ADDRESS = "infernal.tester@yandex.ru";
    private static final String SENDER_PASSWORD = "Test@123";

    private static Mailer mailer = new Mailer(
            new ServerConfig("smtp.yandex.ru", 465, SENDER_ADDRESS, SENDER_PASSWORD),
            TransportStrategy.SMTP_SSL
    );

    public String sendBasicEmail() {
        String mailSubject;
        Email email = new EmailBuilder()
                .from("Tester", SENDER_ADDRESS)
                .to("Tester", testUser.getUsername())
                .subject(mailSubject = "Test-Email-" + System.currentTimeMillis())
                .text("Test email body")
                .build();
        mailer.sendMail(email);
        return mailSubject;
    }

}
