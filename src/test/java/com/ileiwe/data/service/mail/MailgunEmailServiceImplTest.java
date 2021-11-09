package com.ileiwe.data.service.mail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Email;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailgunEmailServiceImplTest {

    @Autowired
    @Qualifier("mailgun")
    EmailService emailService;
    @BeforeEach
    void setUp() {
    }


    @Test
    void sendEmailWithMailgunTest(){
//        create message
        Message mail = Message.builder()
                .from("ekejiubaevans2022@gmail.com")
                .to("prodigyevans@gmail.com")
                .subject("Test Email")
                .body("This is the body" + "of my test mail").build();

//        call send method
        MailResponse response = emailService.send(mail);


        //        verify the mail response
        assertTrue(response.isSuccessful());





    }
}