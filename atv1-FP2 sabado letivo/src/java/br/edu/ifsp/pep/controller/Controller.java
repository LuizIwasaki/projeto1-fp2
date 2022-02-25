package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author biers
 */
@Named
@ViewScoped
public class Controller implements Serializable {

    private Pessoa pessoa;
    List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrar() {
        this.pessoa = new Pessoa();
        this.pessoas.add(pessoa);

    }

    public Controller() {
        this.pessoa = new Pessoa();
    }

    public void teste() {
        System.out.println("pessoa: " + this.pessoas.toString());
        for (Pessoa p : pessoas) {
            System.out.println("pessoa Lista:" + p.getNome());
        }
    }

    public void verificar() {
        System.out.println("Entrou na verficacao");
        if (this.pessoa.getNome().isEmpty() || this.pessoa.getNome() == null || 
        this.pessoa.getSenha().isEmpty() || this.pessoa.getSenha() == null) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Existem Campos não preenchidos.");
        }
        else if(this.pessoas.contains(this.pessoa))
        {
          
        addMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Login Aprovado");
    
        }
        
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showError() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Message Content");
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
