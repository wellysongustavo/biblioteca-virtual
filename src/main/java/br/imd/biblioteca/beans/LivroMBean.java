package br.imd.biblioteca.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.imd.biblioteca.dao.LivroDAO;
import br.imd.biblioteca.dominio.Editora;
import br.imd.biblioteca.dominio.Livro;
import br.imd.biblioteca.util.BibliotecaException;

@ManagedBean
@ViewScoped
public class LivroMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	private Livro livro = new Livro();
	private Integer livroId;
	private String livroTitulo;
	private String livroAutor;
	private boolean livroStatus;
	private Editora livroEditora;
	
	private LivroDAO livroDAO = new LivroDAO();

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public String getLivroTitulo() {
		return livroTitulo;
	}

	public void setLivroTitulo(String livroTitulo) {
		this.livroTitulo = livroTitulo;
	}
	
	public String getLivroAutor() {
		return livroAutor;
	}

	public void setLivroAutor(String livroAutor) {
		this.livroAutor = livroAutor;
	}

	public boolean isLivroStatus() {
		return livroStatus;
	}

	public void setLivroStatus(boolean livroStatus) {
		this.livroStatus = livroStatus;
	}
	
	public Editora getLivroEditora() {
		return livroEditora;
	}

	public void setLivroEditora(Editora livroEditora) {
		this.livroEditora = livroEditora;
	}
	
	
	//Ações
	
	public void apagar(Livro livro) throws BibliotecaException {
		livroDAO.excluir(livro);
	}
	
	public void editar(Livro livro) {
		this.livro = livro;
		this.livroId = livro.getId();
	}
	
	public void gravar() throws BibliotecaException {
		if(this.livro.getId() == null) {
			livroDAO.salvar(this.livro);
		} else {
			livroDAO.atualizar(livro);
		}
		this.livro = new Livro();
	}
	
	public void atualizarLivro(AjaxBehaviorEvent e) throws BibliotecaException {
		this.livro = livroDAO.buscarId(livroId);
		this.livroTitulo = this.livro.getTitulo();
	}
	

}