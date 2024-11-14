package com.example.goneGourment.repo;

import com.example.goneGourment.model.RestaurantBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantBrandRepository extends JpaRepository<RestaurantBrand, Long> {}