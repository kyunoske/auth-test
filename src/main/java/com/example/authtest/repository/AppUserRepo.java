package com.example.authtest.repository;

import com.example.authtest.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepo extends MongoRepository<AppUser, String> {
}
