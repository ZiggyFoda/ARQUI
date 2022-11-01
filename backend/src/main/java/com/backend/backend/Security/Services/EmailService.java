package com.backend.backend.Security.Services;

import java.io.UnsupportedEncodingException;

import com.backend.backend.Model.EmailDetails;

public interface EmailService  {
    
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(String email);
   
    
}
