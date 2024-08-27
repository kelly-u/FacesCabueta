package com.devlove.controllersgleice;

import com.devlove.model.daogleice.ManagerDao;
import com.devlove.model.entitiesgleice.Denuncia;
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
public class DenunciaController {
    
    private Denuncia cadastro;
    private Denuncia selection;
    
    public DenunciaController(){
        this.cadastro = new Denuncia();
    }
    
    public void resetarCamposDenuncia(){
        this.setCadastro(new Denuncia());
    }

    public String cadastrar(){
        
        ManagerDao.getCurrentInstance().insert(this.getCadastro());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Denuncia cadastrada com sucesso!"));
        
        return "DenunciasPrime";
    }
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelection());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Denúncia editada com sucesso!"));
        
        return "DenunciasPrime";
    }
    
    public List<Denuncia> listarDenuncias(){
        
        List<Denuncia> denuncias = ManagerDao.getCurrentInstance().read("select d from Denuncia a", Denuncia.class);
        return denuncias;
    }
    
    public String deletar(){
        
        ManagerDao.getCurrentInstance().delete(this.selection);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Denúncia deletada com sucesso!"));
        return "DenunciasPrime";   
    }
    
    public Denuncia getCadastro() {
        return cadastro;
    }

    public void setCadastro(Denuncia cadastro) {
        this.cadastro = cadastro;
    }

    public Denuncia getSelection() {
        return selection;
    }

    public void setSelection(Denuncia selection) {
        this.selection = selection;
    }
    
}
