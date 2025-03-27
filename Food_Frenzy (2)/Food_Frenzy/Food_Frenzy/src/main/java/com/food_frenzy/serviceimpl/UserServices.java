package com.food_frenzy.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food_frenzy.entity.User;
import com.food_frenzy.repository.UserRepository;



@Component
public class UserServices 
{
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser()
	{
		List<User> users = (List<User>) this.userRepository.findAll();
		return users;
	}

	public User getUser(int id)
	{
		Optional<User> optional = this.userRepository.findById(id);
		User user = optional.get();
		return user;
	}
	public User getUserByEmail(String email)
	{
	 User user=	this.userRepository.findUserByUemail(email);
	 return user;
	}

	public void updateUser(User user,int id)
	{
		user.setU_id(id);
		 this.userRepository.save(user);
	}

	public void deleteUser(int id)
	{
		this.userRepository.deleteById(id);
	}

	public void addUser(User user)
	{
	this.userRepository.save(user);
	}
	
	public boolean validateLoginCredentials(String email,String password)
	{
		List<User> users = (List<User>) this.userRepository.findAll();
		for(User u:users)
		{
		if(u!=null && u.getUpassword().equals(password) && u.getUemail().equals(email))
		{
			return true;
		}
		}
		return false;
	}

	
	public boolean userExists(String uemail) {
	    // Use the UserRepository to check if the email exists
	    return userRepository.findUserByUemail(uemail) != null;
	}

}