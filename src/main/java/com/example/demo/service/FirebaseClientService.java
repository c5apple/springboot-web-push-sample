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

	/**
	 * プッシュ通知を送信する
	 *
	 * @param token クライアントで登録されたトークン
	 * @throws FirebaseMessagingException
	 */
	public void push(String token) throws FirebaseMessagingException {
		// See documentation on defining a message payload.
		Message message = Message.builder()
				.setNotification(new Notification("タイトル", "本文"))
				.setToken(token)
				.build();

		// Send a message to the device corresponding to the provided
		// registration token.
		String response = FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
		log.info("Successfully sent message: " + response);
	}
}
