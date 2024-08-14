package com.example.axforassets;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MenuUtil {

    public static void showMenu(Context context, View anchorView, Class<?> itemListActivityClass) {
        final PopupWindow[] popupWindow = {null};
        anchorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow[0] != null && popupWindow[0].isShowing()) {
                    // If the PopupWindow is showing, dismiss it
                    popupWindow[0].dismiss();
                    popupWindow[0] = null;
                } else {
                    // If the PopupWindow is not showing, show it
                    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.menupopup, null);

                    // ItemPopup for item list
                    TextView itemPopup = popupView.findViewById(R.id.ItemPopup);
                    itemPopup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, itemListActivityClass);
                            context.startActivity(intent);
                        }
                    });


                    //For profile
//                    TextView profilePopup = popupView.findViewById(R.id.ProfilePopup);
//                    profilePopup.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(context, ProfileActivity.class);
//                            context.startActivity(intent);
//                        }
//                    });

                    //For logout
//                    TextView logoutPopup = popupView.findViewById(R.id.LogoutPopup);
//                    logoutPopup.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(context, LoginActivity.class);
//                            context.startActivity(intent);
//                        }
//                    });


                    popupWindow[0] = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    popupWindow[0].setOutsideTouchable(true);
                    popupWindow[0].setFocusable(true);
                    popupWindow[0].showAtLocation(v, Gravity.START, Gravity.END, -350);
                }
            }
        });
    }
}