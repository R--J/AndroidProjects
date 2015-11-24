package com.helloworld.jon.mysecondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private ImageButton imageButton;
    private LinearLayout mainLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLinearLayout = (LinearLayout)findViewById(R.id.mainLinearLayout);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView newTextView = new TextView(MainActivity.this);
                newTextView.setText("这是一个动态添加的TextView");
                mainLinearLayout.addView(newTextView);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {
        if (username.getText().toString().equals("LeiBusi") && password.getText().toString().equals("Halo3Q")) {
            username.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            imageButton.setImageDrawable(getResources().getDrawable(R.drawable.state2));
        } else {
            password.setText("");
            password.setHint("密码错误");
            password.requestFocus();
        }
    }

    public void reset(View view) {
        username.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);
        username.setText("");
        password.setText("");
        username.setHint("请输入用户名");
        password.setHint("请输入密码");
        username.clearFocus();
        password.clearFocus();
        imageButton.setImageDrawable(getResources().getDrawable(R.drawable.state1));
    }

    public void enterSecondPage(View view) {
        Intent intent  = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
