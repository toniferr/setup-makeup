package es.toni.setup.makeup.models.dao;

import java.util.List;

import es.toni.setup.makeup.models.entity.Categoria;
import es.toni.setup.makeup.models.entity.Usuario;

public interface ICategoriaDao {

	public List<Categoria> findAll();
	
	public List<Categoria> findCategoriaPrimariasByUser(Usuario usuario);	

	public List<Categoria> findCategoriaSegundariasByUser(Usuario usuario, Long categoriaId);

    public Categoria findById(Long id);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);
    
}
