package com.helloworld.jon.mysecondproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private LinearLayout mainLinearLayout;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mainLinearLayout = (LinearLayout)findViewById(R.id.mainLinearLayout);
        textView = (TextView)findViewById(R.id.textView);
        for (int row = 0; row < 3; row++) {
            LinearLayout newRow = new LinearLayout(SecondActivity.this);
            for (int button = 0; button < 3; button++) {
                Button newButton = new Button(SecondActivity.this);
                final int digit = row * 3 + button + 1;
                newButton.setText(String.valueOf(digit));
                newButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText(textView.getText().toString() + String.valueOf(digit));
                    }
                });
                newRow.addView(newButton);
            }
            mainLinearLayout.addView(newRow);
        }
    }
}
