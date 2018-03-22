/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.controle;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author aluno
 */
public class ArquivoPDF extends Arquivo {
    
    public ArquivoPDF(String caminho, String extensao){
        super(caminho, extensao);
    }
    
    @Override
    public void getConteudo() throws Exception {
        PDDocument document = PDDocument.load(new File(caminho));
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            text = text.replace(" – ", "");
            text = text.replace("-\r\n", "");
            text = text.replace("\r\n", " ");
            text = text.replace(".", "");
            text = text.replace(",", "").toLowerCase();
            String[] palavras2 = text.split(" ");
            for(String p: palavras2){
                if(palavras.containsKey(p)){
                    Integer quantidade = palavras.get(p);
                    quantidade++;
                    palavras.put(p, quantidade);
                }else
                    palavras.put(p, 1);
            }
        }
        document.close();
        #teste git
    }
    
}
