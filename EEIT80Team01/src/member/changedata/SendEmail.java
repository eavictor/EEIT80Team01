package member.changedata;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
 public static boolean sendemail(String email, String url) {
  String host = "smtp.gmail.com";
  int port = 587;
  final String username = "eeit80team01@gmail.com";
  final String password = "";//email password

  Properties props = new Properties();
  props.put("mail.smtp.host", host);
  props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.port", port);
  Session session = Session.getInstance(props, new Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
  });

  try {
   Message message = new MimeMessage(session); 
   message.setFrom(new InternetAddress("eeit80team01@gmail.com"));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));  
   message.setSubject("重設信件");   
   Multipart mp = new MimeMultipart();
   MimeBodyPart part1 = new MimeBodyPart();
   part1.setText("請點以下連結重新設定密碼");
   MimeBodyPart part2 = new MimeBodyPart();  
   part2.setText(url);
   part2.setContent(url,"text/html; charset=utf-8");
   mp.addBodyPart(part1);
   mp.addBodyPart(part2);
   message.setContent(mp);
   Transport.send(message);
   
   System.out.println("寄送email結束.");
   return true;
  } catch (Exception e) {
   return false;
  }
  
 }
}