package Utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritetoExcel { 
	
	public static void writeToExcel(Map<String, String> data, String fileName) throws IOException {

		File file=new File("./deliverables/outputExcel/"+fileName+".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Output");

		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			String value = data.get(key);
			int cellnum = 0;
			
			Cell cell1 = row.createCell(cellnum++);
			sheet.autoSizeColumn(cellnum);
			cell1.setCellValue(key);
			 
			Cell cell2 = row.createCell(cellnum++);
			sheet.autoSizeColumn(cellnum);
			cell2.setCellValue(value);

		}

		FileOutputStream fout=new FileOutputStream(file);  //Instatiating fileoutputstream class for writting inside the excel sheet.
		workbook.write(fout);
		fout.close();

	}
}
