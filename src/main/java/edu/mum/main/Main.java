//package edu.mum.main;
//
//
//import edu.mum.domain.Events;
//import edu.mum.domain.User;
//import edu.mum.service.UserService;
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
//import org.springframework.security.authentication.AuthenticationManager;
//
//
///*
// * N+1 issue when Many side is declare EAGER
// * One Fetch of LIST of Members
// * N Fetches of each Members List of Addresses
// */
//public class Main {
//  public static void main(String[] args) {
//
//    ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
//    
//    UserService userService = (UserService) ctx.getBean("userServiceImpl");
//    //MemberService memberService = (MemberService) ctx.getBean("memberServiceImpl");
//    User user=new User();
//    user.setId(1);
//    user.setFirstName("Hagos");
//    user.setLastName("Bezabh");
//    user.setEmail("hagos.bezabh@gmail.com");
//    user.setStatus(true);
//    
//    userService.save(user);
//    
//    Events event=new Events();
//    
//    
//    
//            
//  } 
//  }