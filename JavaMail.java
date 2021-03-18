import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLOutput;
import java.util.Properties;
import java.util.TreeSet;

public class JavaMail {

    public static void send(String recipent) throws MessagingException {
        System.out.println("preparing");
        Properties p = new Properties();
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");

        String mailId = "sruthikrithika0gmail.com";
        String pass = "lachimolala123";

        Session s = Session.getInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailId,pass);
            }
        });

        Message msg = Prep(s,mailId,recipent);
        Transport.send(msg);
        System.out.println("msg sent successfully");

    }

    private static Message Prep(Session s,String mailId,String re) {
        try {

            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(mailId));
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(re));
            msg.setSubject("check mail");
            msg.setText("Hello world");

            return msg;
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return  null;
    }
    public static void main(String[] args) throws MessagingException {
        JavaMail.send("sruthikrithika0gmail.com");
    }

}
