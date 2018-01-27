package DataMapping;

import java.io.IOException;

import customizedLibrary.ExcelUtility;

public class Data_TC02_TestSendARequest {
	ExcelUtility excelobj;
	public final String SHEETNAME = "TC02_TestSendARequest";
	
	public Data_TC02_TestSendARequest(String fileName) throws IOException {
		excelobj =  new ExcelUtility(fileName, SHEETNAME);
	}
	
	public String getSubject() {
		return excelobj.getValueAt(1, 0);
	}
	
	public String getEmail() {
		return excelobj.getValueAt(1, 1);
	}
	
	public String getOrderID() {
		return excelobj.getValueAt(1, 2);
	}
	
	public String getAttacheFile() {
		return excelobj.getValueAt(1, 3);
	}
	
	public String getFileNameAttached() {
		return excelobj.getValueAt(1, 4);
	}
	
	public String getMessage() {
		return excelobj.getValueAt(1, 5);
	}
}
