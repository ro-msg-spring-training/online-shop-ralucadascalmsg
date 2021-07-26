package ro.msg.learning.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ro.msg.learning.shop.mail.MailService;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class ShopApplication {

	@Autowired
	private MailService mailService;


	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
        @EventListener(ApplicationReadyEvent.class)
		public void triggerMail() throws MessagingException, IOException {
			mailService.sendMessage();
		}



}
