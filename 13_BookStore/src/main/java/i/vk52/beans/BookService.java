package i.vk52.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookService {
    private BookDaoImpl daoImpl;

    // Setter method for dependency injection
    public void setDaoImpl(BookDaoImpl daoImpl) {
        this.daoImpl = daoImpl;
    }

    public String readLineContent(String filePath) {
        if (filePath != null) {
            int rows = 0;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) { // Read a line at a time
                    if (!line.trim().isEmpty()) {  // Check if the line is not empty
                        String[] bookData = line.split(",");
                        if (bookData.length == 3) { // Ensure there are exactly 3 elements
                            try {
                                int bookId = Integer.parseInt(bookData[0].trim());
                                String bookName = bookData[1].trim();
                                int bookPrice = Integer.parseInt(bookData[2].trim());
                                daoImpl.insertRecord(bookId, bookName, bookPrice);
                                rows++;
                            } catch (NumberFormatException e) {
                                System.out.println("Error parsing book data: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Skipping invalid line: " + line);
                        }
                    }
                }
                return rows + " records inserted into Book Database";
            } catch (IOException e) {
                e.printStackTrace();  // Log the exception for debugging
                return "Error reading the file: " + e.getMessage();
            } finally {
                // Ensure the reader is closed
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error closing the file: " + e.getMessage());
                    }
                }
            }
        } else {
            return "Invalid File (or) Provide correct file path";
        }
    }
}
