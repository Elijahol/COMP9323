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
 * 发送邮件的工具类:
 * @author admin
 *
 */
@Service
@EnableAsync
public class MailUtils {
    
    @Async
    public  void sendMail(String to, String name, String code,String type) throws MessageException{
        //为了体现效果，邮件发送延迟5秒钟
        
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587"); //TLS Port
            props.setProperty("mail.smtp.auth", "true"); //enable authentication
            props.setProperty("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            // 创建Session实例对象
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("wangsy0808km@gmail.com", "UNSW17vsCD07");
                }
        };
        Session session = Session.getInstance(props, auth);

            session.setDebug(true);
            // 构建邮件:
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vport_official@163.com"));
            // 设置收件人:Vport Activation Email
            // TO:收件人   CC:抄送   BCC:暗送,密送.
            message.addRecipient(RecipientType.CC, new InternetAddress("wangsy0808km@gmail.com"));
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
            
            // 主题:
            message.setSubject("Vport Email!");
            // 正文: Hi, name
            if ("reg".equals(type)) {
                message.setContent("<h1>Hi," + name + ", please click the link below to active your vport account</h1><h3><a href='http://www.vport.com/rest/user/activate?code="+code+"'>http://www.vport.com/rest/user/activate?code="+code+"</a></h3>", "text/html;charset=UTF-8");
            }else if ("rec".equals(type))
                message.setContent("<h1>Hi," + name + 
                                    ", please click the link below to reset your vport password</h1><h3><a href='http://www.vport.com/rest/user/resetPassword?code="+code+"'><button class='btn btn-primary'>Reset Password</button></a></h3>", "text/html;charset=UTF-8");
            // 发送邮件:
           
            Transport.send(message);
        } catch (Exception e) {
//            e.printStackTrace();
            throw new MessageException("邮件发送失败！！");
        }
    }
}
