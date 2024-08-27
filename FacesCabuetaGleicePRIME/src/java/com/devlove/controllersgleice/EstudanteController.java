package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.Estudante;
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
public class EstudanteController {
    
    private Estudante cadastro;
    private Estudante selection;

    public EstudanteController(){
        this.cadastro = new Estudante();
    }
    
    
    public void resetarCamposCadastro(){
        this.setCadastro(new Estudante());
    }
    
    
    public String cadastrar(){
        
        ManagerDao.getCurrentInstance().insert(this.getCadastro());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudante cadastrado(a) com sucesso!"));
        
        return "EstudantesPrime";
    }
    
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelection());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudante editado(a) com sucesso!"));
        
        return "EstudantesPrime";
    }
    
    
    public List<Estudante> listarEstudantes(){
        
        List<Estudante> estudantes = ManagerDao.getCurrentInstance().read("select e from Estudante e", Estudante.class);
        return estudantes;
    }
    
    
    public String deletar(){
        
        ManagerDao.getCurrentInstance().delete(this.selection);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudante deletado(a) com sucesso!"));
        return "EstudantesPrime";
    }
    
    
    public Estudante getCadastro() {
        return cadastro;
    }

    public void setCadastro(Estudante cadastro) {
        this.cadastro = cadastro;
    }

    public Estudante getSelection() {
        return selection;
    }

    public void setSelection(Estudante selection) {
        this.selection = selection;
    }
    
}
