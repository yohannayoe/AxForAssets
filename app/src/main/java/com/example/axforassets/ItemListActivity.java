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

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist_activity);

        RecyclerView recyclerView = findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Create an ArrayList of Item objects for each item representing its variations
        ArrayList<Item> firstVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.kur1, "Turtle 1"),
                new Item(R.drawable.kur2, "Turtle 2"),
                new Item(R.drawable.kur3, "Turtle 2"),
                new Item(R.drawable.kur4, "Turtle 2"),
                new Item(R.drawable.kur5, "Turtle 2"),
                new Item(R.drawable.kur6, "Turtle 3")
        ));
        ArrayList<Item> secondVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.buaya1, "Richard 1"),
                new Item(R.drawable.buaya2, "Louwis 1"),
                new Item(R.drawable.buaya3, "Alex 1"),
                new Item(R.drawable.buaya4, "Richard 2"),
                new Item(R.drawable.buaya5, "Louwis 2"),
                new Item(R.drawable.buaya6, "Alex 2")
        ));
        ArrayList<Item> thirdVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.tirec1, "Turtle 1"),
                new Item(R.drawable.tirec2, "Turtle 2"),
                new Item(R.drawable.tirec3, "Turtle 2"),
                new Item(R.drawable.tirec4, "Turtle 2"),
                new Item(R.drawable.tirec5, "Turtle 2"),
                new Item(R.drawable.tirec6, "Turtle 3")
        ));
        ArrayList<Item> fourthVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.dove1, "Turtle 1"),
                new Item(R.drawable.dove2, "Turtle 2"),
                new Item(R.drawable.dove3, "Turtle 2"),
                new Item(R.drawable.dove4, "Turtle 2"),
                new Item(R.drawable.dove5, "Turtle 2"),
                new Item(R.drawable.dove6, "Turtle 3")
        ));
        ArrayList<Item> fifthVariation = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.dino1, "Turtle 1"),
                new Item(R.drawable.dino2, "Turtle 2"),
                new Item(R.drawable.dino3, "Turtle 2"),
                new Item(R.drawable.dino4, "Turtle 2"),
                new Item(R.drawable.dino5, "Turtle 2"),
                new Item(R.drawable.dino6, "Turtle 3")
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