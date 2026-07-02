package com.msedcl.mvc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msedcl.mvc.main.entity.CONSUMER_FROM_VW;

@Repository
public interface ConsumerlistFromVW  extends JpaRepository<CONSUMER_FROM_VW, String>{
	List<CONSUMER_FROM_VW> findAll();

	List<CONSUMER_FROM_VW> findByActionId(String actionId);
	
}
