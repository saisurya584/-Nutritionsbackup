package com.cg.nutritions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nutritions.entity.WeightLog;

@Repository
public interface WeightLogRepository extends JpaRepository<WeightLog, Long> {

}
