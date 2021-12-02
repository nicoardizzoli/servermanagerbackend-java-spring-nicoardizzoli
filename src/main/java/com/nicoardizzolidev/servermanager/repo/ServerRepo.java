package com.nicoardizzolidev.servermanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicoardizzolidev.servermanager.model.Server;

public interface ServerRepo extends JpaRepository<Server, Long> {
	
	public Server findByIpAddress(String ipAdress);

}
