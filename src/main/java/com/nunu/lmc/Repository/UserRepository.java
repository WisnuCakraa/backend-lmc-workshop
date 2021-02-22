package com.nunu.lmc.Repository;

import com.nunu.lmc.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u from User u where u.userName = ?1")
    Optional<User> findUserByUserName(String userName);
}
