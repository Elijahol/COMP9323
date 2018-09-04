package com.vport.usermanage.utils;


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

/**
 * 发送邮件的工具类:
 * @author admin
 *
 */
public class MailUtils {

    public static void sendMail(String to, String name, String code){
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
            message.addRecipient(RecipientType.TO, new InternetAddress("20432707@qq.com"));
            
            // 主题:
            message.setSubject("Vport Email!");
            // 正文: Hi, name
            message.setContent("<h1>Hi," + name + ", please click the link below to active your vport account</h1><h3><a href='http://www.vport.com/rest/user/activate?code="+code+"'>http://127.0.0.1:80/rest/customer/activate?code="+code+"</a></h3>", "text/html;charset=UTF-8");
    // 发送邮件:
           
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Mail Sending Failed!!");
        }
    }
}
