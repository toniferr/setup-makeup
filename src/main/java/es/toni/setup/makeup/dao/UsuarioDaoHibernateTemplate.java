package es.toni.setup.makeup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.toni.setup.makeup.entity.Usuario;

@Repository
public class UsuarioDaoHibernateTemplate implements IUserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByUsername(String username) {
		
		List<Usuario> results = (List<Usuario>) hibernateTemplate.findByNamedParam("from Usuario u where u.username = :username", "username", username);
		
		if (results.size() == 1) {
			return results.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) hibernateTemplate.find("from Usuario");
	}

	@Override
	public Usuario findById(Integer id) {
		return (Usuario) hibernateTemplate.get(Usuario.class, id);
	}

	@Override
	public void save(Usuario user) {
		hibernateTemplate.saveOrUpdate(user);
	}

	@Override
	public void delete(Usuario user) {
		hibernateTemplate.delete(user);
	}

}
