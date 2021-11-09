package com.ileiwe.data.service.event;


import com.ileiwe.data.service.mail.EmailService;
import com.ileiwe.data.service.mail.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;

import static net.bytebuddy.implementation.MethodDelegation.to;

@Component
public class ApplicationEventListener {
    @Autowired
    EmailService emailService;


    @Autowired
    TemplateEngine templateEngine;



    @EventListener
    public void handleRegistrationCompleteEvent(OnRegistrationCompleteEvent event){
        this.confirmRegistration(event);
    }



    private void confirmRegistration(OnRegistrationCompleteEvent event){
        String VerificationToken = UUID.randomUUID().toString();
        Message message = Message.builder()
                .from("ekejiubaEvans2020")
                .to(event.getAppUser().getEmail())
                .subject("Comfirmation email")
                .body(templateEngine.process("confirmation.html", new Context()))
                        .build();

        emailService.send(message);
    }
}
