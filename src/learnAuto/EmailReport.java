package learnAuto;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailReport 
{

	public static void main(String[] args) 
	{
		Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		  
		  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
		  {
			  protected PasswordAuthentication getPasswordAuthentication() 
			  {
				  return new PasswordAuthentication("add your email", "add your password");

			  }
		  });
		  
		  try 
		  {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("vrushalinaik927@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("vrushalinaik927@gmail.com"));
				message.setSubject("Testing Subject");
				BodyPart messageBodyPart1 = new MimeBodyPart();
				messageBodyPart1.setText("This is message body");
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
				String filename = "C:\\SeleniumPractice\\restLearn\\Test_Report\\ExtentReport1.html";
				DataSource source = new FileDataSource(filename);
				messageBodyPart2.setDataHandler(new DataHandler(source));
				messageBodyPart2.setFileName(filename);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart2);
				multipart.addBodyPart(messageBodyPart1);
				message.setContent(multipart);
				Transport.send(message);
				System.out.println("=====Email Sent=====");
		  } 
		  catch (MessagingException e) 
		  {
			  throw new RuntimeException(e);
		  }


	}

}
