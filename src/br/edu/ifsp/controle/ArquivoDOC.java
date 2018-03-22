/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.controle;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author aluno
 */
public class ArquivoDOC extends Arquivo {

    public ArquivoDOC(String caminho, String extensao) {
        super(caminho, extensao);
    }

    @Override
    public void getConteudo() throws Exception {
        WordExtractor extractor = null;

        File file = new File(this.caminho);
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        HWPFDocument document = new HWPFDocument(fis);
        extractor = new WordExtractor(document);
        String[] fileData = extractor.getParagraphText();
        for (int i = 0; i < fileData.length; i++){
            if (fileData[i] != null)
                System.out.println(fileData[i]);
        }
    }    
}
