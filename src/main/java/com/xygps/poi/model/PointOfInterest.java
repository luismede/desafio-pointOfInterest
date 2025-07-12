package com.xygps.poi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PointOfInterest")
@Table(name = "tb_pointOfInterest")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PointOfInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "coord_x")
    private Long x;
    @Column(name = "coord_y")
    private Long y;

    public PointOfInterest(String name, Long x, Long y) {
        this.name = name; this.x = x; this.y = y;
    }
}
