package com.cg.nutritions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nutritions.entity.NutritionPlan;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.services.NutritionPlanService;

@RestController
@RequestMapping("/nutritionplan")
public class NutritionPlanController {

	@Autowired
	private NutritionPlanService nutritionPlanService;

	@PostMapping("/addNutritionplan")
	public ResponseEntity<?> addNutritionPlan(@RequestBody NutritionPlan nutritionPlan) {
		return new ResponseEntity<>(nutritionPlanService.createNutritionPlan(nutritionPlan), HttpStatus.CREATED);
	}

	@PutMapping("/updateNutritionplan/{id}")
	public ResponseEntity<?> updateNutritionPlan(@RequestBody NutritionPlan nutritionPlan, @PathVariable Long id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(nutritionPlanService.updateNutritionPlan(nutritionPlan, id));
	}

	@GetMapping("/findNutritionplanbyid/{id}")
	public ResponseEntity<?> findNutritionPlanById(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(nutritionPlanService.findNutritionPlanById(id));
	}

	@DeleteMapping("/deleteNutritionPlanByI/{id}")
	public ResponseEntity<?> deleteNutritionPlan(@PathVariable Long id) throws ResourceNotFoundException {
		nutritionPlanService.deleteNutritionPlan(id);
		return ResponseEntity.ok("Nutrition plan deleted with id : " + id);
	}

	@GetMapping("/showAllNutritrition")
	public ResponseEntity<?> showListOfNutritionPlans() throws ResourceNotFoundException {
		return ResponseEntity.ok(nutritionPlanService.showListOfNutritionPlans());
	}

}
