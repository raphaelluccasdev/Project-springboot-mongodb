package com.raphaelluccas.springbootmongodb.resources;

import com.raphaelluccas.springbootmongodb.domain.Post;
import com.raphaelluccas.springbootmongodb.domain.User;
import com.raphaelluccas.springbootmongodb.dto.UserDto;
import com.raphaelluccas.springbootmongodb.services.PostService;
import com.raphaelluccas.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
