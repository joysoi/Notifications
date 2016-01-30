package com.example.nikola.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;


public class MainActivity extends AppCompatActivity {

//    We are building the notification object
    NotificationCompat.Builder notifications;
//    Every notification has to have a unique number so it can be tracked down from the list
    private static final int uniqueID = 34426;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  We have to set the already created notification object
        notifications = new NotificationCompat.Builder(this);
//  Once the notification has been pressed it has to erase itself
        notifications.setAutoCancel(true);
    }

    public void launchNotifications(View view){
//    Build the notification (1st SMALL ICON, 2nd TICKER, 3rd TITLE, 4th TEXT, 5th TIME)
        notifications.setSmallIcon(R.mipmap.ic_launcher);
        notifications.setTicker("This is the ticker");
        notifications.setWhen(System.currentTimeMillis());
        notifications.setContentTitle("Here is the Title");
        notifications.setContentText("This is the main body text");

//      Once pressed (the notification) it sends the user to the content page
        Intent intent = new Intent(this, MainActivity.class);
//      We are creating a PendingIntent for the user while they are using something else on the phone and not the app the we created the notifications for
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notifications.setContentIntent(pendingIntent);

//      Builds and send notifications
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notifications.build());
    }
}
