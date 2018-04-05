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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author aluno
 */
public class Controle {
    
    static Map<String, Integer> global = new HashMap();
     
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
        Integer totalArquivos = 0;
        for(Pasta pasta: pastas)
            totalArquivos += pasta.getFiles().size();
        
        for(Pasta pasta: pastas){
            for(Arquivo arquivo: pasta.getFiles()){
                for(Map.Entry<String, Integer> palavraEntry : arquivo.palavras.entrySet()) {
                    String palavra = palavraEntry.getKey();
                    Integer quantidade = palavraEntry.getValue();
                    Integer quantidadeEmArquivos = global.get(palavra);
                    Integer tfidf = (totalArquivos / quantidade) * quantidadeEmArquivos;
                }
            }
        }
        
        
    }    
}

/**
 * (Numero de arquivos / numeroDeArquivosQueAparece) * xQueApalavraRepete)
 * 
 */
