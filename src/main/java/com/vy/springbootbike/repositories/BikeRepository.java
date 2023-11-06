package com.vy.springbootbike.repositories;

import com.vy.springbootbike.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository <Bike, Long> {


}
