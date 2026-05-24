package com.example.bookmyshow_v1.repositories;

import com.example.bookmyshow_v1.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser , Long> {
}
