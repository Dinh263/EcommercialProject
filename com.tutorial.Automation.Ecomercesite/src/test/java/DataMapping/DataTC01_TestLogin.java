package DataMapping;

import java.io.IOException;

import customizedLibrary.ExcelUtility;

public class DataTC01_TestLogin {
	ExcelUtility excelobj;
	public final String SHEETNAME = "TC01_TestLogin";
	
	public DataTC01_TestLogin(String fileName) throws IOException {
		excelobj =  new ExcelUtility(fileName, SHEETNAME);
	}
	
	public String getEmailLogin() {
		return excelobj.getValueAt(1, 0);
	}
	
	public String getPasswordLogin() {
		return excelobj.getValueAt(1, 1);
	}
	
	
	
}
