package com.example.goneGourment.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    @ManyToOne
    @JoinColumn(name = "restaurant_brand_id")
    private List<RestaurantBrand> restaurantBrands;

    public Location() {
    }

    public Location(Long id, String city, List<RestaurantBrand> restaurantBrands) {
        this.id = id;
        this.city = city;
        this.restaurantBrands = restaurantBrands;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<RestaurantBrand> getRestaurantBrand() {
        return restaurantBrands;
    }

    public void setRestaurantBrand(List<RestaurantBrand> restaurantBrands) {
        this.restaurantBrands = restaurantBrands;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", restaurantBrands=" + restaurantBrands +
                '}';
    }
}