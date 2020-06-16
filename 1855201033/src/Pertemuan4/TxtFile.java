/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Bukhori
 */
public class TxtFile {
    public static void main(String[] args) throws IOException {
        
        // Read TXT File
        String filename = "D://input.txt"; //path
        String baris = null;
        
        // filereader adalah class, // objek
        FileReader namaobjek = new FileReader(filename);
        
        // Menampilkan file
        BufferedReader namaobjek2 = new BufferedReader(namaobjek);
       
        int bariske = 0;
       
        while ((baris = namaobjek2.readLine()) != null){
            //System.out.println(baris);
            if (bariske == 0){
                System.out.println(baris);
            }bariske++;
        }
        namaobjek2.close();
    }
    
}
