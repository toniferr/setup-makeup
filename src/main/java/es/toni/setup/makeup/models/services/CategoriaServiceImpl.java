package es.toni.setup.makeup.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.toni.setup.makeup.models.dao.ICategoriaDao;
import es.toni.setup.makeup.models.entity.Categoria;
import es.toni.setup.makeup.models.entity.Usuario;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaDao.findAll();
	}
	
	@Override
	public List<Categoria> findCategoriaPrimariasByUser(Usuario usuario) {
		return categoriaDao.findCategoriaPrimariasByUser(usuario);
	}

	@Override
	public Categoria findById(int id) {
		return categoriaDao.findById(id);
	}

	@Override
	public void save(Categoria categoria) {
		categoriaDao.save(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		categoriaDao.delete(categoria);
	}

}
