package com.dongnao.autotest.web;

import java.io.File;
import java.io.FileInputStream;
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

public class ExcelTest{
	private static final String EXCEL_PATH = "D:/JavaCourse/outotest-ws/com.dongnao.parent/case_template.xlsx";

	/**
	 * 
	 */
	@Test
	public void test() {
		try {
			// 同时支持Excel 2003、2007
			File excelFile = new File(EXCEL_PATH); // 创建文件对象
			if (!excelFile.exists())
				return;

			FileInputStream in = new FileInputStream(excelFile); // 文件流
			Workbook workbook = null;
			if (excelFile.getName().endsWith(".xls")) { // Excel 2003
				workbook = new HSSFWorkbook(in);
			} else if (excelFile.getName().endsWith(".xlsx")) {
				// Excel 2007/2010
				workbook = new XSSFWorkbook(in);
			}
			// Workbook workbook = WorkbookFactory.create(is); // 这种方式
			// Excel2003/2007/2010都是可以处理的

			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			/**
			 * 设置当前excel中sheet的下标：0开始
			 */
			Sheet sheet = workbook.getSheetAt(0); // 遍历第一个Sheet
			// Sheet sheet = workbook.getSheetAt(2); // 遍历第三个Sheet

			// 获取总行数
			// System.out.println(sheet.getLastRowNum());

			String groupName = sheet.getRow(1).getCell(0).getStringCellValue();
			if (StringUtils.isEmpty(groupName)) {
				System.out.println("分组名称不能为空");
			}
			String groupUrl = sheet.getRow(1).getCell(1).getStringCellValue();

			List<Map<String, Object>> caseList = new ArrayList<>();
			String lastCaseName = "";
			// 为跳过第一行目录设置count
			int rowIndex = 0;
			for (Row row : sheet) {
				// 跳过第一行的目录
				if (rowIndex < 1) {
					rowIndex++;
					continue;
				}
				if ("END".equalsIgnoreCase(row.getCell(0).getStringCellValue()))
					break;

				Map<String, Object> caseMap = new HashMap<>();
				// 获取总列数(空格的不计算)
				int columnTotalNum = row.getPhysicalNumberOfCells();
				// System.out.println("总列数：" + columnTotalNum);
				// System.out.println("最大列数：" + row.getLastCellNum());

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

				// for循环的，不扫描空格的列
				// for (Cell cell : row) {
				// System.out.println(cell);
				// }
			}

			for (Map<String, Object> itemMap : caseList) {
				System.out.println(itemMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
