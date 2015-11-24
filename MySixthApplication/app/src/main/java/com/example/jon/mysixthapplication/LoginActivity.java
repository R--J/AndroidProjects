package com.example.jon.mysixthapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jon on 15/11/20.
 */
public class LoginActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;
    private Button loginButton;
    private Button registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);

    }
}
