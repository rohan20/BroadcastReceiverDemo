package com.rohantaneja.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by rohantaneja on 08/08/17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle b = intent.getExtras();

        if (intent.getAction().equals("my_receiver_action")) {
            if (b.getString("msg") != null) {
                Toast.makeText(context, b.getString("msg"), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "xyzzz", Toast.LENGTH_SHORT).show();
            }
        }

        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

            if (b != null) {
                Object pdusObjects[] = (Object[]) b.get("pdus");
                SmsMessage[] messages = new SmsMessage[pdusObjects.length];

                for (int i = 0; i < messages.length; i++) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format = b.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdusObjects[i], format);
                    } else {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdusObjects[i]);
                    }

                    String senderName = messages[i].getOriginatingAddress();
                    String smsMessage = messages[i].getMessageBody();

                    Toast.makeText(context, "Message from: " + senderName + "\nMessage text: " + smsMessage, Toast.LENGTH_SHORT).show();
                }

            }
        }

    }
}
