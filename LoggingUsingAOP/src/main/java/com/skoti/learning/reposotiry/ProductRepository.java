package com.skoti.learning.reposotiry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skoti.learning.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
