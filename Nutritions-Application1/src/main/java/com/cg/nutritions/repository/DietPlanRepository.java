package com.cg.nutritions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nutritions.entity.DietPlan;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {

}
