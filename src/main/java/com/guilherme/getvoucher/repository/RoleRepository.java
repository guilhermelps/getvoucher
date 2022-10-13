package com.guilherme.getvoucher.repository;

import com.guilherme.getvoucher.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
}
