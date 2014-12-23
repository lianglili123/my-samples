package my.sample.helloworld.email;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	JavaMailSender sender;
	Logger logger=Logger.getLogger(this.getClass());
	
	public void sendEmail(final String emailAddr){
		MimeMessagePreparator preparator=new MimeMessagePreparator() {
			public void prepare(MimeMessage message) throws Exception{
				message.setRecipients(Message.RecipientType.TO,emailAddr);
				message.setFrom(new InternetAddress("mail@sample.my"));
				message.setText("Just for test");
			}

		};
		
		try{
			sender.send(preparator);
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

}
