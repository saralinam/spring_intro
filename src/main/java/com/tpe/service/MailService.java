package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DBRepository;
import com.tpe.repository.FileRepository;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Scope(value="singleton")
@Scope(value = "prototype")
@Component("mailService")  //
public class MailService implements MessageService{


    //we created the obj from repository (interface) & called the method from FileRepository class

   // Repository repository = new DBRepository();
    @Value("${app.mail}")
    private String email;


    //1.field injection

//    @Autowired  //dependency object
//    @Qualifier("fileRepository")    //if interface has more than one child then we use @Qualifier annotation
//    private Repository repository;


    //2. setter injection
//    private Repository repository;
//    @Autowired
//    @Qualifier("dbRepository")
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }


    //3. Constructor injection
    private Repository repository;

    @Autowired     //if you have one constructor no need to use "Autowired" annotation (Constructor injection)
    public MailService( @Qualifier("fileRepository") Repository repository) {
        this.repository = repository;
    }



    @Override
    public void sentMessage(Message message){
        System.out.println("I am Mail Service to sent this message in : " + message.getMessage());
        repository.saveMessage(message);     //using repository obj we can save the message

        System.out.println(email);
    }
}
