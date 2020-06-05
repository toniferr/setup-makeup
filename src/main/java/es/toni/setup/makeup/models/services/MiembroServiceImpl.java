package es.toni.setup.makeup.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.toni.setup.makeup.models.dao.IMiembroDao;
import es.toni.setup.makeup.models.entity.Miembro;

@Service
public class MiembroServiceImpl implements IMiembroService {

	@Autowired
	private IMiembroDao miembroDao;

	@Override
	public List<Miembro> findAll() {
		return miembroDao.findAll();
	}

	@Override
	public Miembro findById(int id) {
		return miembroDao.findById(id);
	}

	@Override
	public void save(Miembro miembro) {
		miembroDao.save(miembro);
	}

	@Override
	public void delete(Miembro miembro) {
		miembroDao.delete(miembro);
	}
	
}
