package com.nicoardizzolidev.servermanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.nicoardizzolidev.servermanager.enumeration.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(unique = true)
	@NotEmpty(message = "IP Adress cannot be empty or null")
	private String ipAddress;
	
	private String name; 
	private String memory; 
	private String type;
	private String imgUrl;
	private Status status; 

}
