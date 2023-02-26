package com.cg.nutritions.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritions.entity.WeightLog;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.WeightLogRepository;

@Service
public class WeightLogServiceImpl implements WeightLogService {

	@Autowired
	private WeightLogRepository weightLogRepository;

	@Override
	public WeightLog addWeightLog(WeightLog log) {

		return weightLogRepository.save(log);
	}

	@Override
	public WeightLog updateWeightLog(WeightLog weightLog, Long id) throws ResourceNotFoundException {
		WeightLog wLog = weightLogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Weight Log Not found : " + id));
		weightLogRepository.delete(wLog);

		return weightLogRepository.save(weightLog);
	}

	@Override
	public WeightLog showWeightLogById(Long Id) throws ResourceNotFoundException {
	return weightLogRepository.findById(Id)
			.orElseThrow(() -> new ResourceNotFoundException("Weight Log Not found : " + Id));
	}

	@Override
	public void deleteWeightLog(Long id) throws ResourceNotFoundException {
		WeightLog wLog = weightLogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Weight Log Not found : " + id));
		weightLogRepository.delete(wLog);

	}

	@Override
	public List<WeightLog> showListOfWeightLogs() {

		return weightLogRepository.findAll();
	}

}
