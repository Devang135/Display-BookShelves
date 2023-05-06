package userDefinedLibraries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static FileOutputStream fileOP;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet = null;
	public static XSSFCell cell = null;
	public static XSSFCell cell2 = null;
	public static XSSFCell cell3 = null;
	public static XSSFRow row = null;
	public static String exFilePath1 = "./src/main/java/data/BookShelvesBelow15000.xlsx";
	public static String exFilePath2 = "./src/main/java/data/ByAtHomeBookShelves.xlsx";
	
	public static void below15000BookShelves(String[] bookShelves ,String[] seller, String[] prices) {
		
		//exFilePath1 = exFilePath1;
		//exFilePath2 = exFilePath2;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Below_15000");

		for (int i = 1; i <= 3; i++) {
			
			row = ExcelWrite.sheet.getRow(i);
			
			if (row == null)
				row = ExcelWrite.sheet.createRow(i);
		
			cell = row.getCell(0);
			
			if (cell == null)
				cell = row.createCell(0);
			
			cell.setCellValue(bookShelves[i-1]);
			
			cell2 = row.getCell(1);
			
			if (cell2 == null)
				cell2 = row.createCell(1);
			
			cell2.setCellValue(seller[i-1]);
			
			cell3 = row.getCell(2);
			
			if (cell3 == null)
				cell3 = row.createCell(2);
			
			cell3.setCellValue(prices[i-1]);
			System.out.println(" seller " + i + " " + seller[i-1]);
			System.out.println(" prices " + i + prices[i-1]);
		}
		
		try {

			fileOP = new FileOutputStream(new File(exFilePath1));
			workbook.write(fileOP);
			fileOP.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	public static void byAtHomeBookshelves(String[] bookShelves , String[] seller, String[] prices , int x) {
		
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("By@Home");

		for (int i = 1; i <= x; i++) {
			
			row = ExcelWrite.sheet.getRow(i);
			
			if (row == null)
				row = ExcelWrite.sheet.createRow(i);
		
			cell = row.getCell(0);
			
			if (cell == null)
				cell = row.createCell(0);
			
			cell.setCellValue(bookShelves[i-1]);
			
			cell2 = row.getCell(1);
			
			if (cell2 == null)
				cell2 = row.createCell(1);
			
			cell2.setCellValue(seller[i-1]);
			
			cell3 = row.getCell(2);
			
			if (cell3 == null)
				cell3 = row.createCell(2);
			
			cell3.setCellValue(prices[i-1]);
			System.out.println(" seller " + i + " " + seller[i-1]);
			System.out.println(" prices " + i + " " + prices[i-1]);
		}
		
		try {

			fileOP = new FileOutputStream(new File(exFilePath2));
			workbook.write(fileOP);
			fileOP.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}
	
}
