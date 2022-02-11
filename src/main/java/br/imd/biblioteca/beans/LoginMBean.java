package br.imd.biblioteca.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.imd.biblioteca.dao.UsuarioDAO;
import br.imd.biblioteca.dominio.Usuario;
import br.imd.biblioteca.util.BibliotecaException;


@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
  
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public void validaLogin() throws BibliotecaException, IOException {

	    for (Usuario user : usuarioDAO.listar()) {
	        if (user.getLogin().equals(usuario.getLogin())) {
	            if (user.getSenha().equals(usuario.getSenha())) {
	            	FacesContext.getCurrentInstance().getExternalContext().redirect("pagina-inicial.xhtml");
	           }
	        }
	    }
	    
	    FacesContext.getCurrentInstance().addMessage(":gerencia:msgLoginInvalido", new FacesMessage(FacesMessage.SEVERITY_INFO,"Credenciais inválidas.", "PrimeFaces rocks!"));  
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
}