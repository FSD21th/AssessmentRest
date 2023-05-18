package com.faddi.assessment.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faddi.assessment.model.AssessmentModel;
import com.faddi.assessment.repository.AssessmentRepository;
import com.faddi.assessment.service.AssessmentService;

import io.micrometer.common.util.StringUtils;

@Service
public class AssessmentServiceImplement implements AssessmentService {

	@Autowired
	private AssessmentRepository assessmentRepository;
	
	public List<AssessmentModel> getList() {
		return this.assessmentRepository.findAll();
	}
	
	public AssessmentModel findById(int id) {
		AssessmentModel assessmentModel = null;
		/*
		 * Validation Try-Catch
		 * Error Handling
		 */
		try {
			assessmentModel = this.assessmentRepository.findById(id).orElseThrow(() -> new Exception("Assessment with id not found"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return assessmentModel;
	}
	
	public AssessmentModel insert(AssessmentModel assessmentModel) {
		/*
		 * Validation if model not null
		 * Error Handling
		 */
		AssessmentModel assessmentModels = new AssessmentModel();
		if(assessmentModel != null) {
			assessmentModels.setDescription(StringUtils.isNotEmpty(assessmentModel.getDescription()) ? assessmentModel.getDescription() : "");
			assessmentModels.setImage(StringUtils.isNotEmpty(assessmentModel.getImage()) ? assessmentModel.getImage() : "");
			assessmentModels.setRating(assessmentModel.getRating());
			assessmentModels.setTitle(StringUtils.isNotEmpty(assessmentModel.getTitle()) ? assessmentModel.getTitle() : "");
			assessmentModels.setCreated_at(new Date());
			assessmentModels.setUpdated_at(new Date());
			this.assessmentRepository.save(assessmentModels);
		}
		
		return assessmentModels;
	}
	
	public AssessmentModel update(AssessmentModel assessmentModel, int id) {
		AssessmentModel assessmentModels = null;
		/*
		 * Validation Try-Catch
		 * Error Handling
		 */
		try {
			assessmentModels = this.assessmentRepository.findById(id).orElseThrow(() -> new Exception("Assessment with id not found"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assessmentModels.setDescription(StringUtils.isNotEmpty(assessmentModel.getDescription()) ? assessmentModel.getDescription() : "");
		assessmentModels.setImage(StringUtils.isNotEmpty(assessmentModel.getImage()) ? assessmentModel.getImage() : "");
		assessmentModels.setRating(assessmentModel.getRating());
		assessmentModels.setTitle(StringUtils.isNotEmpty(assessmentModel.getTitle()) ? assessmentModel.getTitle() : "");
		assessmentModels.setUpdated_at(new Date());
		this.assessmentRepository.save(assessmentModels);
		
		return assessmentModels;
	}
	
	public AssessmentModel delete(int id) {
		AssessmentModel assessmentModel = null;
		/*
		 * Validation Try-Catch
		 * Error Handling
		 */
		try {
			assessmentModel = this.assessmentRepository.findById(id).orElseThrow(() -> new Exception("Assessment with id not found"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.assessmentRepository.delete(assessmentModel);
		
		return assessmentModel;
	}
	
}
