/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.model;

import java.io.Serializable;
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
    private Integer id;
    @Column
    private String caminho;
    @Column
    private String nmTabelaNome;
    @ManyToOne
    @JoinColumn(name = "ID_CONJUNTO")
    private Conjunto conjuntoOrigem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getNmTabelaNome() {
        return nmTabelaNome;
    }

    public void setNmTabelaNome(String nmTabelaNome) {
        this.nmTabelaNome = nmTabelaNome;
    }

    public Conjunto getConjuntoOrigem() {
        return conjuntoOrigem;
    }

    public void setConjuntoOrigem(Conjunto conjuntoOrigem) {
        this.conjuntoOrigem = conjuntoOrigem;
    }
    
}
