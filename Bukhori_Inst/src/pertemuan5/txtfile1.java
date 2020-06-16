/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author citra
 */
public class txtfile1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = "D://input.txt";
        String baris = null;

        //adalah class, objek
        FileReader FileReader
                = new FileReader(filename);
        BufferedReader bufferedReader
                = new BufferedReader(FileReader);
        while ((baris = bufferedReader.readLine()) != null) {

        }
        bufferedReader.close();
    }
}
