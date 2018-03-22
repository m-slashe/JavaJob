/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.controle;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aluno
 */
public abstract class Arquivo {

    public static Arquivo build(String path, String extensao) {
        if(extensao.equals("pdf"))
            return new ArquivoPDF(path, extensao);
        else if(extensao.equals("doc"))
            return new ArquivoDOC(path, extensao);
        else
            return null;
    }
    
    String caminho;
    String extensao;
    Map<String, Integer> palavras = new HashMap();

    public Arquivo(String caminho, String extensao) {
        this.caminho = caminho;
        this.extensao = extensao;
    }

    public String getExtension() {
        return this.extensao;
    }
    
    public abstract void getConteudo() throws Exception;
    
}
