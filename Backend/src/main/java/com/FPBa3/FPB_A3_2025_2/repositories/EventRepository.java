package com.FPBa3.FPB_A3_2025_2.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FPBa3.FPB_A3_2025_2.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{


    List<Event> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

   
    @Query("SELECT e FROM Event e WHERE DATE(e.dateTime) = DATE(:data)")
    List<Event> findByDia(@Param("data") LocalDate data);
}
	

