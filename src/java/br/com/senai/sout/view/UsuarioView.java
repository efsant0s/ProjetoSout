/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.view;

import br.com.senai.sout.dao.UsuarioDao;
import br.com.senai.sout.model.Usuario;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class UsuarioView {
    
    private UsuarioDao usuarioDao = new UsuarioDao();
    private List<Usuario> listaUsuarios = usuarioDao.buscarTodos();
    private Usuario usuario = new Usuario();

    public void fazUsuarioDefault() {
        boolean semAdmin = true;
        for (Usuario listaUsuario : listaUsuarios) {
            if (listaUsuario.getLogin() != null && listaUsuario.getLogin().equals("admin")) {
                if (listaUsuario.getSenha() != null && listaUsuario.getSenha().equals("admin")) {
                    semAdmin = false;
                }
            }

        }
        if (semAdmin) {
            usuarioDao.salvar((new Usuario("usuarioPadrao", "admin", "admin")));
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

            if (listaUsuario.getLogin() != null && listaUsuario.getLogin().equals("admin")) {
                if (listaUsuario.getSenha() != null && listaUsuario.getSenha().equals("admin")) {
                    return "paginaInicial";
                }
            }
        }
        return "loginInvalido";
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
