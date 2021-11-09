package com.ileiwe.data.service.mail;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface EmailService {

    MailResponse send(Message message);
}
