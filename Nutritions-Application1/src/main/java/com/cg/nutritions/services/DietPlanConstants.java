package com.cg.nutritions.services;

import org.springframework.stereotype.Component;

@Component
public class DietPlanConstants {

	//food type
	static String VEG = "veg";
	static String NONVEG = "non veg";
	// slots
	static String MORNING_MEAL = "morning meal";
	static String EVENING_MEAL = "evening meal";

	//veg
	static double VEG_PROTEIN_RATIO = 3.2;
	static double VEG_FAT_RATIO = 4.3;
	static double VEG_CARBS_RATIO = 2.2;
	static double VEG_TOTAL = 9.7;
	
	//non veg
	static double NON_VEG_PROTEIN_RATIO=4.5;
	static double NON_VEG_FAT_RATIO=4.8;
	static double NON_VEG_CARBS_RATIO = 7.5;
	static double NON_VEG_TOTAL=16.8;
	

}
