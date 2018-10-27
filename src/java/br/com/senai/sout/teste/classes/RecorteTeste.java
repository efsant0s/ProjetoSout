/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.teste.classes;

import br.com.senai.sout.dao.CapturaDao;
import br.com.senai.sout.dao.RecorteDao;
import br.com.senai.sout.dao.ConjuntoDao;
import br.com.senai.sout.dao.UsuarioDao;
import br.com.senai.sout.model.Captura;
import br.com.senai.sout.model.Recorte;
import br.com.senai.sout.model.Conjunto;
import br.com.senai.sout.model.Usuario;

/**
 *
 * @author Aluno
 */
public class RecorteTeste {

    public static void main(String[] args) {
         cadastraRecortePadrao();
         editaRecortePadrao();
        //excluiRecortePadrao();
    }

    private static Conjunto fazConjuntoPadraoSimples() {
        Conjunto conj = new Conjunto();
        conj.setIeTipoBanco("SQL");
        conj.setNmTabelaNome("BANCO");
        conj.setIeTipoConjunto("EXP");
        conj.setUsuario(getUsuarioAleatorio());
        return conj;
    }

    private static void cadastraConjuntoPadrao() {
        Conjunto conj = fazConjuntoPadraoSimples();
        ConjuntoDao conDao = new ConjuntoDao();
        conDao.salvar(conj);
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

    private static Usuario getUsuarioAleatorio() {
        UsuarioDao dao = new UsuarioDao();
        if (dao.getQuantidadeRegistros() == 0) {
            dao.salvar(fazUsuarioPadraoSimples());
        }
        return dao.buscarTodos().get(0);
    }

    private static Recorte fazRecortePadraoSimples() {
        Recorte rec = new Recorte();
        rec.setDsComandoSQL("SELECT TESTE INTO TESTE;");

        if (new CapturaDao().getQuantidadeRegistros() == 0) {
            cadastraCapturaPadrao();
        }
        rec.setCapturaTela(new CapturaDao().buscarTodos().get(0));
        return rec;
    }

    private static void cadastraRecortePadrao() {
        Recorte rec = fazRecortePadraoSimples();
        RecorteDao conDao = new RecorteDao();
        conDao.salvar(rec);
    }

    private static void editaRecortePadrao() {
        RecorteDao dao = new RecorteDao();
        if (dao.getQuantidadeRegistros() == 0) {
            cadastraRecortePadrao();
        }
        Recorte rec = dao.buscarTodos().get(0);
        rec.setDsComandoSQL("ComandoSQLEditado");
        dao.salvar(rec);

    }

    private static void excluiRecortePadrao() {
        RecorteDao dao = new RecorteDao();
        if (dao.getQuantidadeRegistros() == 0) {
            cadastraRecortePadrao();
        }
        Recorte rec = dao.buscarTodos().get(0);
        dao.exclui(rec);
    }

    private static Captura fazCapturaPadraoSimples() {
        Captura capt = new Captura();
        capt.setCaminho("C://Temp");

        if (new ConjuntoDao().getQuantidadeRegistros() == 0) {
            cadastraConjuntoPadrao();
        }
        capt.setConjuntoOrigem(new ConjuntoDao().buscarTodos().get(0));
        return capt;
    }

    private static void cadastraCapturaPadrao() {
        Captura capt = fazCapturaPadraoSimples();
        CapturaDao conDao = new CapturaDao();
        conDao.salvar(capt);
    }

}
