package com.nt.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ReportGeneration;
import com.nt.entity.CitizenPlan;

public interface IReportPlanService {
	
	public List<String> getPlanNameList();
	public List<String> getPlanStatusList();
	public List<CitizenPlan> getAllRecord(ReportGeneration report);
	public void getExcel(HttpServletResponse response) throws Exception;
	public void getPdf(HttpServletResponse response) throws Exception;

}
