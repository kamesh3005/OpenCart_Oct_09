package utilities;

import java.io.IOException;

public class DataProviders {

	@org.testng.annotations.DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String loc = System.getProperty("user.dir") + "/testdata/OpenCartLoginData.xlsx";//Taking the Xl file from test data
		ExcelUtil exl = new ExcelUtil(loc);//create a object for excelutility
		int totalRows = exl.getRowCount("Sheet1");
		int totalCells = exl.getCellCount("Sheet1", 1);
		String loginData[][] = new String[totalRows][totalCells];
		for (int r = 1; r <= totalRows; r++) {

			for (int c = 0; c < totalCells; c++) {

				loginData[r - 1][c] = exl.getCellData("Sheet1", r, c);//copy the data from the excel sheet 
			}

		}

		return loginData;
	}
}
