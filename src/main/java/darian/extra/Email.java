package darian.extra;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    public static void send_mail(String to,String text){

        Properties properties = new Properties();
        properties.setProperty("mail.debug","true");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.host","smtp.qq.com");
        properties.setProperty("mail.transprot","smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1336485920@qq.com","vvuknptvfkcvgbhd");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("1336485920@qq.com"));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("密码找回");
            message.setContent(text,"text/html;charset=gbk");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
