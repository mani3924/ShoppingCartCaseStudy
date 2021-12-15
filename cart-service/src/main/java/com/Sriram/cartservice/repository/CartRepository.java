package com.Sriram.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Sriram.cartservice.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer>{

}
