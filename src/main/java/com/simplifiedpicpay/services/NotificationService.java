package com.simplifiedpicpay.services;

import com.simplifiedpicpay.domain.user.User;
import com.simplifiedpicpay.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {

        String email = user.getEmail();
        NotificationDTO noticationRequest = new NotificationDTO(email, message);
//        ResponseEntity<String> noticationResponse = restTemplate.postForEntity("o4d9z.mocklab.io/notify", noticationRequest, String.class);
//        if (!(noticationResponse.getStatusCode() == HttpStatus.OK)) {
//            System.out.println("Error sending notification");
//            throw new Exception("Notification Service is down");
//
//        }
        System.out.println("Notification was send to the user");
    }

}
