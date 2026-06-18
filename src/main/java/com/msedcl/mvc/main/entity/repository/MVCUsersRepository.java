package com.msedcl.mvc.main.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msedcl.mvc.main.entity.AppUsers;

public interface MVCUsersRepository extends JpaRepository<AppUsers, String>{
	List<AppUsers> findAll();

}
