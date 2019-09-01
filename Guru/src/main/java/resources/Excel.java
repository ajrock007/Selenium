package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public String[][] readExcel(String path) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		String b[][] = new String[5][5];
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		int i=0;
		rows.next();
		while(rows.hasNext()) {
			Row row= rows.next();
			Iterator<Cell> cellit = row.iterator();
			int j=0;
			while(cellit.hasNext()) {
				Cell cell = cellit.next();
				a.add(cell.getStringCellValue());
				b[i][j]=cell.getStringCellValue();
				j++;
			}
			i++;
			
		}
		
		return b;
		
	}
	
	public void writeExcel(String path) {
		
	}

}
