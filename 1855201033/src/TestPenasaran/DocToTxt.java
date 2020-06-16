/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPenasaran;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Bukhori
 */
public class DocToTxt {

    public static void main(String[] args) {

        System.out.println(getReadDocFile());
        writeStringToTxtFile(getReadDocFile());

    }

    public static void writeStringToTxtFile(String str) {
        try {

            File newTextFile = new File("D://inputbaru3.txt");

            try (FileWriter fw = new FileWriter(newTextFile)) {
                fw.write(str);
            }

        } catch (IOException iox) {
// do stuff with exception

        }
    }

    private static String getReadDocFile() {
        String FilePath = "D:\\input3.doc";
        FileInputStream fis;
        String outPut = null;

        if (FilePath.substring(FilePath.length() - 1).equals("x")) { // is a
            //docx
            try {
                fis = new FileInputStream(new File(FilePath));
                XWPFDocument doc = new XWPFDocument();
                XWPFWordExtractor extract = new XWPFWordExtractor(doc);
// System.out.println(extract.getText());
                outPut = extract.getText();
                return outPut;
            } catch (IOException e) {
            }
        } else { // is not a docx
            try {
                fis = new FileInputStream(new File(FilePath));
                HWPFDocument doc = new HWPFDocument(fis);
                WordExtractor extractor = new WordExtractor(doc);
// System.out.println(extractor.getText());
                outPut = extractor.getText();
                return outPut;
            } catch (IOException e) {
            }
        }
        return outPut;
    }

}
