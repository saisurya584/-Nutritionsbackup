package com.cg.nutritions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritions.entity.DietPlan;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.DietPlanRepository;

@Service
public class DietPlanServiceImpl implements DietPalnSerive {

	@Autowired
	private DietPlanRepository dietPlanRepository;

	@Override
	public DietPlan createDietPlan(DietPlan d) {
		if (d.getSlots().equalsIgnoreCase(DietPlanConstants.MORNING_MEAL)) {
			if (d.getFoodType().equalsIgnoreCase(DietPlanConstants.VEG)) {
				d.setProteinRatio(DietPlanConstants.VEG_PROTEIN_RATIO);
				d.setFatRatio(DietPlanConstants.VEG_FAT_RATIO);
				d.setCarbsRatio(DietPlanConstants.VEG_CARBS_RATIO);
				d.setTotal(DietPlanConstants.VEG_TOTAL);
			} else {
				d.setProteinRatio(DietPlanConstants.NON_VEG_PROTEIN_RATIO);
				d.setFatRatio(DietPlanConstants.NON_VEG_FAT_RATIO);
				d.setCarbsRatio(DietPlanConstants.NON_VEG_CARBS_RATIO);
				d.setTotal(DietPlanConstants.NON_VEG_TOTAL);
			}

		} else {
			if (d.getSlots().equalsIgnoreCase(DietPlanConstants.EVENING_MEAL)) {
				if (d.getFoodType().equalsIgnoreCase(DietPlanConstants.VEG)) {
					d.setProteinRatio(DietPlanConstants.VEG_PROTEIN_RATIO);
					d.setFatRatio(DietPlanConstants.VEG_FAT_RATIO);
					d.setCarbsRatio(DietPlanConstants.VEG_CARBS_RATIO);
					d.setTotal(DietPlanConstants.VEG_TOTAL);
				} else {
					d.setProteinRatio(DietPlanConstants.NON_VEG_PROTEIN_RATIO);
					d.setFatRatio(DietPlanConstants.NON_VEG_FAT_RATIO);
					d.setCarbsRatio(DietPlanConstants.NON_VEG_CARBS_RATIO);
					d.setTotal(DietPlanConstants.NON_VEG_TOTAL);
				}

			}
		}

		return dietPlanRepository.save(d);
	}

	@Override
	public DietPlan getDietPlan(Long id) throws ResourceNotFoundException {

		return dietPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DietPlan Not found with id : " + id));
	}

	@Override
	public DietPlan updateDietPlan(DietPlan d, Long id) throws ResourceNotFoundException {
		DietPlan dietPlan = dietPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DietPlan Not found with id : " + id));
		
		if (d.getSlots().equalsIgnoreCase(DietPlanConstants.MORNING_MEAL)) {
			if (d.getFoodType().equalsIgnoreCase(DietPlanConstants.VEG)) {
				d.setProteinRatio(DietPlanConstants.VEG_PROTEIN_RATIO);
				d.setFatRatio(DietPlanConstants.VEG_FAT_RATIO);
				d.setCarbsRatio(DietPlanConstants.VEG_CARBS_RATIO);
				d.setTotal(DietPlanConstants.VEG_TOTAL);
			} else {
				d.setProteinRatio(DietPlanConstants.NON_VEG_PROTEIN_RATIO);
				d.setFatRatio(DietPlanConstants.NON_VEG_FAT_RATIO);
				d.setCarbsRatio(DietPlanConstants.NON_VEG_CARBS_RATIO);
				d.setTotal(DietPlanConstants.NON_VEG_TOTAL);
			}

		} else {
			if (d.getSlots().equalsIgnoreCase(DietPlanConstants.EVENING_MEAL)) {
				if (d.getFoodType().equalsIgnoreCase(DietPlanConstants.VEG)) {
					d.setProteinRatio(DietPlanConstants.VEG_PROTEIN_RATIO);
					d.setFatRatio(DietPlanConstants.VEG_FAT_RATIO);
					d.setCarbsRatio(DietPlanConstants.VEG_CARBS_RATIO);
					d.setTotal(DietPlanConstants.VEG_TOTAL);
				} else {
					d.setProteinRatio(DietPlanConstants.NON_VEG_PROTEIN_RATIO);
					d.setFatRatio(DietPlanConstants.NON_VEG_FAT_RATIO);
					d.setCarbsRatio(DietPlanConstants.NON_VEG_CARBS_RATIO);
					d.setTotal(DietPlanConstants.NON_VEG_TOTAL);
				}

			}
		}		
		
		return dietPlanRepository.save(d);
	}

	@Override
	public Boolean deleteDietPlan(Long id) throws ResourceNotFoundException {
		DietPlan dietPlan = dietPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DietPlan Not found with id : " + id));
		dietPlanRepository.delete(dietPlan);
		return true;

	}

	@Override
	public List<DietPlan> showAllDietPlan() {

		return dietPlanRepository.findAll();
	}

}
