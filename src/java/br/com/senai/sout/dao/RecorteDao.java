/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.dao;

import br.com.senai.sout.model.Recorte;
import java.util.List;

/**
 *
 * @author Leonardo.Lima
 */
public class RecorteDao {
    public void salvar(Recorte i) {
        if (i.getId() == 0) {
            Repository.inserir(i);
        } else {
          Repository.alterar(i);
        }
        
        Repository.commitar();
    }
    
    public void exclui(Recorte i){
        Repository.excluir(i);
        Repository.commitar();
    }
    
    public List<Recorte> buscarTodos(){
        return Repository.getEm().createQuery("SELECT U FROM Recorte U").getResultList();
    }
    
    public Recorte getbyId(Integer id){
        return Repository.getEm().find(Recorte.class, id);
    }
    public Long getQuantidadeRegistros(){
        return (Long) Repository.getEm().
                createQuery("select count(u) qtd_registros from Recorte u")
                .getSingleResult();
    }
}
