package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;


public class MyApplication {
    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Your orders have been received...");


        //reads spring java configuration
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        //MailService service=context.getBean(MailService.class);

        MessageService service = context.getBean( "whatsAppService", MessageService.class);
        MessageService service2 = context.getBean( "whatsAppService", MessageService.class);

        if(service == service2){
            System.out.println("They are the same Object...");
        }else{
            System.out.println("They are not the same Object...");
        }

        //let's check we are using the same object


        service.sentMessage(message);

        //call Point from Container
       Point point = context.getBean("point", Point.class);
        System.out.println("X coordinate : " +point.getX());
        System.out.println("Y coordinate : " +point.getY());

        context.close();  //lifecycle of created beans will be ended
    }
}
