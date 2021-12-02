package com.nicoardizzolidev.servermanager.service.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicoardizzolidev.servermanager.enumeration.Status;
import com.nicoardizzolidev.servermanager.model.Server;
import com.nicoardizzolidev.servermanager.repo.ServerRepo;
import com.nicoardizzolidev.servermanager.service.ServerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
	
	private final ServerRepo serverRepo;

	@Override
	public Server create(Server server) {
		log.info("Saving new server: {}", server.getName());
		server.setImgUrl(setServerImageUrl());
		Server serverGuardado = serverRepo.save(server);
		return serverGuardado;
	}

	@Override
	public Collection<Server> list(int limit) {
		log.info("Fetching all servers");
		List<Server> listOfServers = serverRepo.findAll(PageRequest.of(0, limit)).toList();
		return listOfServers;
	}

	@Override
	public Server get(Long id) {
		log.info("Get  server by id: {}", id);
		Server serverRecuperadoById = serverRepo.findById(id).get();
		return serverRecuperadoById;
	}

	@Override
	public Server update(Server server) {
		log.info("Updating server: {}", server.getName());
		Server serverUpdateado = serverRepo.save(server);
		return serverUpdateado;
	}

	@Override
	public Boolean delete(Long id) {
		log.info("deleting  server by id: {}", id);
		 serverRepo.deleteById(id);
		 return true; 
	}

	@Override
	public Server ping(String ipAdress) throws IOException {
		log.info("Pinging server ip: {}", ipAdress);
		Server server = serverRepo.findByIpAddress(ipAdress);
		InetAddress adress = InetAddress.getByName(ipAdress);
		server.setStatus(adress.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
		serverRepo.save(server);
		return server;
	}
	

	private String setServerImageUrl() {
		String[] imageNames = {"server1", "server2", "server3", "server4"};
		String nombreRandom = imageNames[new Random().nextInt(4)].toString();
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + nombreRandom).toUriString();
	}

}
