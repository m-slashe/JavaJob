/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.controle;

import br.edu.ifsp.similaridade.Pasta;
import br.edu.ifsp.similaridade.parametro.Parametro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Controle {
    
    

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception  {        
        Parametro p = new Parametro("tests\\entry.txt");
        p.lerParametro();
        List<Pasta> pastas = p.getPastas();
        for(Pasta pasta: pastas){
            pasta.obterArquivos();
            for(Arquivo arquivo: pasta.getFiles()){
                System.out.println(arquivo.caminho);
                arquivo.getConteudo();
            }
        }
    }    
}
