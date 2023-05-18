package com.faddi.assessment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faddi.assessment.model.AssessmentModel;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentModel, String> {

	public Optional<AssessmentModel> findById(int id);
	
	public List<AssessmentModel> findAll();
	
	
}
