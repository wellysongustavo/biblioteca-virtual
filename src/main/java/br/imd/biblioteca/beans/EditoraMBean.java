package br.imd.biblioteca.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.imd.biblioteca.dao.EditoraDAO;
import br.imd.biblioteca.dominio.Editora;
import br.imd.biblioteca.util.BibliotecaException;

@ManagedBean
@ViewScoped
public class EditoraMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	private Editora editora = new Editora();
	private EditoraDAO editoraDAO = new EditoraDAO();
	private Integer editoraId;
	private String editoraNome;
	

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Integer getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Integer editoraId) {
		this.editoraId = editoraId;
	}

	public String getEditoraNome() {
		return editoraNome;
	}

	public void setEditoraNome(String  editoraNome) {
		this.editoraNome = editoraNome;
	}
	
	//Ações
	
	public void apagar(Editora editora) throws BibliotecaException {
		editoraDAO.excluir(editora);
	}
	
	public List<Editora> getLista() throws BibliotecaException{
		return editoraDAO.listar();
	}
	
	public void editar(Editora editora) {
		this.editora = editora;
		this.editoraId = editora.getId();
	}
	
	public void gravar() throws BibliotecaException {
		if(this.editora.getId() == null) {
			editoraDAO.salvar(this.editora);
		} else {
			editoraDAO.atualizar(editora);
		}
		this.editora = new Editora();
	}
	
	public void atualizarEditora(AjaxBehaviorEvent e) throws BibliotecaException {
		this.editora = editoraDAO.buscarId(editoraId);
		this.editoraNome = this.editora.getNome();
	}
	
	

}

