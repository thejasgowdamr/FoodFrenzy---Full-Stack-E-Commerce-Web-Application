package com.food_frenzy.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_frenzy.entity.Order;
import com.food_frenzy.entity.User;



public interface OrderRepository extends JpaRepository<Order, Integer>
{
	List<Order> findOrdersByUser(User user);
}