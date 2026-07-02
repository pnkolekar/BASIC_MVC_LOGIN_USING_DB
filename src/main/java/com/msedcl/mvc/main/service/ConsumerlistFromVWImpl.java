package com.msedcl.mvc.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.mvc.main.entity.CONSUMER_FROM_VW;
import com.msedcl.mvc.main.repository.ConsumerlistFromVW;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerlistFromVWImpl {

	private static ConsumerlistFromVW consumerlistFromVW;
	
	public ConsumerlistFromVWImpl(ConsumerlistFromVW pConsumerlistFromVW) {
		// TODO Auto-generated constructor stub
		this.consumerlistFromVW = pConsumerlistFromVW;
	}
	
	public static List<CONSUMER_FROM_VW> getAllConsList(){
		return consumerlistFromVW.findAll();
	}
	
}
