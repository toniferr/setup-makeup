package es.toni.setup.makeup.models.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import es.toni.setup.makeup.models.entity.Categoria;
import es.toni.setup.makeup.models.entity.Usuario;

@Repository
public class CategoriaDao implements ICategoriaDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>) hibernateTemplate.find("from Categoria");
	}
	
	@Override
	public List<Categoria> findCategoriaPrimariasByUser(Usuario usuario) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Categoria.class).add(Restrictions.eq("usuario", usuario)).add(Restrictions.isNull("categoriaPadre"));
		return (List<Categoria>)this.hibernateTemplate.findByCriteria(detachedCriteria);
	}

	@Override
	public Categoria findById(Integer id) {
		return (Categoria) hibernateTemplate.get(Categoria.class, id);
	}

	@Override
	public void save(Categoria categoria) {
		hibernateTemplate.saveOrUpdate(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		hibernateTemplate.delete(categoria);
	}

}
