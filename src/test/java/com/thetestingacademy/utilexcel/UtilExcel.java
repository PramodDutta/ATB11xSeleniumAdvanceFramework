package com.thetestingacademy.utilexcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {


    // Apache POI
    // Read the File - TestData.xlsX
    //  Workbook Create
    // Sheet
    // Row and Cell
    // 2D Object  - getData()

    static Workbook book;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";

    public static Object[][] getTestDataFromExcel(String sheetName) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(SHEET_PATH);
            book = WorkbookFactory.create(fileInputStream);
            sheet = book.getSheet(sheetName);

        } catch (IOException e) {
            System.out.println("Either File Not Found! or workbook not created!");
        }


        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) { // 0 to 20

            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) { // 0 to 1

                // First row email, password -> column name - skip - header
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

            }

        }
        return data;
    }
}
