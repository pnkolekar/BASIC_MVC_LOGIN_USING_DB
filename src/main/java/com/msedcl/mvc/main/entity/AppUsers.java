package com.msedcl.mvc.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MVC_USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUsers {
	@Id
	@Column(name = "username")
	private String usernames;

}
