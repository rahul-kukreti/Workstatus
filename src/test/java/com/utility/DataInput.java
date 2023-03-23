package com.utility;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataInput {
	
	public String getfilename() {
		
		String filename = "/TestData/StageData.xlsx";
		return filename;
	}
	
	public Recordset getValuefromsheet(String sheetName,String testCaseID) throws FilloException {
		
		Recordset record = null;
		Fillo fillo = new Fillo();
		Connection conn = fillo.getConnection(System.getProperty("user.dir").replace("\\", "/") + getfilename());
		record = conn.executeQuery("Select * From " + sheetName + " where testCaseID = '" +testCaseID+"'");
        record.moveFirst();
        return record;
	}

}
