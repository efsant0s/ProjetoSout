/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.view;

import br.com.senai.sout.dao.CapturaDao;
import br.com.senai.sout.dao.ConjuntoDao;
import br.com.senai.sout.imagem.UploadImage;
import br.com.senai.sout.model.Captura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

/**
 *
 * @author Aluno
 */
@ManagedBean
public class CapturaView {

    private Captura captura = new Captura();
    private CapturaDao dao = new CapturaDao();
    private List<Captura> capturas = dao.buscarTodos();

    public void atualizaLista(int idConjunto) {
        this.capturas = dao.buscarTodosByConjunto(idConjunto);
    }

    public  List<Captura> getCapturasByIdConjunto(int id) {
        return dao.buscarTodosByConjunto(id);
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

    public void deletaCaptura(Captura captura) {
        dao.exclui(captura);
    }

    void salvaCaptura(int id, Part image) {
        UploadImage upload = new UploadImage(image);
        try {
            String caminho = upload.doUpload();
            captura.setCaminho(caminho);
            captura.setConjuntoOrigem(new ConjuntoDao().getbyId(id));
            dao.salvar(captura);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        atualizaLista(id);

    }

}
