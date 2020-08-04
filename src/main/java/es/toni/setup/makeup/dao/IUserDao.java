/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.toni.setup.makeup.dao;

import java.util.List;

import es.toni.setup.makeup.entity.Usuario;

/**
 *
 * @author toni
 */
public interface IUserDao {

	public Usuario findByUsername(String username);
	
	public List<Usuario> findAll();

    public Usuario findById(Integer id);

    public void save(Usuario user);

    public void delete(Usuario user);
}
