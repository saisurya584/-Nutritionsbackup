package com.cg.nutritions.services;

import java.util.List;

import com.cg.nutritions.entity.NutritionPlan;
import com.cg.nutritions.exceptions.ResourceNotFoundException;

public interface NutritionPlanService {

	NutritionPlan createNutritionPlan(NutritionPlan nutritionPlan);

	NutritionPlan updateNutritionPlan(NutritionPlan nutritionPlan, Long id) throws ResourceNotFoundException;

	NutritionPlan findNutritionPlanById(Long id) throws ResourceNotFoundException;

	void deleteNutritionPlan(Long id) throws ResourceNotFoundException;

	List<NutritionPlan> showListOfNutritionPlans() throws ResourceNotFoundException;

}
