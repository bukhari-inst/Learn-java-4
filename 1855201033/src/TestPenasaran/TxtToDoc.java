/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPenasaran;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Bukhori
 */
public class TxtToDoc {

    public static void main(String[] args) {
        
        System.out.println(readTextFile());
        createDocument(readTextFile());
    }
    
    private static String readTextFile() {
        BufferedReader br = null;
        String content = null;
        try {
            br = new BufferedReader(new FileReader("D://docc.doc"));
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

    private static void createDocument(String docName) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("D:\\docc.txt");
            try (OutputStreamWriter out = new OutputStreamWriter(fout)) {
               out.write(docName);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

}
