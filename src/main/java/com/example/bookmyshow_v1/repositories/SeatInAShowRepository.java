package com.example.bookmyshow_v1.repositories;

import com.example.bookmyshow_v1.models.SeatInAShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatInAShowRepository extends JpaRepository<SeatInAShow , Long> {
}
