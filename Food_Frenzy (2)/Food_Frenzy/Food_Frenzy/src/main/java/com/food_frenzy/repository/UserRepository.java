package com.food_frenzy.repository;



import org.springframework.data.repository.CrudRepository;

import com.food_frenzy.entity.User;



public interface UserRepository extends CrudRepository<User,Integer>
{
public User findUserByUemail(String email);
}