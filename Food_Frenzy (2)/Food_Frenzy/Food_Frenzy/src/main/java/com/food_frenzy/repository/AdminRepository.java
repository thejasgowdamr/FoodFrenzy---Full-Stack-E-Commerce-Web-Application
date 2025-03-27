package com.food_frenzy.repository;





import org.springframework.data.repository.CrudRepository;

import com.food_frenzy.entity.Admin;



public interface AdminRepository extends CrudRepository<Admin, Integer>
{
	public Admin findByAdminEmail(String email);
}
