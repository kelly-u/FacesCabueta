package com.devlove.model.entitiesgleice;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Gleice
 */

@Entity
public class Denuncia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    @Temporal(TemporalType.DATE)
    private Date data;
    private String turno;
    @Lob
    private String DescricaoDoOcorrido;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricaoDoOcorrido() {
        return DescricaoDoOcorrido;
    }

    public void setDescricaoDoOcorrido(String DescricaoDoOcorrido) {
        this.DescricaoDoOcorrido = DescricaoDoOcorrido;
    }
    
}
