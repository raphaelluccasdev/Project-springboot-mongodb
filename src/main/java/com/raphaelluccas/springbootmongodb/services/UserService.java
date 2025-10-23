package com.raphaelluccas.springbootmongodb.services;

import com.raphaelluccas.springbootmongodb.domain.User;
import com.raphaelluccas.springbootmongodb.dto.UserDto;
import com.raphaelluccas.springbootmongodb.exceptions.ObjectNotFoundException;
import com.raphaelluccas.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDto(UserDto objDto) {
        return new User(objDto.getId(), objDto.getName(),  objDto.getEmail());
    }

}
