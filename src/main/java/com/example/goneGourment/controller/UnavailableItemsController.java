package com.example.goneGourment.controller;

import com.example.goneGourment.model.Location;
import com.example.goneGourment.model.RestaurantBrand;
import com.example.goneGourment.model.UnavailableItem;
import com.example.goneGourment.repo.LocationRepository;
import com.example.goneGourment.repo.RestaurantBrandRepository;
import com.example.goneGourment.repo.UnavailableItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UnavailableItemsController {
    @Autowired
    private RestaurantBrandRepository brandRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UnavailableItemRepository unavailableItemRepository;

    @GetMapping("/brands")
    public List<RestaurantBrand> getBrands() {
        return brandRepository.findAll();
    }

//    @GetMapping("/locations/{brandId}")
//    public List<Location> getLocationsByBrand(@PathVariable Long id) {
//        return locationRepository.findByLocationId(id);
//    }

    @GetMapping("/unavailable-items/{locationId}")
    public List<UnavailableItem> getUnavailableItems(@PathVariable Long locationId) {
        return unavailableItemRepository.findByLocationId(locationId);
    }
    @GetMapping("/restaurantBrands")
    public List<RestaurantBrand> getRestaurantBrands() {
        return brandRepository.findAll();
    }

    // Get list of all locations
    @GetMapping("/locations")
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    // Get unavailable items based on selected brand and location
    @GetMapping("/unavailableItems")
    public List<UnavailableItem> getUnavailableItems(
            @RequestParam Long brandId,
            @RequestParam Long locationId
    ) {
        return unavailableItemRepository.findByRestaurantBrandIdAndLocationId(brandId, locationId);
    }
    @PostMapping("/restaurantBrands")
    public ResponseEntity<RestaurantBrand> createRestaurantBrand(@RequestBody RestaurantBrand brand) {
        RestaurantBrand savedBrand = brandRepository.save(brand);
        return new ResponseEntity<>(savedBrand, HttpStatus.CREATED);
    }

    // POST method to create a new location
    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location savedLocation = locationRepository.save(location);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    // POST endpoint to save unavailable items for a specific location and brand
    @PostMapping("/unavailableItems")
    public ResponseEntity<UnavailableItem> saveUnavailableItem(
            @RequestParam Long brandId,
            @RequestParam Long locationId,
            @RequestBody UnavailableItem unavailableItem
    ) {
        RestaurantBrand brand = brandRepository.findById(brandId).orElse(null);
        Location location = locationRepository.findById(locationId).orElse(null);

        if (brand == null || location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        unavailableItem.setRestaurantBrand(brand);
        unavailableItem.setLocation(location);

        UnavailableItem savedItem = unavailableItemRepository.save(unavailableItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/unavailableItemsByParams")
    public List<UnavailableItem> getUnavailableItemsByParams(
            @RequestParam Long brandId,
            @RequestParam Long locationId
    ) {
        return unavailableItemRepository.findByRestaurantBrandIdAndLocationId(brandId, locationId);
    }
}
