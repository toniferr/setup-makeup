package es.toni.setup.makeup.models.services;

import es.toni.setup.makeup.models.entity.Usuario;

public interface IUserService {
	
	public Usuario findByUsername(String username);
}
