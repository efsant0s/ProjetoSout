/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.teste;

import br.com.senai.sout.dao.UsuarioDao;
import br.com.senai.sout.model.Usuario;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class UsuarioTeste {

    public static void main(String[] args) {
        testeCadastraUsuario();
    }

    private static void testeCadastraUsuario() {
        Usuario edu = fazUsuarioPadraoSimples();
        UsuarioDao dao = new UsuarioDao();
        dao.salvar(edu);
        List<Usuario> listaUsuario = dao.buscarTodos();
        System.out.println(listaUsuario.size());
        for (int i = 0; i < listaUsuario.size(); i++) {
            System.out.println(listaUsuario.get(i).getNome());
        }
    }

    private static Usuario fazUsuarioPadraoSimples() {
        Usuario user = new Usuario();
        user.setLogin("LoginTeste");
        user.setSenha("senhaUsuario");
        user.setNome("Eduardo Felipe dos Santos");
        user.setRespostaSeguranca("Resposta de segurança");
        user.setTelefone("30374054");
        return user;
    }
}
