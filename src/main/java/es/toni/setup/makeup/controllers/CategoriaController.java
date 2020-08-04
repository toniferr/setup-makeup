package es.toni.setup.makeup.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import es.toni.setup.makeup.entity.Categoria;
import es.toni.setup.makeup.entity.Usuario;
import es.toni.setup.makeup.services.ICategoriaService;
import es.toni.setup.makeup.services.IUserService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
    private ICategoriaService categoriaService;
	
	@Autowired
    private IUserService userService;
	
    @GetMapping(value = "/inicio")
    public String inicio(Model modelo) throws Exception {
        modelo.addAttribute("titulo", "Aplicación MAKEUP");
		return "inicio";
    }

    @RequestMapping(value = "/listado.htm", method = RequestMethod.GET)
    @ModelAttribute("categorias")
    @Secured("ROLE_ADMIN")
    public List<Categoria> listado(@RequestParam(value = "categoriaId", required = false, defaultValue = "0") Long idCategoriaPadre,
    		Model modelo) {
    	
    	modelo.addAttribute("titulo", "Listado de categorias");
    	modelo.addAttribute("categoriaId", idCategoriaPadre);

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		Usuario usuario = userService.findByUsername(username);
		
		if (idCategoriaPadre > 0) {
			return categoriaService.findCategoriaSegundariasByUser(usuario, idCategoriaPadre);
		} else {
			return categoriaService.findCategoriaPrimariasByUser(usuario);
		}
    }


    @RequestMapping(value = "/form.htm", method = RequestMethod.GET)
    @ModelAttribute("categoria")
    @Secured("ROLE_ADMIN")
    public Categoria setupForm(@RequestParam(value = "categoriaId", required = false, defaultValue = "0") Long idCategoriaPadre, 
    		@RequestParam(value = "id", required = false, defaultValue = "0") Long id) {
    	Categoria categoria = null;
        if (id > 0) {
        	categoria = categoriaService.findById(id);
        } else {
        	categoria = new Categoria();
        	if (idCategoriaPadre > 0) {
        		Categoria categoriaPadre = categoriaService.findById(idCategoriaPadre);
        		categoria.setCategoriaPadre(categoriaPadre);
        	}
        }
        return categoria;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/form.htm", method = RequestMethod.POST)
    public String processSubmit(@Valid Categoria categoria,
            BindingResult result, SessionStatus status) {

        if (result.hasErrors()) {
            return "categoria/form";
        } else {
        	categoriaService.save(categoria);
            status.setComplete();
            return "redirect:listado.htm";
        }
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/eliminar.htm", method = RequestMethod.GET)
    public String eliminar(@RequestParam("id") Long id) {
    	Categoria categoria = categoriaService.findById(id);

        if (null != categoria) {
        	categoriaService.delete(categoria);
        }

        return "redirect:listado.htm";
    }

    @ModelAttribute("titulo")
    public String populateTitulo() {
        return "Formulario categoria";
    }
    
}
