package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.ReportGeneration;
import com.nt.entity.CitizenPlan;
import com.nt.service.IReportPlanService;

@Controller
public class ReportController {

	@Autowired
	private IReportPlanService serviceRepo;
	
	@GetMapping("/")
	public String showIndexPage(@ModelAttribute("search") ReportGeneration searchObj,Model model) {
		
		/*ReportGeneration searchObj=new ReportGeneration();
		model.addAttribute("search",searchObj);*/
		
		List<String> list1=serviceRepo.getPlanNameList();
		List<String> list2=serviceRepo.getPlanStatusList();
		model.addAttribute("planName", list1);
		model.addAttribute("planStatus", list2);
		return "index";
	}
	
	@PostMapping("/search")
	public String sendRequestedData(@ModelAttribute("search") ReportGeneration searchObj,Model model) {
		List<String> list1=serviceRepo.getPlanNameList();
		List<String> list2=serviceRepo.getPlanStatusList();
		model.addAttribute("planName", list1);
		model.addAttribute("planStatus", list2);
		
		List<CitizenPlan> list3=serviceRepo.getAllRecord(searchObj);
		model.addAttribute("recordList",list3);
		
		return "index";
	}
	
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;fileName=plans.xls");
		
		serviceRepo.getExcel(response);
	}
	
	@GetMapping("/pdf")
	public void exportPDF(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;fileName=plans.pdf");
		
		serviceRepo.getPdf(response);
		
	}
}
