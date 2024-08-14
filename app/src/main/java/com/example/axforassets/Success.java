package com.example.axforassets;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Success extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


//        get the intent username
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        TextView tvLabel = findViewById(R.id.tvLabel);
        tvLabel.setText("Hi, " + username + "!");

    }
}
