package com.vy.springbootbike.contrallers;

import com.vy.springbootbike.models.Bike;
import com.vy.springbootbike.repositories.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    private BikeRepository bikeRepository;

    public BikesController(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @GetMapping
    public List<Bike> getBikesList() {
        return bikeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bike getBikeById(@PathVariable Long id) {
        return bikeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBike(@RequestBody Bike bike) {
        bikeRepository.save(bike);
    }

    @GetMapping("/inject")
    @ResponseStatus(HttpStatus.CREATED)
    public void injectBikesToDB() {
        Bike firstBike = new Bike();
        firstBike.setName("FirstBike");
        firstBike.setPurchaseDate(new Date());
        Bike secondBike = new Bike();
        secondBike.setName("SecondBike");
        Bike thirdBike = new Bike();
        secondBike.setName("ThirdBike");
        secondBike.setPurchaseDate(new Date());
        bikeRepository.save(firstBike);
        bikeRepository.save(secondBike);
    }

}
