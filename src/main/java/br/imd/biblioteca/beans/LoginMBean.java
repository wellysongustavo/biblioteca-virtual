package br.imd.biblioteca.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.imd.biblioteca.dao.UsuarioDAO;
import br.imd.biblioteca.dominio.Usuario;


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
	
	public void envia() {

		System.out.println(usuario.getLogin());

	}
	
}