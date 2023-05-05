package com.nt.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CitizenPlan;
import com.nt.repository.IReportPlanRepository;

@Component
public class ReportRunner implements ApplicationRunner {
	
	@Autowired
	private IReportPlanRepository planRepo;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		planRepo.deleteAll();
		
		//cash plan
		CitizenPlan cp=new CitizenPlan();
		cp.setCitizenName("John");
		cp.setGender("Male");
		cp.setPlanName("Cash");
		cp.setPlanStatus("Approved");
		cp.setPlanStartDate(LocalDate.now());
		cp.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp.setBenefitAmt(5000.0);
		
		CitizenPlan cp1=new CitizenPlan();
		cp1.setCitizenName("Smith");
		cp1.setGender("Male");
		cp1.setPlanName("Cash");
		cp1.setPlanStatus("Denid");
		cp1.setDenialReason("Rental Income");
		
		CitizenPlan cp2=new CitizenPlan();
		cp2.setCitizenName("Cathy");
		cp2.setGender("Female");
		cp2.setPlanName("Cash");
		cp2.setPlanStatus("Terminated");
		cp2.setPlanStartDate(LocalDate.now().minusMonths(4));
		cp2.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp2.setBenefitAmt(5000.0);
		cp2.setTerminatedDate(LocalDate.now());
		cp2.setTerminationRsn("Employee");
		
		//food plan
		CitizenPlan cp3=new CitizenPlan();
		cp3.setCitizenName("David");
		cp3.setGender("Male");
		cp3.setPlanName("Food");
		cp3.setPlanStatus("Approved");
		cp3.setPlanStartDate(LocalDate.now());
		cp3.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp3.setBenefitAmt(4000.0);
				
		CitizenPlan cp4=new CitizenPlan();
		cp4.setCitizenName("Robert");
		cp4.setGender("Male");
		cp4.setPlanName("Food");
		cp4.setPlanStatus("Denid");
		cp4.setDenialReason("Property Income");
				
		CitizenPlan cp5=new CitizenPlan();
		cp5.setCitizenName("Orlen");
		cp5.setGender("Female");
		cp5.setPlanName("Food");
		cp5.setPlanStatus("Terminated");
		cp5.setPlanStartDate(LocalDate.now().minusMonths(4));
		cp5.setPlanEndDate(LocalDate.now().plusMonths(6));
		cp5.setBenefitAmt(5000.0);
		cp5.setTerminatedDate(LocalDate.now());
		cp5.setTerminationRsn("Employee");
		
		//medical plan
				CitizenPlan cp6=new CitizenPlan();
				cp6.setCitizenName("Charles");
				cp6.setGender("Male");
				cp6.setPlanName("Medical");
				cp6.setPlanStatus("Approved");
				cp6.setPlanStartDate(LocalDate.now());
				cp6.setPlanEndDate(LocalDate.now().plusMonths(6));
				cp6.setBenefitAmt(5000.0);
				
				CitizenPlan cp7=new CitizenPlan();
				cp7.setCitizenName("Buttler");
				cp7.setGender("Male");
				cp7.setPlanName("Medical");
				cp7.setPlanStatus("Denid");
				cp7.setDenialReason("Rental Income");
				
				CitizenPlan cp8=new CitizenPlan();
				cp8.setCitizenName("Neel");
				cp8.setGender("Female");
				cp8.setPlanName("Medical");
				cp8.setPlanStatus("Terminated");
				cp8.setPlanStartDate(LocalDate.now().minusMonths(4));
				cp8.setPlanEndDate(LocalDate.now().plusMonths(6));
				cp8.setBenefitAmt(5000.0);
				cp8.setTerminatedDate(LocalDate.now());
				cp8.setTerminationRsn("Gov job");
				
				//Employee plan
				CitizenPlan cp9=new CitizenPlan();
				cp9.setCitizenName("Steve");
				cp9.setGender("Male");
				cp9.setPlanName("Employee");
				cp9.setPlanStatus("Approved");
				cp9.setPlanStartDate(LocalDate.now());
				cp9.setPlanEndDate(LocalDate.now().plusMonths(6));
				cp9.setBenefitAmt(5000.0);
				
				CitizenPlan cp10=new CitizenPlan();
				cp10.setCitizenName("Moris");
				cp10.setGender("Male");
				cp10.setPlanName("Employee");
				cp10.setPlanStatus("Denid");
				cp10.setDenialReason("Rental Income");
				
				CitizenPlan cp11=new CitizenPlan();
				cp11.setCitizenName("Gibs");
				cp11.setGender("Female");
				cp11.setPlanName("Employee");
				cp11.setPlanStatus("Terminated");
				cp11.setPlanStartDate(LocalDate.now().minusMonths(4));
				cp11.setPlanEndDate(LocalDate.now().plusMonths(6));
				cp11.setBenefitAmt(5000.0);
				cp11.setTerminatedDate(LocalDate.now());
				cp11.setTerminationRsn("Gov job");
				
				List<CitizenPlan> list=Arrays.asList(cp,cp1,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9,cp10,cp11);
				planRepo.saveAll(list);
	}

}
