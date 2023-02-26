package com.cg.nutritions.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nutritions.entity.WeightLog;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.services.WeightLogService;

@RestController
@RequestMapping("/weightlog")
public class WeightLogController {

	@Autowired
	private WeightLogService logService;

	@PostMapping("/createWeightlog")
	public ResponseEntity<WeightLog> addWeightLog(@RequestBody WeightLog weightlog) {
		return new ResponseEntity<WeightLog>(logService.addWeightLog(weightlog), HttpStatus.CREATED);

	}

	@PutMapping("/updateWeightlog/{weightid}")
	public ResponseEntity<?> updateWeightLog(@RequestBody WeightLog weightLog, @PathVariable Long weightid)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(logService.updateWeightLog(weightLog, weightid));
	}

	@GetMapping("/showWeightLogById/{id}")
	public ResponseEntity<WeightLog> showWeightLogByUserId(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(logService.showWeightLogById(id));
	}

	@DeleteMapping("/deleteWeightLog/{id}")
	public ResponseEntity<?> deleteWeightLog(@PathVariable Long id) throws ResourceNotFoundException {
		logService.deleteWeightLog(id);
		return ResponseEntity.ok("Deleted successfully");
	}

   @GetMapping("/showWeightLog")
	public ResponseEntity<List<WeightLog>> showListOfWeightLogs() {
		return ResponseEntity.ok(logService.showListOfWeightLogs());
	}

}
