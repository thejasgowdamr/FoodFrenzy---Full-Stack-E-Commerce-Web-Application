package com.food_frenzy.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food_frenzy.entity.Order;
import com.food_frenzy.entity.User;
import com.food_frenzy.repository.OrderRepository;


@Component
public class OrderServices
{
	@Autowired
	private OrderRepository orderRepository;
	public List<Order> getOrders()
	{
		List<Order> list=this.orderRepository.findAll();
		return list;
	}
	public void saveOrder(Order order)
	{
		this.orderRepository.save(order);
	}

	public void updateOrder(int id,Order order)
	{
		order.setoId(id);
		this.orderRepository.save(order);
		 
	}

	public void deleteOrder(int id)
	{
		this.orderRepository.deleteById(id);
	}

	public List<Order> getOrdersForUser(User user)
	{
	 return  this.orderRepository.findOrdersByUser(user);
	}
	
}