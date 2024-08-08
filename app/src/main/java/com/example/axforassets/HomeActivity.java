package com.example.axforassets;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Arrays;
import java.util.List;
public class HomeActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        viewPager2 = findViewById(R.id.viewPager);

        List<Integer> images = Arrays.asList(
                R.drawable.carousel1,
                R.drawable.second,
                R.drawable.third,
                R.drawable.fourth,
                R.drawable.fifth
        );

        ImageAdapter adapter = new ImageAdapter(this, images);
        viewPager2.setAdapter(adapter);

        // Auto-scroll feature
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // 3 seconds
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
}