package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.Cadeira;
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
public class CadeiraController {
    
    private Cadeira cadastro;
    private Cadeira selection;
    
    public CadeiraController(){
        this.cadastro = new Cadeira();
    }
    
    public void resetarCamposCadastro(){
        this.setCadastro(new Cadeira());
    }
    
    public String cadastrar(){
        
        ManagerDao.getCurrentInstance().insert(this.getCadastro());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadeira cadastrada com sucesso!"));
        
        return "CadeirasPrime";
    }
    
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelection());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadeira editada com sucesso!"));
        
        return "CadeirasPrime";
    }

    
    public List<Cadeira> listarCadeiras(){
        
        List<Cadeira> cadeiras = ManagerDao.getCurrentInstance().read("select c from Cadeira c", Cadeira.class);
        return cadeiras;
    }
    
    
    public String deletar(){
        
        ManagerDao.getCurrentInstance().delete(this.selection);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadeira deletada com sucesso!"));
        return "CadeirasPrime";
    }
    
    
    public Cadeira getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadeira cadastro) {
        this.cadastro = cadastro;
    }
    
    public Cadeira getSelection() {
        return selection;
    }

    public void setSelection(Cadeira selection) {
        this.selection = selection;
    }
    
}
