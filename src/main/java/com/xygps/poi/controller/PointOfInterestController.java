package com.xygps.poi.controller;

import com.xygps.poi.dto.PointOfInterestDTO;
import com.xygps.poi.model.PointOfInterest;
import com.xygps.poi.service.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points")
public class PointOfInterestController {
    @Autowired
    private PointOfInterestService service;


    @PostMapping("/create")
    public ResponseEntity<PointOfInterest> createPoi(@RequestBody PointOfInterestDTO dto) {
        PointOfInterest poi = service.createPoi(dto.transformToObject());
        return new ResponseEntity<>(poi, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PointOfInterestDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/nearby")
    public List<PointOfInterestDTO> listAllByLocation(@RequestParam Long max_distance, Long position_x, Long position_y) {
        return service.findAllByNearbyLocation(max_distance, position_x, position_y);
    }
}
