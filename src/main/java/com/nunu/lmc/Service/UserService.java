package com.nunu.lmc.Service;

import com.nunu.lmc.Constants;
import com.nunu.lmc.Entity.ErrorException;
import com.nunu.lmc.Entity.User;
import com.nunu.lmc.Repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "fullname"));
    }

    public void addUser(User user){
        //check userName exist
        Optional<User> userName = userRepository.findUserByUserName(user.getUserName());
        ErrorException error = new ErrorException(Constants.USERNAME_EXIST_ERROR_CODE, "Username is exist");

        if(userName.isPresent()) {
            throw  new IllegalStateException(error.getFullErrorMessage());
        }

        //if success then save user
        userRepository.save(user);
    }

    public void deleteUser(String userId) {
        boolean exist = userRepository.existsById(userId);
        ErrorException error = new ErrorException(Constants.ID_NOT_EXIST_ERROR_CODE, "User ID doesnt exist");

        if(!exist) {
            throw new IllegalStateException(error.getFullErrorMessage());
        }

        userRepository.deleteById(userId);
    }
}
