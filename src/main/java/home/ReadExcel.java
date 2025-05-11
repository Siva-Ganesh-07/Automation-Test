package home;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] getExcelData(){
		String fileLocation = "./test_data/data.xlsx";
		
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		
		//System.out.println("Number of Rows:"+lastRowNum);
		//int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		//System.out.println("Number of Rows with Header:"+physicalNumberOfRows);
		//System.out.println("Number of Cells:"+lastCellNum);
		
		String data[][] = new String[lastRowNum][lastCellNum];
		for(int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				//System.out.println(value);
				data[i-1][j] = value;
			}
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
