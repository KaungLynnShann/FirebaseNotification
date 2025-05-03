package com.firebaseNoti.firebaseNoti.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;

import com.firebaseNoti.firebaseNoti.service.NotiService;

@RestController
@RequestMapping("/fcm")
public class NotiController {

    private final NotiService notiService;
//    private final RestTemplate restTemplate; 

    // Constructor injection for both NotiService and RestTemplate
    public NotiController(NotiService notiService) {
        this.notiService = notiService;
//        this.restTemplate = restTemplate; 
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        String title = request.get("title");
        String body = request.get("body");
        String route = request.get("route");
        String response = notiService.sendNotification(token, title, body , route);

        if (response.contains("Failed")) {
            return ResponseEntity.status(500).body("Notification sending failed");
        } else {
            return ResponseEntity.ok("Notification sent successfully");
        }
    }
    
//    public void callSendNotificationApi(String token, String title, String body) {
//        if (!token.equals("")) {
//            String url = "http://localhost:8090/fcm/send"; 
//            // Sending the request to another API using RestTemplate
//            String response = restTemplate.postForObject(url, 
//                new NotificationRequest(token, title, body), String.class);
//            
//            System.out.println("Response from FCM send: " + response);
//        }
//    }
}

class NotificationRequest {
    private String token;
    private String title;
    private String body;

    public NotificationRequest(String token, String title, String body) {
        this.token = token;
        this.title = title;
        this.body = body;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
