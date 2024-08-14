package com.example.axforassets;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private EditText etJob, etPhone, etAddress;
    private ImageView ivPencilJob, ivPencilPhone, ivPencilAddress;


    private boolean isEditable = false;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuUtil.showMenu(ProfileActivity.this, v, "Profile");
            }
        });

        // Get the username from SharedPreferences
        SharedPreferences loginPrefs = getSharedPreferences("Prefs", MODE_PRIVATE);
        String username = loginPrefs.getString("username", "");

        // Find the welcomeText TextView and set the username
        TextView tvLabel = findViewById(R.id.tvLabel);
        tvLabel.setText("Hi, " + username + "!");

        TextView etEmail = findViewById(R.id.etEmail);
        etEmail.setText(username + "@gmail.com");

        // Inisialisasi view
//        edEmail = findViewById(R.id.etEmail);
        etJob = findViewById(R.id.etJob);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);

//        inisialisasi view untuk ikon pensil
        ivPencilJob = findViewById(R.id.ivPencilJobImage);
        ivPencilPhone = findViewById(R.id.ivPencilPhoneImage);
        ivPencilAddress = findViewById(R.id.ivPencilAddressImage);

// Mengambil data dari SharedPreferences
        // Mengambil data dari SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String job = prefs.getString("job", "");
        String phone = prefs.getString("phone", "");
        String address = prefs.getString("address", "");

// buatkan dummy data untuk job, phone, dan address
        if (job.isEmpty()) {
            job = "Software Engineer";
        }
        if (phone.isEmpty()) {
            phone = "081234567891";
        }
        if (address.isEmpty()) {
            address = "Jl. Ganesha No. 10, Bandung";
        }

// Set nilai ke EditText
        etJob.setText(job);
        etPhone.setText(phone);
        etAddress.setText(address);


        ivPencilJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEditable = !isEditable;
                etJob.setEnabled(isEditable);
                if (isEditable) {
                    etJob.requestFocus();
                    etJob.setSelection(etJob.getText().length());
                } else {
                    // Simpan nilai ke SharedPreferences saat pengguna selesai mengedit
                    SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("job", etJob.getText().toString());
                    editor.apply();

                    etJob.clearFocus();
                }
            }
        });
        ivPencilPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEditable = !isEditable;
                etPhone.setEnabled(isEditable);
                if (isEditable) {
                    etPhone.requestFocus();
                    etPhone.setSelection(etPhone.getText().length());
                } else {
                    String phoneNumber = etPhone.getText().toString();
                    if (!phoneNumber.startsWith("08") || phoneNumber.length() < 12) {
                        Toast.makeText(ProfileActivity.this, "Phone number must start with 08 and be at least 8 digits long", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // Simpan nilai ke SharedPreferences saat pengguna selesai mengedit
                    SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("phone", phoneNumber);
                    editor.apply();

                    etPhone.clearFocus();
                }
            }
        });

        ivPencilAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEditable = !isEditable;
                etAddress.setEnabled(isEditable);
                if (isEditable) {
                    etAddress.requestFocus();
                    etAddress.setSelection(etAddress.getText().length());
                } else {
                    // Simpan nilai ke SharedPreferences saat pengguna selesai mengedit
                    SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("address", etAddress.getText().toString());
                    editor.apply();

                    etAddress.clearFocus();
                }
            }
        });











    }
}