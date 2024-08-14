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

    public static void showMenu(Context context, View anchorView, String currentPage) {
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

                    // TextViews for menu items
                    TextView firstPopupItem = popupView.findViewById(R.id.FirstPopupItem);
                    TextView secondPopupItem = popupView.findViewById(R.id.SecondPopupItem);
                    TextView thirdPopupItem = popupView.findViewById(R.id.ThirdPopupItem);

                    // Set the text and click listeners of the TextViews based on the current page
                    switch (currentPage) {
                        case "Home":
                            firstPopupItem.setText("Items");
                            firstPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, ItemListActivity.class)));

                            secondPopupItem.setText("Profile");
                            secondPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, ProfileActivity.class)));

                            thirdPopupItem.setText("Logout");
                            thirdPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, LoginActivity.class)));
                            break;
                        case "Profile":
                            firstPopupItem.setText("Home");
                            firstPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, HomeActivity.class)));

                            secondPopupItem.setText("Items");
                            secondPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, ItemListActivity.class)));

                            thirdPopupItem.setText("Logout");
                            thirdPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, LoginActivity.class)));
                            break;
                        case "ItemList":
                            firstPopupItem.setText("Home");
                            firstPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, HomeActivity.class)));

                            secondPopupItem.setText("Profile");
                            secondPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, ProfileActivity.class)));

                            thirdPopupItem.setText("Logout");
                            thirdPopupItem.setOnClickListener(v1 -> context.startActivity(new Intent(context, LoginActivity.class)));
                            break;
                    }

                    popupWindow[0] = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    popupWindow[0].setOutsideTouchable(true);
                    popupWindow[0].setFocusable(true);
                    popupWindow[0].showAtLocation(v, Gravity.START, Gravity.END, -350);
                }
            }
        });
    }
}