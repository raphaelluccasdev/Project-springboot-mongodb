package com.raphaelluccas.springbootmongodb.repository;


import com.raphaelluccas.springbootmongodb.domain.Post;
import com.raphaelluccas.springbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
