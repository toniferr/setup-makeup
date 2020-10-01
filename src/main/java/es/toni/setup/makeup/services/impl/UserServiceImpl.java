package es.toni.setup.makeup.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.toni.setup.makeup.dao.IUserDao;
import es.toni.setup.makeup.entity.Usuario;
import es.toni.setup.makeup.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public Usuario findByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
