package com.example.axforassets;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Arrays;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

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