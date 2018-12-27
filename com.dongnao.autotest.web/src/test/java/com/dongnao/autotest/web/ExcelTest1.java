package com.dongnao.autotest.web;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.util.StringUtils;
public class ExcelTest1 {
	
    private static final String EXCEL_PATH ="D:/JavaCourse/outotest-ws/com.dongnao.parent/case_template.xlsx";
	@Test
	public void test() {
		
		
		try {
			File excelFile = new File(EXCEL_PATH);
			if(!excelFile.exists()) 
				return;
			
			FileInputStream in = new FileInputStream(excelFile);
			
			Workbook  workbook = null;
			if(excelFile.getName().endsWith(".xls")) {
				workbook = new HSSFWorkbook(in);
			}else if(excelFile.getName().endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(in);
			}
			
			Sheet sheet = workbook.getSheetAt(0); 
			
			String groupName = sheet.getRow(1).getCell(0).getStringCellValue();
			if (StringUtils.isEmpty(groupName)) {
				System.out.println("分组名称不能为空");
			}
			
			String groupUrl = sheet.getRow(1).getCell(1).getStringCellValue();
			int sheetCount = workbook.getNumberOfSheets();
			
		
			//List<Map<String, Object>> caseList = new ArrayList<>();
			List<Map<String,Object>> caseList = new ArrayList<>();
			String lastCaseName = "";
		    int rowIndex = 0;
		    
		    for(Row row:sheet) {
		    	if(rowIndex<1) {
		    		rowIndex++;
		    		continue;
		    	}
		    	
		    	if("End".equalsIgnoreCase(row.getCell(0).getStringCellValue())) 
		    		break;
		    	
		    	Map<String, Object> caseMap = new HashMap<>();
		    	//Map<String, Object> caseMap = new HashMap<>();
		    	
		    	String caseName = row.getCell(2).getStringCellValue();
				if (!StringUtils.isEmpty(caseName)) {
					lastCaseName = caseName;
				}

				String stepName = row.getCell(3).getStringCellValue();
				String stepAction = row.getCell(4).getStringCellValue();
				String stepUrl = row.getCell(5).getStringCellValue();
				String stepSelector = row.getCell(6).getStringCellValue();
				String stepHeader = row.getCell(7).getStringCellValue();
				String stepContentType = row.getCell(8).getStringCellValue();
				String stepBody = row.getCell(9).getStringCellValue();

				caseMap.put("group", groupName);
				caseMap.put("groupUrl", groupUrl);
				caseMap.put("caseName", lastCaseName);
				caseMap.put("stepName", stepName);
				caseMap.put("stepAction", stepAction);
				caseMap.put("stepUrl", stepUrl);
				caseMap.put("stepSelector", stepSelector);
				caseMap.put("stepHeader", stepHeader);
				caseMap.put("stepContentType", stepContentType);
				caseMap.put("stepBody", stepBody);
				caseList.add(caseMap);

		    }
		    
		    for (Map<String, Object> itemMap : caseList) {
				System.out.println(itemMap);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
