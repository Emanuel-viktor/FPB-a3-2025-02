package com.FPBa3.FPB_A3_2025_2.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FPBa3.FPB_A3_2025_2.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{


    List<Event> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

   
    default List<Event> findByDay(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);
        return findByDateTimeBetween(startOfDay, endOfDay);
    }
}
	

