package es.toni.setup.makeup.models.services;

import java.util.List;

import es.toni.setup.makeup.models.entity.Miembro;

public interface IMiembroService {
	
    public List<Miembro> findAll();

    public Miembro findById(int miembroId);

    public void save(Miembro miembro);

    public void delete(Miembro miembro);
}
