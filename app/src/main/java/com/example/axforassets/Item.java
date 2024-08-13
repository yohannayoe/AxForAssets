package com.example.axforassets;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Item implements Parcelable {
    private int imageResource;
    private String itemName;
    private ArrayList<Item> variations;
    private String itemDescription;
    private String itemPrice;



    public Item(int imageResource, String itemName, ArrayList<Item> variations, String itemDescription, String itemPrice) {
        this.imageResource = imageResource;
        this.itemName = itemName;
        this.variations = variations;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    protected Item(Parcel in) {
        imageResource = in.readInt();
        itemName = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Item(int image, String itemName) {
        this.imageResource = image;
        this.itemName = itemName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public ArrayList<Item> getVariations() {
        return variations;
    }

    public void setVariations(ArrayList<Item> variations) {
        this.variations = variations;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageResource);
        parcel.writeString(itemName);
    }
}