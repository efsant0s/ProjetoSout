/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.view;

import br.com.senai.sout.dao.UsuarioDao;
import br.com.senai.sout.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aluno
 */
@ManagedBean
public class UsuarioView {
    
    private UsuarioDao usuarioDao = new UsuarioDao();
    private List<Usuario> listaUsuarios = usuarioDao.buscarTodos();
    private Usuario usuario = new Usuario();

    public void fazUsuarioDefault() {
         if(!usuarioDao.isPossuiUsuarioAdmin()){
             usuarioDao.salvar(new Usuario("nomePadrao", "login", "senhaPadrao", "S"));
         }
        

    }

    public UsuarioView() {

    }
    private void atualizaLista(){
        listaUsuarios = usuarioDao.buscarTodos();
    }
    public String loginUsuario() {
        fazUsuarioDefault();
        atualizaLista();
        for (Usuario listaUsuario : listaUsuarios) {
            if (listaUsuario.getLogin() != null && listaUsuario.getLogin().equals(usuario.getLogin())) {
                if (listaUsuario.getSenha() != null && listaUsuario.getSenha().equals(usuario.getSenha())) {
                    return "paginaInicial";
                }
            }
        }
        return "PaginaErro";
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
