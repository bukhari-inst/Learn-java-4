/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPenasaran;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Bukhori
 */
public class test {
 
    public static void main(String[] args) {
        System.out.println(getReadDocFile());
        writeStringToTxtFile(getReadDocFile());
    }
    
    public static void writeStringToTxtFile(String str) {
        String FilePath = "thetextfile.doc";
        String FilePath2 = "thetextfile.doc";

        try {

            if (FilePath == FilePath2) {
                java.io.File newTextFile1 = new java.io.File("D://thetextfile2.txt");
                try (FileWriter fw1 = new FileWriter(newTextFile1)) {
                    fw1.write(str);
                }
            } else {
                java.io.File newTextFile2 = new java.io.File("D://thetextfile.doc");
                try (FileWriter fw2 = new FileWriter(newTextFile2)) {
                    fw2.write(str);
                }
            }

        } catch (IOException iox) {
            // do stuff with exception

        }
    }

    private static String getReadDocFile() {
        String FilePath = "D:\\thetextfile.doc";
        FileInputStream fis;
        String outPut = null;

        if (FilePath.substring(FilePath.length() - 1).equals("x")) { // is a
            //docx
            try {
                fis = new FileInputStream(new java.io.File(FilePath));
                XWPFDocument doc = new XWPFDocument();
                XWPFWordExtractor extract = new XWPFWordExtractor(doc);
// System.out.println(extract.getText());
                outPut = extract.getText();
                return outPut;
            } catch (IOException e) {
            }
        } else { // is not a docx
            BufferedReader br = null;
            String content = null;
            try {
                br = new BufferedReader(new FileReader("D:\\thetextfile.txt"));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    line = br.readLine();
                    sb.append(System.lineSeparator());
                }
                content = sb.toString();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            return content;
        }
        return null;

    }
    
}
