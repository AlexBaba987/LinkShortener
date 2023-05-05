package com.nt.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.dto.ReportGeneration;
import com.nt.entity.CitizenPlan;
import com.nt.helper.ExportExcel;
import com.nt.helper.ExportPdf;
import com.nt.helper.MailSenderHello;
import com.nt.repository.IReportPlanRepository;

@Service
public class ReportPlanServiceImpl implements IReportPlanService {
	
	@Autowired
	private IReportPlanRepository repo;
	
	@Autowired
	private MailSenderHello mail;
	
	@Autowired
	private ExportExcel exportExcel;
	
	@Autowired
	private ExportPdf exportPdf;

	@Override
	public List<String> getPlanNameList() {
		return repo.getPlanName();
	}

	@Override
	public List<String> getPlanStatusList() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> getAllRecord(ReportGeneration report) {
		
		CitizenPlan plan=new CitizenPlan();
		
		if(report.getPlanName()!=null && report.getPlanName()!="")
			plan.setPlanName(report.getPlanName());
		
		if(report.getPlanStatus()!=null && report.getPlanStatus()!="")
			plan.setPlanStatus(report.getPlanStatus());
		
		if(report.getGender()!=null && report.getGender()!="")
			plan.setGender(report.getGender());
		
		if(report.getPlanStartDate()!=null&&report.getPlanStartDate()!="") {
			String plan1=report.getPlanStartDate();
			System.out.println("String="+plan1);
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 System.out.println(formatter); 
			 //convert String to LocalDate
			  LocalDate localDate = LocalDate.parse(plan1, formatter);
			plan.setPlanStartDate(localDate);
		}
		
		if(report.getPlanEndDate()!=null&&report.getPlanEndDate()!="") {
			String plan1=report.getPlanEndDate();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 System.out.println(formatter);
			  //convert String to LocalDate
			  LocalDate localDate = LocalDate.parse(plan1, formatter);
			plan.setPlanEndDate(localDate);
		}
		
		List<CitizenPlan> list=repo.findAll(Example.of(plan));
		return list;
	}

	//Export Excel 
	@Override
	public void getExcel(HttpServletResponse response) throws Exception {
		exportExcel.exportExcelSheet(response);
		
		String to="ravisingh5g8@gmail.com";
		String subject="test mail subject";
		String body="<h1>Test Mail Body</h1>";
		
		mail.sendMail(to, subject, body);
	}

	
	//Export PDF
	@Override
	public void getPdf(HttpServletResponse response) throws Exception {
		exportPdf.exportPdf(response);
	}

}
