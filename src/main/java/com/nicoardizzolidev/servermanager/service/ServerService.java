package com.nicoardizzolidev.servermanager.service;

import java.io.IOException;
import java.util.Collection;

import com.nicoardizzolidev.servermanager.model.Server;

public interface ServerService {
	Server create(Server server);
	Collection<Server> list(int limit);
	Server get(Long id);
	Server update(Server server);
	Boolean delete(Long id);
	Server ping(String ipAdress) throws IOException;
}
