package dev.paie.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@RestController
@RequestMapping("/api/grades")
public class GradeApiController {

	@Autowired
	GradeRepository gradeRepo;

	@RequestMapping(method = RequestMethod.GET)
	// @ResponseBody
	public List<Grade> trouverTousLesGrades() {
		return gradeRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void insererGrade(@RequestBody Grade grade) {
		this.gradeRepo.save(grade);
	}

}
