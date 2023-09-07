package com.simplifiedpicpay.repositories;

import com.simplifiedpicpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // That method here is going to be responsible to search in the database,
    // and check if the document received on the parameter have a user
    // its Optional, because can or cannot return a User.
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(Long id);

}
