package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FirebaseClientService {

	public void push() throws FirebaseMessagingException {
		// This registration token comes from the client FCM SDKs.
		String registrationToken = "FIXME クライアントで登録されたトークン";

		// See documentation on defining a message payload.
		Message message = Message.builder()
				//				.putData("score", "850")
				//				.putData("time", "2:45")
				.setNotification(new Notification("タイトル", "本文"))
				.setToken(registrationToken)
				.build();

		// Send a message to the device corresponding to the provided
		// registration token.
		String response = FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
		log.info("Successfully sent message: " + response);
	}
}
