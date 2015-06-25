package org.hadoop.jobs.controllers;

import java.util.List;

import org.hadoop.jobs.dao.JobHistoryService;
import org.hadoop.jobs.objects.MrJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	JobHistoryService jobHistoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "Please visit:  <a href=\"/jobs\">JOBS</a>";
	}

	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ResponseEntity<List<MrJob>> testJobClient() {
		return new ResponseEntity<>(jobHistoryService.getAllJobs(),
				HttpStatus.OK);
	}

}
