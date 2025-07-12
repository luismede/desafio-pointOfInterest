package com.xygps.poi.dto;

import com.xygps.poi.model.PointOfInterest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterestDTO {
    private String name;
    private Long x;
    private Long y;

    public PointOfInterest transformToObject() {
        return new PointOfInterest(name, x, y);
    }

}
