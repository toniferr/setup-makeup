package es.toni.setup.makeup.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	
    /**
     * Default value included to remove warning. Remove or modify at will. *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nombre;
    
    @OneToMany(mappedBy="categoriaPadre")
    private Set<Categoria> subcategorias;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Categoria categoriaPadre;
    
    @OneToMany(mappedBy="categoria")
    private Set<Miembro> miembros;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(Set<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}

	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}

	public Set<Miembro> getMiembros() {
		return miembros;
	}

	public void setMiembros(Set<Miembro> miembros) {
		this.miembros = miembros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
