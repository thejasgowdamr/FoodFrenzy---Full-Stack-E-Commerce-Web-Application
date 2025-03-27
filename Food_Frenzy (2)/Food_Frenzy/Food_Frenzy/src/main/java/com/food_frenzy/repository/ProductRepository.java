package com.food_frenzy.repository;



import org.springframework.data.repository.CrudRepository;

import com.food_frenzy.entity.Product;


public interface ProductRepository extends CrudRepository<Product,Integer>
{
	public Product findByPname(String name);

}
