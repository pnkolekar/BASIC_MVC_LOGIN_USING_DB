package com.msedcl.mvc.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VW_LIST_FOR_VENDOR_MVC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CONSUMER_FROM_VW {

	@Id
	@Column(name = "CONSUMER_NUMBER")
	String ConsumerNo;
	@Column(name = "CONSUMER_NAME")
	String ConsumerName;
	@Column(name = "CIRCLE")
	String Circle;
	@Column(name = "TENDER")
	String TenderNo;
	@Column(name ="LOAD_HP")
	String LoadHP;
	
	
	
}
