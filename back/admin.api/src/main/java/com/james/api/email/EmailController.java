package com.james.api.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        String to = emailRequest.getEnpEmail();
        String subject = "계정 생성 요청";
        String message = emailRequest.getMessage();
        emailService.sendSimpleMessage(to, subject, message);
        return "이메일이 성공적으로 전송되었습니다.";
    }
}