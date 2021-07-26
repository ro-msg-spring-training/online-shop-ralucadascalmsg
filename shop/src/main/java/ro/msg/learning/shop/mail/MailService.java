package ro.msg.learning.shop.mail;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
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
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.model.Order;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.naming.Binding;
import javax.xml.bind.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("raludascal@gmail.com");
        message.setTo("to_1@gmail.com");
        message.setSubject("Order confirmation");
        message.setText(text);
        emailSender.send(message);
        System.out.println("Mail send...");
    }

    public void sendHTMLMessage(String text) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("raludascal@gmail.com");
        helper.setTo("to_1@email");
        helper.setSubject("Order confirmation");
        helper.setText(text, true);

        FileSystemResource fileSystem= new FileSystemResource(new File("order.png"));
        helper.addAttachment(fileSystem.getFilename(),fileSystem);

        emailSender.send(message);
        System.out.println("Mail send...");
    }

    public String parser() throws IOException {
        String bodyPath = "templates\\HTMLTemplate.html";
        Path file = Path.of(new ClassPathResource(bodyPath).getFile().getPath());
        try {
        String content = Files.readString(file);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(content, new TemplateParserContext());
        Customer customer=Customer
                .builder()
                .firstName("Raluca")
                .lastName("Dascal")
                .build();
        Order order= Order.builder()
                .customer(customer)
                .build();
        EvaluationContext context = new StandardEvaluationContext(order);
        return  (String) exp.getValue(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

   public void sendMessage() throws IOException, MessagingException {
      String text=parser();
      sendHTMLMessage(text);
   }
}
