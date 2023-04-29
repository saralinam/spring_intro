package com.tpe.service;


import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("smsService")
public class SMSService implements MessageService{

    @Autowired
    @Qualifier("fileRepository")
    private Repository repository;
    @Override
    public void sentMessage(Message message) {
        System.out.println("I am SMS Service to sent this message in: " + message.getMessage());
        repository.saveMessage(message);
    }
}
