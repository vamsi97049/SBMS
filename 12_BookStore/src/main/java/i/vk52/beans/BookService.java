package i.vk52.beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

public class BookService {
	
	private BookDaoImpl bookDao;
	
	public BookService(BookDaoImpl bookDao) {
		this.bookDao = bookDao;
	}
	
	public void fileReader() throws Exception {
		File file = new File("bookdata.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String line = bufferedReader.readLine();
		int no=0;
		
		while(line!=null) {
			
			String[] values = line.split(",");
			int bid = Integer.parseInt(values[0]);
			String bname = values[1];
			int bprice = Integer.parseInt(values[2]);
			bookDao.saveBookDetails(bid, bname, bprice);
			no+=1;
			line = bufferedReader.readLine();
			
		}
		System.out.println(no+" records inserted successfully");
	}
	public void export2CSV() throws IOException{
		List<Book> books = bookDao.getDataFromDB();
		File file = new File("bookstoredata.csv");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("bid,bname,bprice\n");
		for(Book book:books) {
			bufferedWriter.write(book.getBid()+","+book.getBname()+","+book.getBprice()+"\n");
			bufferedWriter.flush();
		}
		System.out.println("CSV file generated");
	}
	public void export2ExcelFile() throws IOException {
		List<Book> books = bookDao.getDataFromDB();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet1 = workbook.createSheet("books data");
		Row headerRow = sheet1.createRow(0);
		headerRow.createCell(0).setCellValue("BID");
		headerRow.createCell(1).setCellValue("BNAME");
		headerRow.createCell(2).setCellValue("BPRICE");
		int rowIndex = 1;
		for (Book book : books) {
			Row row = sheet1.createRow(rowIndex++);
			row.createCell(0).setCellValue(book.getBid());
			row.createCell(1).setCellValue(book.getBname());
			row.createCell(2).setCellValue(book.getBprice());
		}
		String filePath = "BooksData.xlsx";
		FileOutputStream fileOut = new FileOutputStream(filePath);
		workbook.write(fileOut); 
		System.out.println("Books Data Excel File Downloaded at: " + filePath);
		workbook.close();

	}
	
	public void export2Pdf() throws Exception {
		List<Book> books = bookDao.getDataFromDB();
		PdfWriter writer = new PdfWriter("BooksData.pdf");
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		Table table = new Table(3);
		table.addHeaderCell("Books Collection :: 2024");
		table.addCell("Book ID");
		table.addCell("Book Name");
		table.addCell("Book Price");
		for (Book book : books) {
            table.addCell(String.valueOf(book.getBid()));
            table.addCell(book.getBname());
            table.addCell(String.valueOf(book.getBprice()));
        }
        document.add(table);
        document.close();
        System.out.println("BooksData.pdf generated");
	}
}
