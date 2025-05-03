package com.firebaseNoti.firebaseNoti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FirebaseNotiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FirebaseNotiApplication.class, args);
	}

	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(FirebaseNotiApplication.class);
	    }
}
