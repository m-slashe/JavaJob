/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.similaridade;

import br.edu.ifsp.controle.Arquivo;
import br.edu.ifsp.controle.ArquivoDOC;
import br.edu.ifsp.controle.ArquivoPDF;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author aluno
 */
public class Pasta {
    
    String caminho;
    String[] extensoes;
    List<Arquivo> arquivos;

    public Pasta(String caminho, String[] extensoes) {
        this.caminho = caminho;
        this.extensoes = extensoes;
    }
    
    public void obterArquivos() throws IOException{
        arquivos = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(this.caminho))) {
            paths
                //.filter(Files::isRegularFile).filter(f -> f.toString().matches(""))
                .forEach(new Consumer<Path>() {
                    public void accept(Path file) {

                        for(String extensao : extensoes){
                            if(file.getFileName().toString().contains(extensao)){
                                System.out.println(file.toString());  
                                Arquivo arquivo = null;
                                if(extensao.equals("pdf"))
                                    arquivo = Arquivo.build(file.toString(), extensao);
                                if(extensao.equals("doc"))
                                    arquivo = new ArquivoDOC(file.toString(), extensao);
                                arquivos.add(arquivo);
                            }
                        }                       
                    }
                });
        } 
    }
    
    public List<Arquivo> getFiles(){
        return this.arquivos;
    }    
}


