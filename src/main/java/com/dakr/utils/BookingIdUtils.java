package com.dakr.utils;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Component
public class BookingIdUtils {
	
	
	

private  final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	
	public  String BookingId() {
		int length =10;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(randomIndex));
        }

        return password.toString();
    }
}
