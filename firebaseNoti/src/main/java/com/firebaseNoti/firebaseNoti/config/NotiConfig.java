package com.firebaseNoti.firebaseNoti.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class NotiConfig {

	  @Bean
	    public FirebaseApp initializeFirebase() throws IOException {
	        // Check if the default FirebaseApp already exists
	        if (FirebaseApp.getApps().isEmpty()) {
	            try (InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("connecthcm-712c2-firebase-adminsdk-xrx9v-e21c94d78e.json")) {
	                if (serviceAccount == null) {
	                    throw new IOException("Service account file not found in classpath.");
	                }

	                FirebaseOptions options = FirebaseOptions.builder()
	                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	                        .build();

	                // Initialize FirebaseApp with default settings if it has not been initialized yet
	                return FirebaseApp.initializeApp(options);
	            }
	        } else {
	            // FirebaseApp already initialized, return the existing instance
	            return FirebaseApp.getInstance();
	        }
	    }
	  
//	    @Bean
//	    public RestTemplate restTemplate() {
//	        return new RestTemplate();
//	    }

}