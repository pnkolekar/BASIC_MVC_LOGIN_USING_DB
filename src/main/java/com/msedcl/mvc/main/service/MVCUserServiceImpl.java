package com.msedcl.mvc.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import com.msedcl.mvc.main.entity.*;

import com.msedcl.mvc.main.entity.repository.MVCUsersRepository;



@Service
public class MVCUserServiceImpl {
	private  static  MVCUsersRepository mvcUsersRepository;

	MVCUserServiceImpl(MVCUsersRepository mvcUsersRepository) {
		this.mvcUsersRepository = mvcUsersRepository;
	}
	
	public static List<AppUsers> getAllMVCUsers(){
		List<AppUsers> lst = new ArrayList<>();
		
		lst = mvcUsersRepository.findAll();
		return lst;
		
	}

	public String generateOTP() {
		// TODO Auto-generated method stub
		 // 1. Generate 6-digit OTP
        int otp = 100000 + new Random().nextInt(900000);
        
		return otp+"";
	}
	
	

}
