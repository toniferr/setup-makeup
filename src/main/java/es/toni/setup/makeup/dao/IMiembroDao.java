package es.toni.setup.makeup.dao;

import java.util.List;

import es.toni.setup.makeup.entity.Miembro;

public interface IMiembroDao {
	
	public List<Miembro> findAll();

    public Miembro findById(Integer id);

    public void save(Miembro miembro);

    public void delete(Miembro miembro);

}
