package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(Application.class, args);
    }

}
