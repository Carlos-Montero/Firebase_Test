package com.example.carlos.firebase_test;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 *MyFirebaseMessagingService to implement notifications, extends the FirebaseMessagingService
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    /**
     * onMessageReceived() if intend on generating the notifications as a result of a received FCM
     * message, here is where is initiated.
     * @param remoteMessage
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("FCMexampleMessage", "From: " + remoteMessage.getFrom());


        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("FCMexampleMessage", "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}
