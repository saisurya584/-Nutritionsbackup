package com.cg.nutritions.services;

import java.util.List;

import com.cg.nutritions.entity.DietPlan;
import com.cg.nutritions.exceptions.ResourceNotFoundException;

public interface DietPalnSerive {
	
	DietPlan createDietPlan(DietPlan d);
	
	DietPlan getDietPlan(Long id) throws ResourceNotFoundException;
	
	DietPlan updateDietPlan(DietPlan d,Long id) throws ResourceNotFoundException;
	
	Boolean deleteDietPlan(Long id) throws ResourceNotFoundException;
	
	List<DietPlan> showAllDietPlan();

}
