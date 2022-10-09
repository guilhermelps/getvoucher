package com.guilherme.getvoucher.repository;

import com.guilherme.getvoucher.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
