package com.example.axforassets;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    private TextView tabTerm, tabCondition;
    private int selectedTabNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        RecyclerView recyclerView = findViewById(R.id.productRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

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
                new Item(R.drawable.kur1, "Kura Kurawr", firstVariation, "Kura Kurawr adalah hewan yang hidup di air", "Rp 100.000"),
                new Item(R.drawable.buaya1, "Crocorowl", secondVariation, "Crocorowl adalah hewan yang hidup di air", "Rp 200.000"),
                new Item(R.drawable.tirec1, "Tricerawr", thirdVariation, "Tricerawr adalah hewan yang hidup di jaman purba", "Rp 300.000"),
                new Item(R.drawable.dove1, "Pigerawr", fourthVariation, "Pigerawr adalah hewan yang hidup di udara", "Rp 400.000"),
                new Item(R.drawable.dino1, "Tyranorowr", fifthVariation, "Tyranorowr adalah hewan yang hidup di jamar purba", "Rp 500.000")
                // Other items...
        ));

        ProductAdapter adapterItem = new ProductAdapter(itemList, this);
        recyclerView.setAdapter(adapterItem);


        viewPager2 = findViewById(R.id.viewPager);

        List<Integer> images = Arrays.asList(
                R.drawable.carousel_image1,
                R.drawable.carousel_image2,
                R.drawable.carousel_image3
        );

        ImageAdapter adapter = new ImageAdapter(this, images);
        viewPager2.setAdapter(adapter);

        // Auto-scroll feature
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // 3 detik
            }
        });

        tabTerm = findViewById(R.id.tabTerm);
        tabCondition = findViewById(R.id.tabCondition);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, FragmentOne.class, null)
                .commit();


        tabTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(1);
            }
        });

        tabCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(2);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() < viewPager2.getAdapter().getItemCount() - 1) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            } else {
                viewPager2.setCurrentItem(0);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    private void selectTab(int tabNumber){
        TextView selectedTextView = null;
        TextView nonSelectedTextView1 = null;
        TextView nonSelectedTextView2 = null;

        if(tabNumber == 1){
            selectedTextView = tabTerm;
            nonSelectedTextView1 = tabCondition;
            selectedTextView.setText("Terms");
            nonSelectedTextView1.setText("Conditions");
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, FragmentOne.class, null)
                    .commit();
        } else if(tabNumber == 2){
            selectedTextView = tabCondition;
            nonSelectedTextView1 = tabTerm;
            selectedTextView.setText("Conditions");
            nonSelectedTextView1.setText("Terms");
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, FragmentTwo.class, null)
                    .commit();
        }

        float slideTo = (tabNumber - selectedTabNumber) * selectedTextView.getWidth();
        TranslateAnimation translateAnimation = new TranslateAnimation(0, slideTo, 0, 0);
        translateAnimation.setDuration(100);

        if(selectedTabNumber == 1){
            tabTerm.startAnimation(translateAnimation);
        } else if(selectedTabNumber == 2){
            tabCondition.startAnimation(translateAnimation);
        }

        TextView finalSelectedTextView = selectedTextView;
        TextView finalNonSelectedTextView = nonSelectedTextView1;
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                finalSelectedTextView.setBackgroundResource(R.drawable.round_back_white_100);
                finalSelectedTextView.setTypeface(null, Typeface.BOLD);
                finalSelectedTextView.setTextColor(Color.BLACK);

                finalNonSelectedTextView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
//                finalNonSelectedTextView.setTextColor(Color.parseColor("#1AFFFFFF"));
                finalNonSelectedTextView.setTypeface(null, Typeface.NORMAL);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        selectedTabNumber = tabNumber;
    }
}