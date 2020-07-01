package pl.baksza.praca_domowa_t6.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.baksza.praca_domowa_t6.Model.FilmApi;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class FilmEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public FilmEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailWithAttachment(FilmApi filmApi) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("*************************");

        helper.setSubject("Add Film: " + filmApi.getTitle());

        String messageText = "<h1> Film: " + filmApi.getTitle() + " to Your film list</h>";
        helper.setText(messageText, true);

        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        //Resource resource = new ClassPathResource("android.png");
        //InputStream input = resource.getInputStream();

        //ResourceUtils.getFile("classpath:android.png");

        //helper.addAttachment("my_film.jpg", filmApi.getImages().get(0));

        javaMailSender.send(msg);

    }
}
