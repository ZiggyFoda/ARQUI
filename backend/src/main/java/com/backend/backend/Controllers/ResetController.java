package com.backend.backend.Controllers;

import com.backend.backend.Model.EmailDetails;
import com.backend.backend.Security.Services.EmailService;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;
import com.backend.backend.Model.Reset;
import com.backend.backend.Payload.Request.ResetRequest;
import com.backend.backend.Payload.Response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class ResetController {

    @Autowired private EmailService emailService;

    
    @PostMapping("/recuperaPswrd")
    public ResponseEntity<?> processForgotPassword(@Valid @RequestBody ResetRequest resetRequest) {
        System.out.println("Email: " + resetRequest.getEmail());
        String token = RandomString.make(30);
        System.out.println("Token" + token);
        String message = emailService.sendMailWithAttachment(resetRequest.getEmail());
 
       return ResponseEntity.ok(new MessageResponse(message));
}

    @PostMapping("/reset")
    public String showResetPasswordForm() {
        return "cool";
    }

}
