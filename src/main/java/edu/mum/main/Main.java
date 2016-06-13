package edu.mum.main;

import edu.mum.domain.Credentials;
import edu.mum.domain.Event;
import edu.mum.domain.User;
import edu.mum.service.EventService;
import edu.mum.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * N+1 issue when Many side is declare EAGER
 * One Fetch of LIST of Members
 * N Fetches of each Members List of Addresses
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

        EventService eventService = ctx.getBean("eventServiceImpl", EventService.class);
        UserService userService = ctx.getBean("userServiceImpl", UserService.class);

        Event event = new Event();
        String dateStart = "06/12/16 09:30";
        String dateStop = "06/12/16 11:31";

//        Custom date format 
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy HH:mm");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        event.setName("Test");
        event.setStartTime(d1);
        event.setEndTime(d2);

        Credentials credentials1 = new Credentials();
        credentials1.setUserName("admin");
        credentials1.setPassword("admin");
        credentials1.setEnabled(true);

        User user1 = new User();
        user1.setFirstName("steve");
        user1.setLastName("jobs");
        user1.setEmail("jobs@gmail.com");
        user1.setContact("9898989898");
        user1.setCredentials(credentials1);
        
        userService.save(user1);
        
        event.addUser(user1);
        eventService.save(event);
    }
}
