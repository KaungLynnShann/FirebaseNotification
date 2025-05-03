package com.firebaseNoti.firebaseNoti.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import org.springframework.stereotype.Service;

@Service
public class NotiService {

    public String sendNotification(String token, String title, String body, String route) {
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                		.setTitle(title)
                        .setBody(body)
                        .build())
                .putData("title", title)
                .putData("body", body)
                .putData("route", route)
                .build();

        try {
        	 String response = FirebaseMessaging.getInstance().send(message);
        	 System.out.println("FCM : " + response);
        	 return response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send notification";
        }
    }
}