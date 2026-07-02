package com.msedcl.mvc.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msedcl.mvc.main.repository.AllStatusCodesRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.msedcl.mvc.main.dto.*;

@Slf4j
@Service
public class AllStatusCodesServiceImpl {

	
	private static AllStatusCodesRepo allStatusCodesRepo;
	AllStatusCodesServiceImpl(AllStatusCodesRepo repoObj){
		this.allStatusCodesRepo = repoObj;
	}
	
	public static List<StatusDto> getAllStausCodes(){
		return allStatusCodesRepo.findAll();
		
	}
	
}
