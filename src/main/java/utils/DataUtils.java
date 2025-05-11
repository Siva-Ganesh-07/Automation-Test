package utils;

import org.testng.annotations.DataProvider;

import home.ReadExcel;

public class DataUtils {
	@DataProvider()
	public String[][] getData(){
		String[][] excelData = ReadExcel.getExcelData();
		return excelData;
	}

}
