package com.ztx.action;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.struts2.convention.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Think on 2016/12/7.
 */
@ExceptionMappings({@ExceptionMapping(exception = "java.lang.RuntimeException",result = "error")})
@ParentPackage("struts-default")
@Namespace("/sapexprot/exce")
public class sapExcelAction {
	private String saptayevalue;


	private String sapName;

	private InputStream sapStrean;

	public sapExcelAction() {
	}

	public String getSapName() {
		return sapName;
	}

	public void setSapName(String sapName) {
		this.sapName = sapName;
	}

	public InputStream getSapStrean() {
		return sapStrean;
	}

	public void setSapStrean(InputStream sapStrean) {
		this.sapStrean = sapStrean;
	}

	public String getSaptayevalue() {
		return saptayevalue;
	}

	public void setSaptayevalue(String saptayevalue) {
		this.saptayevalue = saptayevalue;
	}

	@Action(value = "/sapData",results = {@Result(name = "exportData", type = "stream", params = {
			"contentType", "application/octet-stream", "inputName",
			"sapStrean", "contentDisposition",
			"attachment;filename=\"${sapName}\"", "bufferSize", "4096" }) })
	public String exprotsapData(){
		try {
			sapName = "sap.xls";
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			//创建一个工作薄
			HSSFWorkbook sapwb = new HSSFWorkbook();
			//创建一个sheet
			HSSFSheet sapsheet = sapwb.createSheet("sap");

			/*设置单元格样式*/
			HSSFCellStyle sapstyle = sapwb.createCellStyle();

			/*创建第一行*/
			HSSFRow saprow = sapsheet.createRow(0);

			sapstyle.setAlignment(CellStyle.ALIGN_CENTER);
			sapstyle.setFillBackgroundColor((short) 11);

			HSSFCell sapcell = saprow.createCell(0);
			sapcell.setCellValue("采购订单号");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(1);
			sapcell.setCellValue("供应商编码");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(2);
			sapcell.setCellValue("服务站代码");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(3);
			sapcell.setCellValue("物料编码");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(4);
			sapcell.setCellValue("数量");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(5);
			sapcell.setCellValue("含税单价");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(6);
			sapcell.setCellValue("税率代码");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(7);
			sapcell.setCellValue("成本中心");
			sapcell.setCellStyle(sapstyle);
			sapcell = saprow.createCell(8);
			sapcell.setCellValue("WBS元素");
			sapcell = saprow.createCell(9);
			sapcell.setCellStyle(sapstyle);



			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			Map<String,Object>  map = new HashMap<String,Object>();
			for(int it = 1;it<10;it++){
				System.out.println("it:"+it);
				map.put("学生编号", it);
				map.put("学生姓名", "xhy"+it);
				map.put("学生性别", "男"+it);
				list.add(map);
				System.out.println("map:"+map);
			}
			System.out.println("list:"+list);
			for(int i =1;i<list.size();i++){
				 saprow= sapsheet.createRow(i);
				for(int ii = 0 ;ii<map.size();ii++) {
					System.out.println("map.size()"+map.size());
					sapcell =saprow.createCell(ii);
					System.out.println("map.get(ii):"+map.get(ii));
					sapcell.setCellValue(new HSSFRichTextString((String) map.get(ii)));

				}
			}
			System.out.println("输出的生成表"+sapwb);
			System.out.println("输出的流"+sapStrean);
			sapwb.write(out);
			sapStrean = new ByteArrayInputStream(out.toByteArray());;
			System.out.println("输出的流"+sapStrean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exportData";

	}


}
