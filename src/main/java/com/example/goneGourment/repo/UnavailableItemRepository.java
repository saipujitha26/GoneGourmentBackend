package com.example.goneGourment.repo;

import com.example.goneGourment.model.UnavailableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UnavailableItemRepository extends JpaRepository<UnavailableItem, Long> {
    List<UnavailableItem> findByLocationId(Long locationId);
    List<UnavailableItem> findByRestaurantBrandIdAndLocationId(Long brandId, Long locationId);
}