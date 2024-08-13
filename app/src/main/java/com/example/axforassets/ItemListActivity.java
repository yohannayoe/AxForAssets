package com.example.axforassets;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Arrays;
import java.util.List;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.axforassets.databinding.ActivityMainBinding;

import android.widget.Button;

public class ItemListActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Item> itemList = Arrays.asList(
                new Item(R.drawable.first, "First Item"),
                new Item(R.drawable.second, "Second Item"),
                new Item(R.drawable.third, "Third Item"),
                new Item(R.drawable.fourth, "Fourth Item"),
                new Item(R.drawable.fifth, "Fifth Item")
        );

        Adapter adapter = new Adapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}