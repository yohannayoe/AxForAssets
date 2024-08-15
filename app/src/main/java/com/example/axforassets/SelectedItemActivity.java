package com.example.axforassets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectedItemActivity extends AppCompatActivity {

    private RecyclerView rvItemList;
    private SelectedItemAdapter itemAdapter;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecteditem_activity);
        // Retrieve the passed details from the Intent
        String itemName = getIntent().getStringExtra("itemName");
        String itemPrice = getIntent().getStringExtra("itemPrice");
        String itemDescription = getIntent().getStringExtra("itemDescription");

        // Find the TextViews in the layout
        TextView nameTextView = findViewById(R.id.PreviewItemTitle);
        TextView priceTextView = findViewById(R.id.PreviewItemPrice);
        TextView descriptionTextView = findViewById(R.id.PreviewItemDesc);

        // Set the TextViews to display the item's details
        nameTextView.setText(itemName);
        priceTextView.setText(itemPrice);
        descriptionTextView.setText(itemDescription);

        rvItemList = findViewById(R.id.rvItemList);

        // Set layout manager for RecyclerView
        rvItemList.setLayoutManager(new GridLayoutManager(this,3));

        // Retrieve the passed ArrayList of variations from the Intent
        ArrayList<Item> itemVariations = getIntent().getParcelableArrayListExtra("itemVariations");

        // Set the image of the first item in the list as the preview image
        ImageView previewImage = findViewById(R.id.PreviewItem);
        if (itemVariations != null && !itemVariations.isEmpty()) {
            previewImage.setImageResource(itemVariations.get(0).getImageResource());
            previewImage.setScaleX(2f); // scale in X direction
            previewImage.setScaleY(2f); // scale in Y direction
        }

        // Set adapter
        itemAdapter = new SelectedItemAdapter(itemVariations, this);
        rvItemList.setAdapter(itemAdapter);

        FrameLayout backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buyItemsButton = findViewById(R.id.BuyItems);
        buyItemsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Button is pressed
                        buyItemsButton.setBackgroundResource(R.drawable.button_background);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Button is released
                        buyItemsButton.setBackgroundResource(R.drawable.buttonpurchase);
                        break;
                }
                return false; // Don't consume the event
            }
        });

        buyItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                buyItemsButton.setBackgroundColor(getResources().getColor(R.color.brown_corner));


                AlertDialog.Builder builder = new AlertDialog.Builder(SelectedItemActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.popuptransaksi, null);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();

                ImageView backButton = dialogView.findViewById(R.id.buttonBack);
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button submitButton = dialogView.findViewById(R.id.submit);
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText emailEditText = dialogView.findViewById(R.id.email);

                        String emailInput = emailEditText.getText().toString();

                        if (emailInput.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                            new AlertDialog.Builder(SelectedItemActivity.this)
                                    .setTitle("Error")
                                    .setMessage("Email is Invalid")
                                    .setPositiveButton(android.R.string.ok, null)
                                    .show();
                        } else {
                            new AlertDialog.Builder(SelectedItemActivity.this)
                                    .setTitle("Success")
                                    .setMessage("Transaction Success")
                                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(SelectedItemActivity.this, ItemListActivity.class);
                                            startActivity(intent);
                                        }
                                    })
                                    .show();
                        }
                    }
                });

                Spinner creditCardSpinner = dialogView.findViewById(R.id.creditCard);

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SelectedItemActivity.this,
                        R.array.credit_card_array, android.R.layout.simple_spinner_item);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                creditCardSpinner.setAdapter(adapter);

                dialog.show();
            }
        });
    }
}