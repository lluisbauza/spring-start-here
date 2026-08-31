package com.lluisbauza.activity13cinemaseatmanager.repository;

import com.lluisbauza.activity13cinemaseatmanager.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    //derived query by name
    List<Seat> findByBookedFalse();
    Seat findByCode(String code);

    //personalized UPDATE operation with @Modigying and @Query, with JPQL
    @Modifying
    @Query("UPDATE Seat s SET s.price = :price WHERE s.id = :id")
    int updatePrice(@Param("price") BigDecimal price, @Param("id") Long id);


}
