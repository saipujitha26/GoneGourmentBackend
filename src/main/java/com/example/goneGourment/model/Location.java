package com.example.goneGourment.model;

import jakarta.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
//    @ManyToOne
//    @JoinColumn(name = "restaurant_brand_id")
//    private RestaurantBrand restaurantBrand;

    public Location() {
    }

    public Location(Long id, String city){
//            , RestaurantBrand restaurantBrand) {
        this.id = id;
        this.city = city;
//        this.restaurantBrand = restaurantBrand;
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

//    public RestaurantBrand getRestaurantBrand() {
//        return restaurantBrand;
//    }
//
//    public void setRestaurantBrand(RestaurantBrand restaurantBrand) {
//        this.restaurantBrand = restaurantBrand;
//    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
//                ", restaurantBrand=" + restaurantBrand +
                '}';
    }
}