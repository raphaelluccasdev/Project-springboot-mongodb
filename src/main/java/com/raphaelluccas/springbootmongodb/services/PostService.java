package com.raphaelluccas.springbootmongodb.services;

import com.raphaelluccas.springbootmongodb.domain.Post;
import com.raphaelluccas.springbootmongodb.domain.User;
import com.raphaelluccas.springbootmongodb.dto.UserDto;
import com.raphaelluccas.springbootmongodb.exceptions.ObjectNotFoundException;
import com.raphaelluccas.springbootmongodb.repository.PostRepository;
import com.raphaelluccas.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }

}
