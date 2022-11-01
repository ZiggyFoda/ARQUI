package com.backend.backend.Security.Services;

import com.backend.backend.Model.EmailDetails;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mallFrom;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        // Try block to check for exceptions
        return "Cool";
    }

    @Override
    public String sendMailWithAttachment(String email) {
        // Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, false);
            //mimeMessageHelper.setFrom("aantikpuj@gmail.com");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText("Siga en el siguiente link para hacer el reseteo de tu cuenta \n");
            mimeMessageHelper.setSubject("Reseteo de contraseña");
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            System.out.print("Mail enviado");
            return "Email para reseteo de contraseña enviado con éxito para " + email;
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            System.out.print("Error while sending mail!!!");
            return "Error while sending mail!!!";
        }
    }
    
}
