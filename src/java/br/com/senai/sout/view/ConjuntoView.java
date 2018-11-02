/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.view;

import br.com.senai.sout.dao.ConjuntoDao;
import br.com.senai.sout.model.Conjunto;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aluno
 */
@ManagedBean
public class ConjuntoView {
    private ConjuntoDao dao = new ConjuntoDao();
    private Conjunto conjunto = new Conjunto();

    public ConjuntoDao getDao() {
        return dao;
    }

    public void setDao(ConjuntoDao dao) {
        this.dao = dao;
    }

    public Conjunto getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
    }
    
}
