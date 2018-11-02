/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.view;

import br.com.senai.sout.dao.ConjuntoDao;
import br.com.senai.sout.model.Captura;
import br.com.senai.sout.model.Conjunto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

/**
 *
 * @author Aluno
 */
@ManagedBean
public class ConjuntoView {

    private Part image;
    private static CapturaView captView = new CapturaView();
    private static ConjuntoDao conjdao = new ConjuntoDao();
    private static Conjunto conjunto = new Conjunto();
    private static List<Captura> listaImagens = captView.getCapturasByIdConjunto(conjunto.getId());

    public List<Captura> getListaImagens() {
        return listaImagens;
    }

    

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public CapturaView getCaptView() {
        return captView;
    }

    public void setCaptView(CapturaView captView) {
        this.captView = captView;
    }

    public ConjuntoDao getConjdao() {
        return conjdao;
    }

    public Conjunto getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
    }

    public void insereImagem() {
        if (conjunto.getId() == 0) {
            if (conjunto.getIeTipoConjunto() == null) {
                conjunto.setIeTipoConjunto("N");
            }
            conjdao.salvar(conjunto);
        }
        captView.salvaCaptura(conjunto.getId(), image);
    }

    

}
