package com.nt.helper;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.entity.CitizenPlan;
import com.nt.repository.IReportPlanRepository;

@Component
public class ExportPdf {
	
	@Autowired
	private IReportPlanRepository repo;

	public void exportPdf(HttpServletResponse response) throws Exception {
		
		Document document=new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		//for paragraph font style
		Font fontTitle=FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
		
		Paragraph p= new Paragraph("Citizen Plan Info",fontTitle);
		
		//for paragraph text in center
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable table=new PdfPTable(7);
		table.setSpacingBefore(5);
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		
		List<CitizenPlan> plans=repo.findAll();
		
		for (CitizenPlan citizenPlan : plans) {
			table.addCell(citizenPlan.getCitizenId()+"");
			table.addCell(citizenPlan.getCitizenName());
			table.addCell(citizenPlan.getGender());
			table.addCell(citizenPlan.getPlanName());
			table.addCell(citizenPlan.getPlanStatus());
			table.addCell(citizenPlan.getPlanStartDate()+"");
			table.addCell(citizenPlan.getPlanEndDate()+"");
		}
		
		document.add(table);
		document.close();
	}
}
