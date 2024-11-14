package com.example.goneGourment.model;

import jakarta.persistence.*;

@Entity

public class UnavailableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String reason;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "restaurant_brand_id")
    private RestaurantBrand restaurantBrand;


    public UnavailableItem() {
    }

    public UnavailableItem(Long id, String name, String reason, Location location, RestaurantBrand restaurantBrand) {
        this.id = id;
        this.name = name;
        this.reason = reason;
        this.location = location;
        this.restaurantBrand = restaurantBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RestaurantBrand getRestaurantBrand() {
        return restaurantBrand;
    }

    public void setRestaurantBrand(RestaurantBrand restaurantBrand) {
        this.restaurantBrand = restaurantBrand;
    }

    @Override
    public String toString() {
        return "UnavailableItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                ", location=" + location +
                ", restaurantBrand=" + restaurantBrand +
                '}';
    }
}