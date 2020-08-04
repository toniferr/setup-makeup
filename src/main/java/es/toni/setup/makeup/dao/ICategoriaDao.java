package es.toni.setup.makeup.dao;

import java.util.List;

import es.toni.setup.makeup.entity.Categoria;
import es.toni.setup.makeup.entity.Usuario;

public interface ICategoriaDao {

	public List<Categoria> findAll();
	
	public List<Categoria> findCategoriaPrimariasByUser(Usuario usuario);	

	public List<Categoria> findCategoriaSegundariasByUser(Usuario usuario, Long categoriaId);

    public Categoria findById(Long id);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);
    
}
