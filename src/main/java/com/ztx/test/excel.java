package com.ztx.test;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;


/**
 * Created by Think on 2016/10/31.
 */
public class excel {
	//@Test
	public void readExcel() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String excelPath = "F:/excel/s.xls";
			File excelFile = new File(excelPath);
			FileInputStream excelStrem = new FileInputStream(excelFile);
			Workbook workbook = WorkbookFactory.create(excelStrem);
			System.out.println("输出workbook：" + workbook);
			//获取sheet的数量
			int sheetCount = workbook.getNumberOfSheets();
			//System.out.println("获取到的sheet数量:" + sheetCount);
			for (int s = 0; s < sheetCount; s++) {
				System.out.println("第" + s + "个sheet");
				//获取每一个sheet
				Sheet excelSheet = workbook.getSheetAt(s);
				//获取一个sheet中的行数
				int rowCount = excelSheet.getPhysicalNumberOfRows();
				System.out.println("行数：" + rowCount);
				//遍历每一行
				for (int r = 0; r < rowCount; r++) {
					System.out.println("第"+r+"行");
					//获取行
					Row excelRow = excelSheet.getRow(r);
					//获取一行中有几列单元格
					int cellCount = excelRow.getPhysicalNumberOfCells();
					System.out.println("列：" + cellCount);
					//遍历每一列
					for (int c = 0; c < cellCount; c++) {
						System.out.println("第"+c+"列");
						Cell excelCell = excelRow.getCell(c);
						System.out.println("cell值：" + excelCell);
						//为什么cellType是个int类型的
						int cellType = excelCell.getCellType();
						//System.out.println("cellType:" + cellType);
						String cellValue = null;
						switch (cellType) {
							case Cell.CELL_TYPE_STRING: //文本型
								cellValue = excelCell.getStringCellValue();
								System.out.println("文本型cell值：" + cellValue);
								break;
							case Cell.CELL_TYPE_NUMERIC:  //数字型，日期型
								//日期型
								if (DateUtil.isCellDateFormatted(excelCell)) {
									cellValue = dateFormat.format(excelCell.getDateCellValue());
									System.out.println("日期型cell值：" + cellValue);
								} else {
									cellValue = String.valueOf(excelCell.getNumericCellValue());
									System.out.println("输出的数字型:" + cellValue);
								}
								break;
							case Cell.CELL_TYPE_BOOLEAN://布尔型
								cellValue = String.valueOf(excelCell.getBooleanCellValue());
								System.out.println("输出布尔型：" + cellValue);
								break;
							case Cell.CELL_TYPE_BLANK: //空白
								cellValue = excelCell.getStringCellValue();
								System.out.println("输出空白型：" + cellValue);
							case Cell.CELL_TYPE_ERROR://错误
								//cellValue = String.valueOf(excelCell.getErrorCellValue());
								cellValue = "错误";
								System.out.println("输出错误：" + cellValue);
							case Cell.CELL_TYPE_FORMULA: //公式
								cellValue = excelCell.getCellFormula();
								System.out.println("输出公式型：" + cellValue);
							default:
								cellValue = "默认值";
						}
					}

				}
				System.out.println("行数：" + rowCount);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
