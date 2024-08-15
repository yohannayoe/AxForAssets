package com.example.axforassets;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.view.View;


import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist_activity);

        FrameLayout backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ImageView menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuUtil.showMenu(ItemListActivity.this, v, "ItemList");
            }
        });


        RecyclerView recyclerView = findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Create an ArrayList of Item objects for each item representing its variations
        ArrayList<Item> firstVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.kur1, "Kura 1"),
                new Item(R.drawable.kur2, "Kura 2"),
                new Item(R.drawable.kur3, "Kura 3"),
                new Item(R.drawable.kur4, "Kura 4"),
                new Item(R.drawable.kur5, "Kura 5"),
                new Item(R.drawable.kur6, "Kura 6")
        ));
        ArrayList<Item> secondVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.buaya1, "Croco 1"),
                new Item(R.drawable.buaya2, "Croco 2"),
                new Item(R.drawable.buaya3, "Croco 3"),
                new Item(R.drawable.buaya4, "Croco 4"),
                new Item(R.drawable.buaya5, "Croco 5"),
                new Item(R.drawable.buaya6, "Croco 6")
        ));
        ArrayList<Item> thirdVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.tirec1, "Trice 1"),
                new Item(R.drawable.tirec2, "Trice 2"),
                new Item(R.drawable.tirec3, "Trice 3"),
                new Item(R.drawable.tirec4, "Trice 4"),
                new Item(R.drawable.tirec5, "Trice 5"),
                new Item(R.drawable.tirec6, "Trice 6")
        ));
        ArrayList<Item> fourthVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.dove1, "Pige 1"),
                new Item(R.drawable.dove2, "Pige 2"),
                new Item(R.drawable.dove3, "Pige 3"),
                new Item(R.drawable.dove4, "Pige 4"),
                new Item(R.drawable.dove5, "Pige 5"),
                new Item(R.drawable.dove6, "Pige 6")
        ));
        ArrayList<Item> fifthVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.dino1, "Dino"),
                new Item(R.drawable.dino2, "Doni"),
                new Item(R.drawable.dino3, "Dinu"),
                new Item(R.drawable.dino4, "Duni"),
                new Item(R.drawable.dino5, "DIDIT"),
                new Item(R.drawable.dino6, "Rahmanudin")
        ));

        // Pass the ArrayList of variations to the Item constructor
        List<Item> itemList = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.first, "Kura Kurawr", firstVariation, "Kura Kurawr adalah hewan yang hidup di air", "Rp 100.000"),
                new Item(R.drawable.second, "Crocorowl", secondVariation, "Crocorowl adalah hewan yang hidup di air", "Rp 200.000"),
                new Item(R.drawable.third, "Tricerawr", thirdVariation, "Tricerawr adalah hewan yang hidup di jaman purba", "Rp 300.000"),
                new Item(R.drawable.fourth, "Pigerawr", fourthVariation, "Pigerawr adalah hewan yang hidup di udara", "Rp 400.000"),
                new Item(R.drawable.fifth, "Tyranorowr", fifthVariation, "Tyranorowr adalah hewan yang hidup di jamar purba", "Rp 500.000")
                // Other items...
        ));

        ItemAdapter adapter = new ItemAdapter(itemList, this);
        recyclerView.setAdapter(adapter);



    }

}