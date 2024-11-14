package com.example.goneGourment.model;


import jakarta.persistence.*;

@Entity
    public class RestaurantBrand {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        // Getters and setters

    public RestaurantBrand() {
    }

    public RestaurantBrand(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "RestaurantBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}






