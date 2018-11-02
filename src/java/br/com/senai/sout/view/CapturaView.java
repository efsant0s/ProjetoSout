/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.view;

import br.com.senai.sout.dao.CapturaDao;
import br.com.senai.sout.model.Captura;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aluno
 */
@ManagedBean
public class CapturaView {
    private Captura captura = new Captura();
    private CapturaDao dao = new CapturaDao();
    private List<Captura>  capturas = dao.buscarTodos();

    public List<Captura> getCapturas() {
        return capturas;
    }

    public void setCapturas(List<Captura> capturas) {
        this.capturas = capturas;
    }
    

    public Captura getCaptura() {
        return captura;
    }

    public void setCaptura(Captura captura) {
        this.captura = captura;
    }

    public CapturaDao getDao() {
        return dao;
    }

    public void setDao(CapturaDao dao) {
        this.dao = dao;
    }
    
}
