package com.simplifiedpicpay.services;

import com.simplifiedpicpay.domain.user.User;
import com.simplifiedpicpay.domain.user.UserType;
import com.simplifiedpicpay.dtos.UserDTO;
import com.simplifiedpicpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    // This class needs to access UserRepository to make the manipulation
    @Autowired
    private UserRepository repository;

    //  Validating transactions, because only the merchant UserType are allowed to make transactions
    //  and also validating the balance of the sender.
    public void validateTransaction(User sender, BigDecimal amount) throws Exception {

        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Common user isn't allowed to make transactions");
        }
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("User balance isn't enough");
        }

    }

    // Return a user, I will need to create a TransactionService, this class will have your users,
    // with the requisitions of users id, but I don't want that TransactionService to have
    // directly access to the UserRepository. TransactionService just going to manipulate the UserRepository,
    // so that means, if TransactionService wants to change the users from the table users,
    // he uses the UserService
    public User findUserById(Long id) throws Exception {

        return this.repository.findUserById(id).orElseThrow(() -> new Exception("User not found"));

    }

    public User createUser(UserDTO data) {

        User newUser = new User(data);
        this.saveUser(newUser);

        return newUser;
    }

    public List<User> getAllUsers() {

        return this.repository.findAll();

    }

    // This method will just save and make the persistence of this user.
    public void saveUser(User user) {

        this.repository.save(user);
    }

}
