package e2logtest.e2logtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class SentMail {
	public static void sentmail() {

		try {
			Properties props = new Properties();
			InputStream input = null;
			input = new FileInputStream("/home/thrymr/Desktop/workspacenew/e2logse/e2logtest/E2loge.properties");
			props.load(input);
			final String username =Getproperties.fetchProp("username");
			final String password = Getproperties.fetchProp("password");
			System.out.println(username);
			final String toaddress = "mamatha@thrymr.net";
			// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session = Session.getInstance(props, new GmailAuthenticator(username, password));
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			InternetAddress[] toAdressArray = InternetAddress.parse(toaddress);
			message.setRecipients(Message.RecipientType.TO, toAdressArray);
			// message.setRecipients(Message.RecipientType.TO, arg1);
			message.setSubject("Html Report");
//			message.setText("Dear Mamatha" + "test");
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart = new MimeBodyPart();
			String filename = Getproperties.fetchProp("extentreportspath");
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);			 
			Transport tr = session.getTransport("smtp");
			System.out.println(username);
			System.out.println(password);
			tr.connect("smtp.gmail.com", username, password);
			tr.send(message);
			tr.close();
			System.out.println("Mail Sent to " + toaddress);
		} catch (IOException ie) {
			throw new RuntimeException(ie);
		}

		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
}

}
