package com.cource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controller.Topic;

@RestController
public class CourceController {
	
	@Autowired
	private CourceService courceService;
	
	@RequestMapping("/topics/{id}/cources")
	public List<Cource> getAll(@PathVariable String id) {
		return courceService.getAllCource(id);
	}
	
	@RequestMapping("/topics/{topicId}/cources/{id}")
	public Optional<Cource> getCourceById(@PathVariable String id) {
		return courceService.getCourceById(id);
		
	}
	
	
	//@RequestMapping(method = RequestMethod.POST,value = "/topics")
	@PostMapping("/topics/{topicId}/cources")
	public void addCource(@RequestBody Cource cource,@PathVariable String topicId) {
		cource.setTopic(new Topic(topicId,"",""));
		courceService.addCource(cource);
	}
	
	@PutMapping("/topics/{topicId}/cources/{id}")
	public void updateCource(@RequestBody Cource cource,@PathVariable String id,@PathVariable String topicId) {
		cource.setTopic(new Topic(topicId,"",""));
		courceService.updateCource( cource);
	}
	
	@DeleteMapping("/topics/{topicId}/cources/{id}")
	public void deleteCource(@PathVariable String id) {
		courceService.deleteCource(id);
	}

}
