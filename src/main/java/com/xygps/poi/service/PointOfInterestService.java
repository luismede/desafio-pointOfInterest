package com.xygps.poi.service;

import com.xygps.poi.dto.PointOfInterestDTO;
import com.xygps.poi.model.PointOfInterest;
import com.xygps.poi.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointOfInterestService {
    @Autowired
    private PointOfInterestRepository repository;

    public List<PointOfInterestDTO> findAll() {
        return this.repository.findAll()
                .stream()
                .map(pointOfInterest -> new PointOfInterestDTO(pointOfInterest.getName(), pointOfInterest.getX(), pointOfInterest.getY()))
                .toList();
    }

    public List<PointOfInterestDTO> findAllByNearbyLocation(Long dmax, Long position_x, Long position_y) {
        return this.repository.findAllByNearbyLocation(dmax, position_x, position_y)
                .stream()
                .map(pointOfInterest -> new PointOfInterestDTO(pointOfInterest.getName(), pointOfInterest.getX(), pointOfInterest.getY()))
                .toList();
    }

    public PointOfInterest createPoi(PointOfInterest poi) {
        return this.repository.save(poi);
    }
}
