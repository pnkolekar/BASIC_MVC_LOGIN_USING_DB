package com.msedcl.mvc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msedcl.mvc.main.dto.StatusDto;

@Repository
public interface AllStatusCodesRepo extends JpaRepository<StatusDto, Integer>{
	List<StatusDto> findAll();


}
