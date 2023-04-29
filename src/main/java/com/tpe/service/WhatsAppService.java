package com.tpe.service;


import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("whatsAppService")
public class WhatsAppService implements MessageService{


    @Value("${app.counter}")

    private int counter;
    @Autowired
   @Qualifier("fileRepository")
    private Repository repository;
    public void sentMessage(Message message) {
        System.out.println("I am WhatsApp Service to sent this message in: " + message.getMessage());
        repository.saveMessage(message);

        System.out.println(counter);
    }
}
