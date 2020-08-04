package es.toni.setup.makeup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.toni.setup.makeup.entity.Miembro;

@Repository
public class MiembroDao implements IMiembroDao{

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Miembro> findAll() {
		return (List<Miembro>) hibernateTemplate.find("from Miembro");
	}

	@Override
	public Miembro findById(Integer id) {
		return (Miembro) hibernateTemplate.get(Miembro.class, id);
	}

	@Override
	public void save(Miembro miembro) {
		hibernateTemplate.saveOrUpdate(miembro);
	}

	@Override
	public void delete(Miembro miembro) {
		hibernateTemplate.delete(miembro);
	}

}
