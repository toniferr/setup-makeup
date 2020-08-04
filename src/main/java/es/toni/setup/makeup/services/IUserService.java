package es.toni.setup.makeup.services;

import es.toni.setup.makeup.entity.Usuario;

public interface IUserService {
	
	public Usuario findByUsername(String username);
}
