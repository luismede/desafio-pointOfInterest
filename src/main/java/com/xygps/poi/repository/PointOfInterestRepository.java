package com.xygps.poi.repository;

import com.xygps.poi.model.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {
    @Query(value = "SELECT tb.id, tb.name, tb.coord_x, tb.coord_y " +
            "FROM TB_POINT_OF_INTEREST tb " +
            "WHERE " +
            "  POWER(tb.coord_x - :position_x, 2) +" +
            "  POWER(tb.coord_y - :position_y, 2) <= POWER(:dmax, 2)", nativeQuery = true)
    List<PointOfInterest> findAllByNearbyLocation(@Param("dmax") Long dmax,
                                                  @Param("position_x") Long position_x,
                                                  @Param("position_y") Long position_y);
}
