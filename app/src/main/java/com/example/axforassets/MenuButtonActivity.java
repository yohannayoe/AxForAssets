package com.example.axforassets;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class MenuButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menubutton);

        ImageView menuButton = findViewById(R.id.menuButton);
        final PopupWindow[] popupWindow = {null};
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow[0] != null && popupWindow[0].isShowing()) {
                    // If the PopupWindow is showing, dismiss it
                    popupWindow[0].dismiss();
                    popupWindow[0] = null;
                } else {
                    // If the PopupWindow is not showing, show it
                    LayoutInflater layoutInflater = (LayoutInflater) MenuButtonActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.menupopup, null);

                    popupWindow[0] = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    popupWindow[0].showAtLocation(v, Gravity.START, Gravity.END, -300);
                }
            }
        });
    }
}