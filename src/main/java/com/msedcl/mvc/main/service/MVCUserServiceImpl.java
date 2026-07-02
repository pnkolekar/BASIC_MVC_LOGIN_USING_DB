package com.msedcl.mvc.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;
import com.msedcl.mvc.main.entity.*;
import com.msedcl.mvc.main.repository.MVCUsersRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class MVCUserServiceImpl {
	private  static  MVCUsersRepository mvcUsersRepository;

	MVCUserServiceImpl(MVCUsersRepository mvcUsersRepository) {
		this.mvcUsersRepository = mvcUsersRepository;
	}
	
	public static List<AppUsers> getAllMVCUsers(){
		List<AppUsers> lst = new ArrayList<>();
		
		lst = mvcUsersRepository.findAll();
		for (AppUsers appUsers : lst) {
			//log.info(appUsers.toString());
		}
		return lst;
		
	}
	
	public AppUsers getByUsername(String uname) {
	    return mvcUsersRepository.findByUsernames(uname); // or throw exception if not found
	}

	public String generateOTP() {
		// TODO Auto-generated method stub
		 // 1. Generate 6-digit OTP
        int otp = 100000 + new Random().nextInt(900000);
        
		return otp+"";
	}
	
	

}
