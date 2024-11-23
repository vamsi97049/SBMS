package i.vk52.myapps;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class App2 {
	public static void main(String[] args) {
		Workbook workbook = new SXSSFWorkbook();
		Sheet sheet1 = workbook.createSheet("books data");
		
		// Create first Row 
		Row row = sheet1.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("BID");
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("BNAME");
		Cell cell3 = row.createCell(2);
		cell2.setCellValue("BPRICE");
		
	}
}
