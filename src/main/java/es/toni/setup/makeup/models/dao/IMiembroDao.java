package es.toni.setup.makeup.models.dao;

import java.util.List;

import es.toni.setup.makeup.models.entity.Miembro;

public interface IMiembroDao {
	
	public List<Miembro> findAll();

    public Miembro findById(Integer id);

    public void save(Miembro miembro);

    public void delete(Miembro miembro);

}
