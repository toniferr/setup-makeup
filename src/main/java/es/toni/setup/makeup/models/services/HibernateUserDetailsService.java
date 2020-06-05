package es.toni.setup.makeup.models.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.toni.setup.makeup.models.dao.IUserDao;
import es.toni.setup.makeup.models.dao.UsuarioDaoHibernateTemplate;
import es.toni.setup.makeup.models.entity.Role;
import es.toni.setup.makeup.models.entity.Usuario;

@Service("hibernateUserDetailsService")
public class HibernateUserDetailsService implements UserDetailsService{

	protected final Logger logger = LoggerFactory.getLogger(UsuarioDaoHibernateTemplate.class);
	
	@Autowired
	private IUserDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByUsername(username);

		if (usuario == null) {
			logger.error("Error login: No se encuentra el usuario con '" + username + "'");
			throw new UsernameNotFoundException("Username " + username + " no encontrado");
		}
		
		logger.info("Username: " + usuario.getUsername());
		logger.info("Num. Roles: " + usuario.getRoles().size());

		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>();
		
		for (Role role : usuario.getRoles()) {
			logger.info("Role: " + role.getAuthority());
			dbAuths.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		if (dbAuths.size() == 0) {
			logger.error("Usuario '" + username
					+ "' no tiene roles asignados y será tratado como 'no encontrado'");
			throw new UsernameNotFoundException("Usuario ' " + username + " no tiene roles asignados");
		}
		
		return new User(username, usuario.getPassword(), usuario.getEnabled(), true, true, true, dbAuths);
	}

}
