package com.example.axforassets;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.LoginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Username must be filled in", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Password must be filled in", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(LoginActivity.this, "Password length must be at least 8 characters", Toast.LENGTH_SHORT).show();
                } else {

                    // Save username and password to SharedPreferences
                    SharedPreferences prefs = getSharedPreferences("Prefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("username", username);
                    editor.apply();

                    // Membuat Intent untuk berpindah ke ProfileActivity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

                    // Mengirimkan username ke ProfileActivity
                    intent.putExtra("username", username);

                    // Memulai Activity
                    startActivity(intent);

                }
            }
        });
    }
}