package com.turkcell.northwind2.dataAccess;

import com.turkcell.northwind2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User>findByUsername(String name);
}
