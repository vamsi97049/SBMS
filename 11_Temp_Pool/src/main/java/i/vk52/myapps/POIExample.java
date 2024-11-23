package i.vk52.myapps;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExample {

    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook(); // Create a new Excel workbook
        Sheet sheet = workbook.createSheet("Sheet1"); // Create a sheet named "Sheet1"

        // Create a row (0-indexed) and add some cells to it
        Row row = sheet.createRow(0); // Create the first row

        // Create cells in the row
        Cell cell = row.createCell(0); // First cell in the row (A1)
        cell.setCellValue("Hello");

        cell = row.createCell(1); // Second cell in the row (B1)
        cell.setCellValue("World");

        // Add another row with different data
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("Apache POI");
        row.createCell(1).setCellValue("Excel API");

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            workbook.write(fileOut); // Write the data to the file
            System.out.println("Excel file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            workbook.close(); // Close the workbook to release resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
