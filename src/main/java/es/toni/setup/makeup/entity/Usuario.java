package es.toni.setup.makeup.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Usuario implements Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;

	private String password;

	private Boolean enabled;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<Role> roles;
	
    @OneToMany(mappedBy="usuario")
    private Set<Categoria> categorias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}


	private static final long serialVersionUID = 1L;
}
