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
            parseWords(text);
        }
        document.close();
    }
    
}
