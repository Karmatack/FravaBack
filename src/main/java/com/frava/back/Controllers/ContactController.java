package com.frava.back.Controllers;

import com.frava.back.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendContactEmail(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            @RequestParam("phone") String phone,
            @RequestParam("empresa") String empresa) {  
        String subject = "Nuevo mensaje de contacto de: " + name;
        String body = "De: " + name +
                      "\nEmpresa: " + empresa +  
                      "\nCorreo: " + email +
                      "\nTeléfono: " + phone +
                      "\n\nMensaje:\n" + message;

        emailService.sendSimpleEmail("gerencia@grupofrava.com", subject, body);

        return "Mensaje enviado con éxito";
    }

}
