package com.dtech.darussalam.utilities.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*

/**
 * Develop By Zeeshan
 */
/*class MyFcmListenerService : FirebaseMessagingService() {

    private var TAG = "MyFirebaseMessagingService"
    private var broadcaster: LocalBroadcastManager? = null
    var counter = 0

    override fun onCreate() {
        broadcaster = LocalBroadcastManager.getInstance(this)
    }



    override fun onNewToken(tokken: String) {
        super.onNewToken(tokken)
        DoneApp.db.putString(Constants.DEVICE_ID, tokken!!)
        Log.d("Token", "New Token : $tokken")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG, "FROM : " + remoteMessage.from)
        //Verify if the message contains data
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data : " + remoteMessage.data)
            sendPush(remoteMessage.data, remoteMessage.notification)
        }
        //Verify if the message contains notification
        if (remoteMessage.notification != null) {
            Log.d(TAG, "Message body : " + remoteMessage.notification!!.body)
            sendNotification(remoteMessage.data , remoteMessage.notification)
        }

    }


    private fun sendPush(data: MutableMap<String, String>, body: RemoteMessage.Notification?) {
        val mIntent = Intent("Notification")
        broadcaster?.sendBroadcast(mIntent)
        val rand = Random()
        counter = rand.nextInt(1000)

    }

    private fun sendNotification(data: MutableMap<String, String>, body: RemoteMessage.Notification?) {
        val intent = Intent(this, if (DoneApp.db.getString(Constants.CONST_USER_TYPE)!!.equals(UserType.CUSTOMER.value.toString()) || DoneApp.db.getString(Constants.CONST_USER_TYPE)!!.equals(UserType.GUEST.value.toString()) ) MainActivity::class.java else ProviderMainActivity::class.java)
        val pendingFlags: Int = if (Build.VERSION.SDK_INT >= 23) {
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, pendingFlags)
        val notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val CHANNEL_ID = getString(R.string.default_channel_id)
        val name = getString(R.string.channel_name)
        val importance = NotificationManager.IMPORTANCE_HIGH

        val notificationBuilder = NotificationCompat.Builder(this, "Notification")
            .setSmallIcon(R.drawable.ic_logo)
            .setContentTitle(body!!.title)
            .setContentText(body.body)
            .setAutoCancel(true)
            .setSound(notificationSound)
            .setContentIntent(pendingIntent)

        val notificationManager: NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationBuilder.setChannelId(CHANNEL_ID)
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            notificationManager.createNotificationChannel(mChannel)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }
}*/
