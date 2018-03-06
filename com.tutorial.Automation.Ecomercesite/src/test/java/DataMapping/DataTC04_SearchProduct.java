package DataMapping;

import java.io.IOException;

import customizedLibrary.ExcelUtility;

public class DataTC04_SearchProduct {
	ExcelUtility excelobj;
	public final String SHEETNAME = "TC04_SearchProduct";
	
	public DataTC04_SearchProduct(String fileName) throws IOException {
		excelobj =  new ExcelUtility(fileName, SHEETNAME);
	}
	
	public String getItemSearchName() {
		return excelobj.getValueAt(1, 0);
	}
	
	public String getItemImageSource() {
		return excelobj.getValueAt(1, 1);
	}
	
	public String getItemPrice() {
		return excelobj.getValueAt(1, 2);
	}
	
}
