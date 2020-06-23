/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.log4j.BasicConfigurator;
/**
 *
 * @author Bukhari_Inst
 */
public class WriteXls {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BasicConfigurator.configure();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("NOAH Song");
         
        Object[][] bookData = {
                {"Yang Terdalam", "Taman Langit", 2003},
                {"Menghapus Jejakmu", "Hari Yang Cerah", 2007},
                {"Separuh Aku", "Seperti Seharusnya", 2012},
                {"Wanitaku", "Keterkaitan Keterikatan", 2019},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream("D://WriteXls.xls")) {
            workbook.write(outputStream);
        }
    }
}
