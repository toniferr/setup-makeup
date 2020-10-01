package es.toni.setup.makeup.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.toni.setup.makeup.dao.ICategoriaDao;
import es.toni.setup.makeup.entity.Categoria;
import es.toni.setup.makeup.entity.Usuario;
import es.toni.setup.makeup.services.ICategoriaService;

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
	public List<Categoria> findCategoriaSegundariasByUser(Usuario usuario, Long categoriaId) {
		return categoriaDao.findCategoriaSegundariasByUser(usuario, categoriaId);
	}
	
	@Override
	public Categoria findById(Long id) {
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
