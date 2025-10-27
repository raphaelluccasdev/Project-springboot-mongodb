package com.raphaelluccas.springbootmongodb.services;

import com.raphaelluccas.springbootmongodb.domain.Post;
import com.raphaelluccas.springbootmongodb.domain.User;
import com.raphaelluccas.springbootmongodb.dto.UserDto;
import com.raphaelluccas.springbootmongodb.exceptions.ObjectNotFoundException;
import com.raphaelluccas.springbootmongodb.repository.PostRepository;
import com.raphaelluccas.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + (1000 * 60 * 60 * 24));
        return repo.fullSearch(text, minDate, maxDate);
    }

}
