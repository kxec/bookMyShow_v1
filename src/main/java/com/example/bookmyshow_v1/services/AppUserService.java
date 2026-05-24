package com.example.bookmyshow_v1.services;


import com.example.bookmyshow_v1.models.AppUser;
import com.example.bookmyshow_v1.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository)
    {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getUserById(Long userId)
    {

        Optional<AppUser> appUserWrapper = AppUserRepository.findUserById(userId);

        return appUserWrapper.orElse(null);

    }



}
