package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.Professor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author Gleice
 */

@ManagedBean
@SessionScoped
public class ProfessorController {
    
    private Professor cadastro;
    private Professor selection;

    public ProfessorController(){
        this.cadastro = new Professor();
    }
    
    public void resetarCamposCadastro(){
        this.setCadastro(new Professor());
    }
    
    public String cadastrar(){
        
        ManagerDao.getCurrentInstance().insert(this.getCadastro());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor(a) cadastrado(a) com sucesso!"));
        
        return "ProfessorPrime";
    }
    
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelection());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor(a) editado(a) com sucesso!"));
        
        return "ProfessorPrime";
    }

    
    public List<Professor> listarProfessores(){
        
        List<Professor> professores = ManagerDao.getCurrentInstance().read("select p from Professor p", Professor.class);
        return professores;
    }
    
    
    public String deletar(){
        
        ManagerDao.getCurrentInstance().delete(this.selection);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor(a) deletado(a) com sucesso!"));
        return "ProfessorPrime";
    }
    
    
    public Professor getCadastro() {
        return cadastro;
    }

    public void setCadastro(Professor cadastro) {
        this.cadastro = cadastro;
    }

    public Professor getSelection() {
        return selection;
    }

    public void setSelection(Professor selection) {
        this.selection = selection;
    }
    
}
