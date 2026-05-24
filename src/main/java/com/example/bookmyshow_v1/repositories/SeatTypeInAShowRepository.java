package com.example.bookmyshow_v1.repositories;

import com.example.bookmyshow_v1.models.Enums.SeatType;
import com.example.bookmyshow_v1.models.MovieShow;
import com.example.bookmyshow_v1.models.SeatTypeInAShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeInAShowRepository extends JpaRepository<SeatTypeInAShow , Long> {

    SeatTypeInAShow findByMovieShowAndSeatType(MovieShow currShow , SeatType currSeatType);
}
