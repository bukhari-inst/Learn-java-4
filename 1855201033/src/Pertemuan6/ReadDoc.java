/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan6;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author Bukhori
 */
public class ReadDoc {
    public static void main(String[] args) {
        
        File fileku = new File("D://readDoc.doc");
        WordExtractor extractor = null;
        
        try{
        FileInputStream fis = new FileInputStream(fileku.getAbsolutePath());
        HWPFDocument document = new HWPFDocument(fis);
        extractor = new WordExtractor(document);
        String filetext = extractor.getText();
        System.out.println(filetext);
        
        }catch(Exception exep){
            exep.printStackTrace();
        }
        
    }
}
