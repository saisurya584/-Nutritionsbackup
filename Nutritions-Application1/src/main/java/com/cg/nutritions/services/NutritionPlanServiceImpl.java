package com.cg.nutritions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritions.entity.NutritionPlan;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.NutritionPlanRepository;

@Service
public class NutritionPlanServiceImpl implements NutritionPlanService {

	@Autowired
	private NutritionPlanRepository nutritionPlanRepository;

	@Override
	public NutritionPlan createNutritionPlan(NutritionPlan nutritionPlan) {

		return nutritionPlanRepository.save(nutritionPlan);
	}

	@Override
	public NutritionPlan updateNutritionPlan(NutritionPlan nutritionPlan, Long id) throws ResourceNotFoundException {
		NutritionPlan nutrition = nutritionPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nutrition plan  is not found with id :" + id));

		
		return nutritionPlanRepository.save(nutritionPlan);
	}

	@Override
	public NutritionPlan findNutritionPlanById(Long id) throws ResourceNotFoundException {

		return nutritionPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nutrition plan  is not found with id :" + id));
	}

	@Override
	public void deleteNutritionPlan(Long id) throws ResourceNotFoundException {
		NutritionPlan p = nutritionPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nutrition plan  is not found with id :" + id));
		nutritionPlanRepository.delete(p);

	}

	@Override
	public List<NutritionPlan> showListOfNutritionPlans() throws ResourceNotFoundException {
		List<NutritionPlan> list = nutritionPlanRepository.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("Nutrition plans are Not present ");
		}
		return list;
	}

}
