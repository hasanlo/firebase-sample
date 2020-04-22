package com.hasanlo.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import java.io.IOException;
import java.io.InputStream;

public class SendNotification {
    public static void main(String[] args) throws IOException, FirebaseMessagingException {
        InputStream serviceAccount = SendNotification.class.getResourceAsStream("/firebase.Setting.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("database-Url")
                .build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
        Notification notification = Notification.builder().setTitle("این عنوان پیام است").setBody("این متن پیام است").build();
        Message message = Message.builder()
                .setNotification(notification)
                .setToken("clientToken")
                .build();

        FirebaseMessaging.getInstance().send(message);
    }
}
