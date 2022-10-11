package com.example.authtest.service;

import com.example.authtest.model.AppUser;
import com.example.authtest.repository.AppUserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    public AppUserDetailsService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public AppUser addUser(AppUser user) {
        return appUserRepo.save(user);
    }

//    public List<AppUser> getAllUsers() {
//        return appUserRepo.findAll();
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepo.findById(username).orElse(null);
        if (user == null) {
            return null;
        }

        return new User(user.getUsername(), user.getPasswordHash(), Collections.emptyList());
    }


}
