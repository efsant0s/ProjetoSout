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
@Entity(name = "Captura")
public class Captura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String caminho;
    @ManyToOne
    @JoinColumn(name = "ID_CONJUNTO")
    private Conjunto conjuntoOrigem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Conjunto getConjuntoOrigem() {
        return conjuntoOrigem;
    }

    public void setConjuntoOrigem(Conjunto conjuntoOrigem) {
        this.conjuntoOrigem = conjuntoOrigem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.caminho);
        hash = 83 * hash + Objects.hashCode(this.conjuntoOrigem);
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
        final Captura other = (Captura) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.caminho, other.caminho)) {
            return false;
        }
        if (!Objects.equals(this.conjuntoOrigem, other.conjuntoOrigem)) {
            return false;
        }
        return true;
    }

}
