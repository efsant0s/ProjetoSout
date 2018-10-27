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

    public static void main(String[] args) throws Exception {
        
        testeEditaUsuario();

        
      
        //testeCadastraListarTodosUsuarios();
        //limpaUsuarios();
    }

    private static void testeCadastraUsuario() {
        Usuario edu = fazUsuarioPadraoSimples();
        UsuarioDao dao = new UsuarioDao();
        dao.salvar(edu);
    }

    private static Usuario fazUsuarioPadraoSimples() {
        Usuario user = new Usuario();
        user.setLogin("LoginTeste");
        user.setSenha("senhaUsuario");
        user.setNome("Eduardo Felipe dos Santos");
        user.setRespostaSeguranca("Resposta de segurança");
        user.setTelefone("30374054");
        user.setIeAdmin("S");
        return user;
    }

    private static void testeCadastraListarTodosUsuarios() {
        List<Usuario> listaUsuario = new UsuarioDao().buscarTodos();
        System.out.println("-----------------Teste de cadastro listagem de usuário-----------------");
        System.out.println("Qtd de usuário em base: " + listaUsuario.size());
        for (int i = 0; i < listaUsuario.size(); i++) {
            System.out.println("ID : " + listaUsuario.get(i).getId() + " -- Nome: " + listaUsuario.get(i).getNome());
        }
        System.out.println("---------------Fim teste de cadastro listagem de usuário---------------");
    }

    private static void limpaUsuarios() {
        System.out.println("-----------------Teste de limpeza de base-----------------");
        UsuarioDao dao = new UsuarioDao();
        for (Usuario usuario : dao.buscarTodos()) {
            dao.excluir(usuario);
            System.out.println("Excluido " + usuario.getNome());
            System.out.println("Qtd de usuário em base: " + dao.getQuantidadeRegistros());
        }

        System.out.println("---------------Fim teste de limpeza de base---------------");
    }

    private static void testeEditaUsuario() throws Exception {
        UsuarioDao userDao = new UsuarioDao();
        if(userDao.getQuantidadeRegistros() == 0L){
             testeCadastraUsuario();
        }
        List<Usuario> lista = userDao.buscarTodos();
        Usuario usuarioEditar = lista.get(0);
        if(usuarioEditar.getId() == 0){
            throw new Exception("Era pra ter um id");
        }
        System.out.println("-----------------Teste de edição de usuário-----------------");
        usuarioEditar.setNome("Jonathan Vieira");
        userDao.salvar(usuarioEditar);
        System.out.println("---------------Fim Teste de edição de usuário---------------");
    }
}
