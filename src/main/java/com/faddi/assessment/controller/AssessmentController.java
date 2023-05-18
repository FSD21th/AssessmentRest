package com.faddi.assessment.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faddi.assessment.model.AssessmentModel;
import com.faddi.assessment.service.AssessmentService;

import io.micrometer.common.util.StringUtils;

@RestController
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;
	
	@RequestMapping(path="/movies" , method=RequestMethod.GET)
	public List<AssessmentModel> getList() {
		return this.assessmentService.getList();
	}
	
	@RequestMapping(path="/movies/{id}", method=RequestMethod.GET)
	public AssessmentModel getById(@PathVariable("id") int id) {
		
		/*
		 * Test Unit
		 */
		assertNotNull(id);
		assertTrue(id == (int) id);
		
		return this.assessmentService.findById(id);
	}
	
	@RequestMapping(path="/movies", method=RequestMethod.POST)
	public AssessmentModel insert(@RequestBody AssessmentModel assessmentModel) throws Exception {
		
		/*
		 * Test Unit
		 */
		assertNotNull(assessmentModel);
		assertTrue(StringUtils.isNotEmpty(assessmentModel.getDescription()));
		assertTrue(StringUtils.isNotEmpty(assessmentModel.getTitle()));
		assertTrue(StringUtils.isNotEmpty(assessmentModel.getImage()));
		assertTrue(assessmentModel.getRating() == (float) assessmentModel.getRating());
		
		return this.assessmentService.insert(assessmentModel);
	}
	
	@RequestMapping(path="/movies/{id}", method=RequestMethod.PATCH)
	public AssessmentModel update(@RequestBody AssessmentModel assessmentModel, @PathVariable("id") int id) {
		
		/*
		 * Test Unit
		 */
		assertNotNull(assessmentModel);
		assertNotNull(id);
		assertTrue(id == (int) id);
		assertTrue(StringUtils.isNotEmpty(assessmentModel.getDescription()));
		assertTrue(StringUtils.isNotEmpty(assessmentModel.getTitle()));
		assertTrue(StringUtils.isNotEmpty(assessmentModel.getImage()));
		assertTrue(assessmentModel.getRating() == (float) assessmentModel.getRating());
		
		return this.assessmentService.update(assessmentModel, id);
	}
	
	@RequestMapping(path="/movies/{id}", method=RequestMethod.DELETE)
	public AssessmentModel delete(@PathVariable("id") int id) {
		
		/*
		 * Test Unit
		 */
		assertNotNull(id);
		assertTrue(id == (int) id);
		
		return this.assessmentService.delete(id);
	}
	
}
