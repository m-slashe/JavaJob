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
    
    public String fixBrokenWords(String text){
        return text;
    }
    
    public void parseWords(String text){
        text = text.replace("–\r\n", "");
        text = text.replace("\r\n", " ");
        text = text.replace(",", "");
        text = text.replace(".", "");
        text = fixBrokenWords(text);
        String[] palavras2 = text.split(" ");
        for(String p: palavras2){
            p = p.toLowerCase();
            if(palavras.containsKey(p)){
                Integer quantidade = palavras.get(p);
                quantidade++;
                palavras.put(p, quantidade);
            }else{
                if(Controle.global.containsKey(p)){
                    Integer quantidade = Controle.global.get(p);
                    quantidade++;
                    Controle.global.put(p, quantidade);
                }else
                    Controle.global.put(p, 1);
                palavras.put(p, 1);
            }                
        }
    }    
}
