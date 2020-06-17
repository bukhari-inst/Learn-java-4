/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Bukhari_Inst
 */
public class Readxls {
    public static void main(String[] args) throws IOException {
        // Memanggil method readExcel
        readFromExcel("D://data.xls");
    }
    
    public static void readFromExcel(String urlexcel) throws FileNotFoundException, IOException{
        HSSFWorkbook myexcel = new HSSFWorkbook(new FileInputStream(urlexcel));
        HSSFSheet myexcelSheet = myexcel.getSheet("Aku");//hurufnamadepan sheet harus kapital
        FormulaEvaluator formulaEv = myexcel.getCreationHelper().createFormulaEvaluator();
        
        for(Row row: myexcelSheet){
            for(org.apache.poi.ss.usermodel.Cell cell:row){
                switch(formulaEv.evaluate(cell).getCellType()){
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue()+"\t\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue()+"\t\t");
                        break;
                        // untuk menampilkan colum tertentu
//                        if(cell.getColumnIndex()==0){
//                            System.out.print(cell.getStringCellValue()+"\t\t");
//                        }else if(cell.getColumnIndex()==1){
//                            System.out.println(cell.getStringCellValue()+"\t\t");
//                        }else if(cell.getColumnIndex()==2){
//                            System.out.println(cell.getStringCellValue()+"\t\t");
//                        }
//                        break;
                }
            }
            System.out.println("");
            myexcel.close();
        }
    }
}
