/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.sout.teste;

/**
 *
 * @author Aluno
 */
import java.io.File;
import net.sourceforge.tess4j.*;

public class TesteOCR {

    public static void main(String[] args) {

        File imageFile = new File("C:\\Users\\Aluno\\Documents\\NetBeansProjects\\ProjetoSout\\src\\java\\br\\com\\senai\\sout\\imagem\\imagem2.jpg");
        Tesseract instance = Tesseract.getInstance();
        instance.setLanguage("por");

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
