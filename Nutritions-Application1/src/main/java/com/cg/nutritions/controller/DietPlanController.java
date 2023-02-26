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

import com.cg.nutritions.entity.DietPlan;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.services.DietPalnSerive;

@RestController
@RequestMapping("/dietplan")
public class DietPlanController {

	@Autowired
	private DietPalnSerive dietPalnSerive;

	@GetMapping("getbyid/{dietid}")
	public ResponseEntity<?> getDietPlan(@PathVariable Long dietid) throws ResourceNotFoundException {
		return ResponseEntity.ok(dietPalnSerive.getDietPlan(dietid));
	}

	@PostMapping("/Createdietplan")
	public ResponseEntity<?> createDietPlan(@RequestBody DietPlan dietPlan) {
		return new ResponseEntity<>(dietPalnSerive.createDietPlan(dietPlan), HttpStatus.CREATED);
	}

	@PutMapping("/updatedietplan/{dietid}")
	public ResponseEntity<?> updateDietPlan(@RequestBody DietPlan dietPlan, @PathVariable Long dietid)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(dietPalnSerive.updateDietPlan(dietPlan, dietid));
	}

	@DeleteMapping("/deletedietplan/{dietid}")
	public ResponseEntity<?> deleteDietPlan(@PathVariable Long dietid) throws ResourceNotFoundException {
		dietPalnSerive.deleteDietPlan(dietid);
		return ResponseEntity.ok("Diet plan deleted successfully");
	}

	@GetMapping("/showalldietplans")
	public ResponseEntity<?> showAllDietPlan() {
		return ResponseEntity.ok(dietPalnSerive.showAllDietPlan());
	}
}
