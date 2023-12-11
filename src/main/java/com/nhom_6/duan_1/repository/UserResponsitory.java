package com.nhom_6.duan_1.repository;

import com.nhom_6.duan_1.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserResponsitory  extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
