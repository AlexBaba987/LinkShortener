package com.nt.helper;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.CitizenPlan;
import com.nt.repository.IReportPlanRepository;

@Component
public class ExportExcel {
	
	@Autowired
	private IReportPlanRepository repo;
	
	public void exportExcelSheet(HttpServletResponse response) throws Exception{
		
		//create WorkBook
	Workbook wb=new HSSFWorkbook();
	//create Sheet
	Sheet sheet=wb.createSheet("Plans-Data");
	
	//create Header Row
	Row headerRow=sheet.createRow(0);
	headerRow.createCell(0).setCellValue("Citizen Id");
	headerRow.createCell(1).setCellValue("Citizen Name");
	headerRow.createCell(2).setCellValue("Gender");
	headerRow.createCell(3).setCellValue("Plan Name");
	headerRow.createCell(4).setCellValue("Status");
	headerRow.createCell(5).setCellValue("Start Date");
	headerRow.createCell(6).setCellValue("End Date");
	
	//get record form database
	List<CitizenPlan> list=repo.findAll();
	int index=1;
	
	for (CitizenPlan citizenPlan : list) {
		Row dataRow=sheet.createRow(index++);
		dataRow.createCell(0).setCellValue(citizenPlan.getCitizenId());
		dataRow.createCell(1).setCellValue(citizenPlan.getCitizenName());
		dataRow.createCell(2).setCellValue(citizenPlan.getGender());
		dataRow.createCell(3).setCellValue(citizenPlan.getPlanName());
		dataRow.createCell(4).setCellValue(citizenPlan.getPlanStatus());
		if(citizenPlan.getPlanStartDate()!=null)
			dataRow.createCell(5).setCellValue(citizenPlan.getPlanStartDate()+"");
		else
			dataRow.createCell(5).setCellValue("N/A");
		
		if(citizenPlan.getPlanEndDate()!=null)
			dataRow.createCell(6).setCellValue(citizenPlan.getPlanEndDate());
		else
			dataRow.createCell(6).setCellValue(citizenPlan.getPlanEndDate());
	}
	
	
	ServletOutputStream sos=response.getOutputStream();
	wb.write(sos);
	wb.close();
	}
	
}
