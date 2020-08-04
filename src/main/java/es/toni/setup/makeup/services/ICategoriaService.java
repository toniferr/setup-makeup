package es.toni.setup.makeup.services;

import java.util.List;

import es.toni.setup.makeup.entity.Categoria;
import es.toni.setup.makeup.entity.Usuario;

public interface ICategoriaService {

	public List<Categoria> findAll();
	
    public List<Categoria> findCategoriaPrimariasByUser(Usuario usuario);

	public List<Categoria> findCategoriaSegundariasByUser(Usuario usuario, Long categoriaId);

    public Categoria findById(Long categoriaId);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);

}
