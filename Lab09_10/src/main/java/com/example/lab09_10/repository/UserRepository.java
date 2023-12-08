package com.example.lab09_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lab09_10.model.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
}
