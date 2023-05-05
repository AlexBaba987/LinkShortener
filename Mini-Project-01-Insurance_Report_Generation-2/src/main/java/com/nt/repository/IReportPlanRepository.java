package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.CitizenPlan;

public interface IReportPlanRepository extends JpaRepository<CitizenPlan, Integer> {

	@Query("select distinct(planName) from com.nt.entity.CitizenPlan")
	public List<String> getPlanName();
	
	@Query("select distinct(planStatus) from com.nt.entity.CitizenPlan")
	public List<String> getPlanStatus();
}
