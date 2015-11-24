package com.example.jon.myfourthapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button sendButton;
    private Button registerButton;
    private Button staticBroadcastButton;
    private Boolean isRegistered;
    private MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        sendButton = (Button)findViewById(R.id.sendButton);
        staticBroadcastButton = (Button)findViewById(R.id.staticBroadcastButton);
        registerButton = (Button)findViewById(R.id.registerButton);
        isRegistered = false;
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegistered) {
                    unregisterReceiver(myBroadcastReceiver);
                    registerButton.setText("Register Broadcast");
                    isRegistered = false;
                } else {
                    registerReceiver(myBroadcastReceiver, new IntentFilter("SYSU_ANDROID_2015"));
                    registerButton.setText("Unregister Broadcast");
                    isRegistered = true;
                }
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("SYSU_ANDROID_2015");
                intent.putExtra("message", editText.getText().toString());
                sendBroadcast(intent);
            }
        });
        staticBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("STATIC_REGISTERED_BROADCAST");
                intent.putExtra("message", editText.getText().toString());
                sendBroadcast(intent);
            }
        });
    }
}
