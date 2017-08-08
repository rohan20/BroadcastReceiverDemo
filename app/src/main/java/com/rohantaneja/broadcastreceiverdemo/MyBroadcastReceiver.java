package com.rohantaneja.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    }
}
