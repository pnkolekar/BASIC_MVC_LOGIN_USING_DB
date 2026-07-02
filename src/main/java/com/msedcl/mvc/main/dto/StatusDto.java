package com.msedcl.mvc.main.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "REQUEST_STATUS")
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {
    @Id
    @Column(name = "ACTION_ID")
	private int code;
    public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "ACTION_DESC")
	private String description;
    // constructor, getters, setters
}