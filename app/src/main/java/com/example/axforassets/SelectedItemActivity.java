package com.example.axforassets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SelectedItemActivity extends AppCompatActivity {

    private RecyclerView rvItemList;
    private SelectedItemAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecteditem);

        rvItemList = findViewById(R.id.rvItemList);

        // Set layout manager for RecyclerView
        rvItemList.setLayoutManager(new GridLayoutManager(this,3));

        // Initialize item list
        List<SelectedItem> itemList = new ArrayList<>();
        itemList.add(new SelectedItem("難しい", R.drawable.ic_launcher_background));
        itemList.add(new SelectedItem("未来", R.drawable.ic_launcher_background));
        itemList.add(new SelectedItem("東京", R.drawable.ic_launcher_background));
        itemList.add(new SelectedItem("不知火", R.drawable.ic_launcher_background));
        itemList.add(new SelectedItem("真冬", R.drawable.ic_launcher_background));
        itemList.add(new SelectedItem("影人", R.drawable.ic_launcher_background));


        // Set adapter
        itemAdapter = new SelectedItemAdapter(itemList,this);
        rvItemList.setAdapter(itemAdapter);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buyItemsButton = findViewById(R.id.BuyItems);
        buyItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bagian Tekan Popup
//                ImageView menuButton = findViewById(R.id.menuButton);
//                final PopupWindow[] popupWindow = {null};
//                menuButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (popupWindow[0] != null && popupWindow[0].isShowing()) {
//                            // If the PopupWindow is showing, dismiss it
//                            popupWindow[0].dismiss();
//                            popupWindow[0] = null;
//                        } else {
//                            // If the PopupWindow is not showing, show it
//                            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                            View popupView = layoutInflater.inflate(R.layout.menupopup, null);
//
//                            popupWindow[0] = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                            popupWindow[0].setOutsideTouchable(true);
//                            popupWindow[0].setFocusable(true);
//                            popupWindow[0].showAtLocation(v, Gravity.START, Gravity.END, -300);
//                        }
//                    }
//                });

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
                                            Intent intent = new Intent(SelectedItemActivity.this, FirstFragment.class);
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