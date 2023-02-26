package com.cg.nutritions.services;

import java.util.List;

import com.cg.nutritions.entity.WeightLog;
import com.cg.nutritions.exceptions.ResourceNotFoundException;

public interface WeightLogService {
	
	WeightLog addWeightLog(WeightLog log);
	
	WeightLog  updateWeightLog (WeightLog  weightLog ,Long id) throws ResourceNotFoundException;
	
	WeightLog showWeightLogById(Long id) throws ResourceNotFoundException;
	
	void deleteWeightLog (Long id) throws ResourceNotFoundException;
	
	List<WeightLog > showListOfWeightLogs();

}
