package br.imd.biblioteca.util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "GrowlView")
@RequestScoped
public class GrowlView {

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showCadastroEditora() {
        addMessage(FacesMessage.SEVERITY_INFO, "Info", "Editora cadastrada com sucesso!");
    }

    public void showRemocaoEditora() {
        addMessage(FacesMessage.SEVERITY_WARN, "Info", "Editora removida com sucesso!");
    }

    public void showErrorCadastroEditora() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Já existe uma editora cadastrada com esse nome!");
    }

    public void showSticky() {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sticky Message", "Message Content"));
    }

    public void showMultiple() {
        addMessage(FacesMessage.SEVERITY_INFO, "Message 1", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 2", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 3", "Message Content");
    }
}
