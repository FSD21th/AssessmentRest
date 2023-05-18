package com.faddi.assessment.service;

import java.util.List;

import com.faddi.assessment.model.AssessmentModel;

public interface AssessmentService {

	public List<AssessmentModel> getList();
	
	public AssessmentModel findById(int id);
	
	public AssessmentModel insert(AssessmentModel assessmentModel);
	
	public AssessmentModel update(AssessmentModel assessmentModel, int id);
	
	public AssessmentModel delete(int id);
	
}
