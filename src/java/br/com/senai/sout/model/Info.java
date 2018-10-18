/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Aluno
 */
@Entity(name = "tb_info")
public class Info implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nmTabelaNome;
    @Column
    private String dsComandoSQL;
    @Column
    private String ieTipoBanco;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmTabelaNome() {
        return nmTabelaNome;
    }

    public void setNmTabelaNome(String nmTabelaNome) {
        this.nmTabelaNome = nmTabelaNome;
    }

    public String getDsComandoSQL() {
        return dsComandoSQL;
    }

    public void setDsComandoSQL(String dsComandoSQL) {
        this.dsComandoSQL = dsComandoSQL;
    }

    public String getIeTipoBanco() {
        return ieTipoBanco;
    }

    public void setIeTipoBanco(String ieTipoBanco) {
        this.ieTipoBanco = ieTipoBanco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.nmTabelaNome);
        hash = 83 * hash + Objects.hashCode(this.dsComandoSQL);
        hash = 83 * hash + Objects.hashCode(this.ieTipoBanco);
        hash = 83 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Info other = (Info) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nmTabelaNome, other.nmTabelaNome)) {
            return false;
        }
        if (!Objects.equals(this.dsComandoSQL, other.dsComandoSQL)) {
            return false;
        }
        if (!Objects.equals(this.ieTipoBanco, other.ieTipoBanco)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

}
