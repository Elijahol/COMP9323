package com.vport.system.utils;


import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.vport.system.exception.MessageException;

import aj.org.objectweb.asm.Type;

/**
 * This is an util tool to support sending email function.
 * This is asynchronous tool.
 * @author Siyu Wang
 *
 */
@Service
@EnableAsync
public class MailUtils {
    
    @Async
    public  void sendMail(String to, String name, String code,String type) throws MessageException{
        
        
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587"); //TLS Port
            props.setProperty("mail.smtp.auth", "true"); //enable authentication
            props.setProperty("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            // Create Session instance
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("wangsy0808km@gmail.com", "UNSW17vsCD07");
                }
        };
        Session session = Session.getInstance(props, auth);

            session.setDebug(true);
            // format the mail:
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vport_official@163.com"));
            message.addRecipient(RecipientType.CC, new InternetAddress("wangsy0808km@gmail.com"));
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
            
            // Subject:
            message.setSubject("Vport Email!");
            // Content: Hi, name
            if ("reg".equals(type)) {
                message.setContent("<h1>Hi," + name + ", please click the link below to active your vport account</h1><h3><a href='http://www.vport.com/rest/user/activate?code="+code+"'>http://www.vport.com/rest/user/activate?code="+code+"</a></h3>", "text/html;charset=UTF-8");
            }else if ("rec".equals(type))
                message.setContent("<h1>Hi," + name + 
                                    ", please click the link below to reset your vport password</h1><h3><a href='http://www.vport.com/rest/user/resetPassword?code="+code+"'><button class='btn btn-primary'>Reset Password</button></a></h3>", "text/html;charset=UTF-8");
            // send mail:
           
            Transport.send(message);
        } catch (Exception e) {
//            e.printStackTrace();
            throw new MessageException("mail failed！！");
        }
    }
}
