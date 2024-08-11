package com.example.axforassets;

public class SelectedItem {
    private String name;
    // image
    private int routeId;


    public SelectedItem(String name, int routeId) {
        this.name = name;
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public int getRouteId() {
        return routeId;
    }

}
