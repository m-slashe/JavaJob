/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.similaridade.parametro;

import br.edu.ifsp.similaridade.Pasta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Parametro {
    
    String caminho;
    List<Pasta> pastas;
    
    public Parametro(String caminho){
        this.caminho = caminho;
        this.pastas = new ArrayList<Pasta>();
    }

    public void lerParametro() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.caminho));
        try {            
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                System.out.println(line);
                Integer lastDotComma = line.lastIndexOf(";");
                String caminho = line.substring(0, lastDotComma);
                String extensoesString = line.substring(lastDotComma+1);
                String[] extensoes = extensoesString.split(",");
                pastas.add(new Pasta(caminho, extensoes));
                line = br.readLine();
            }
            String everything = sb.toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            br.close();
        }    
    }
    
    public List<Pasta> getPastas(){
        return this.pastas;
    }
}
