package com.rohantaneja.broadcastreceiverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {

        Intent i = new Intent();
        i.setAction("my_receiver_action");
        i.putExtra("msg", "Hello from MainActivity");
        sendBroadcast(i);

    }
}
