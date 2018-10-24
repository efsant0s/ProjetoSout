/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.dao;

import br.com.senai.sout.model.Imagem;
import br.com.senai.sout.model.Usuario;
import java.util.List;

/**
 *
 * @author Leonardo.Lima
 */
public class ImagemDAO {
    public void save(Imagem i) {
        if (i.getId() == 0) {
            Repository.inserir(i);
        } else {
          Repository.alterar(i);
        }
        
        Repository.commitar();
    }
    
    public void delete(Imagem i){
        Repository.excluir(i);
    }
    
    public List<Imagem> getAll(){
        return Repository.getEm().createQuery("SELECT * FROM TB_IMAGEM").getResultList();
    }
    
    public Imagem getbyId(Integer id){
        return Repository.getEm().find(Imagem.class, id);
    }
    
}
