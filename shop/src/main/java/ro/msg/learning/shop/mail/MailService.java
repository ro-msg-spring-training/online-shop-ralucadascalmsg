package ro.msg.learning.shop.mail;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.naming.Binding;
import javax.xml.bind.ValidationException;
import java.io.File;

@Service
@AllArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("raludascal@gmail.com");
        message.setTo("to_1@gmail.com");
        message.setSubject("Order confirmation");
        message.setText("Order has been successfully created.");
        emailSender.send(message);
        System.out.println("Mail send...");
    }

    public void sendHTMLMessage() throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("raludascal@gmail.com");
        helper.setTo("to_1@email");
        helper.setSubject("Order confirmation");
        helper.setText("<b>Hello</b>,<br><i>Order has been successfully created.</i>", true);

        FileSystemResource fileSystem= new FileSystemResource(new File("order.png"));
        helper.addAttachment(fileSystem.getFilename(),fileSystem);

        emailSender.send(message);
        System.out.println("Mail send...");
    }
}
