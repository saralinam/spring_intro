package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("dbRepository")
public class DBRepository implements Repository{

    @Override
    public void saveMessage(Message message) {
        System.out.println("Your messages has been saved to DB  " + message.getMessage());
    }
}
