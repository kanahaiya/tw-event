package com.twevent.lms.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.twevent.lms.constants.LiberaryManagerConstants;
import com.twevent.lms.model.UserInfo;
import com.twevent.lms.utility.UserStatus;

public class LiberaryDAOImpl implements LiberaryDao {
	@Override
	public void registerUser(UserInfo useInfo) throws IOException {
		saveUserDetails(useInfo);
	}

	private void saveUserDetails(UserInfo userInfo) throws IOException {
		String excelFileName = LiberaryManagerConstants.OUTPUT_FILE_PATH;// name

		String sheetName = "USER_DETAILS";// name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);

		// iterating r number of rows
		for (int r = 1; r <= 1; r++) {
//			int rowId = countNumberOfRecords();
			XSSFRow row = sheet.createRow(r);

			// iterating c number of columns
			XSSFCell sno = row.createCell(0);
			sno.setCellValue(r);
			XSSFCell userName = row.createCell(1);
			userName.setCellValue(userInfo.getUserName());
			XSSFCell mobileNumber = row.createCell(2);
			mobileNumber.setCellValue(userInfo.getMobileNumber());
			XSSFCell emailAddress = row.createCell(3);
			emailAddress.setCellValue(userInfo.getEmailId());
			XSSFCell address = row.createCell(4);
			address.setCellValue(userInfo.getUserAddress());
			XSSFCell status = row.createCell(5);
			status.setCellValue(UserStatus.ACTIVE+"");
		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

	public List<String> getSubsriptionPlan() throws Exception{
		List<String> subscriptionOptions=new ArrayList<String>();
		
		InputStream inp = new FileInputStream(LiberaryManagerConstants.OUTPUT_FILE_PATH);
		int ctr = 1;
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(1);
		Row row = null;
		Cell cell = null;
		boolean isNull = false;
		do{
			try{
			row = sheet.getRow(ctr);
			cell = row.getCell(1);
			subscriptionOptions.add(cell.toString());
			ctr++;
			} catch(Exception e) {
				isNull = true;
			}
			
		}while(isNull!=true);
		inp.close();
		return subscriptionOptions;
	}
	@Override
	public int update(UserInfo useInfo) {
		return -1;
	}

	@Override
	public int delete(UserInfo useInfo) {
		return 0;
	}

	@Override
	public boolean reactivate(UserInfo useInfo) {
		return false;
	}

	@Override
	public boolean deactivate(UserInfo useInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	private List<String> getUsersList() {
		//return subscriptin list from DB
		return null;
	}
	
}
