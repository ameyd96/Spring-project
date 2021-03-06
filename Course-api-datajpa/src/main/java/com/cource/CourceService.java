package com.cource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourceService {
	
	@Autowired
	private CourceRepository courceRepository;

	
	public List<Cource> getAllCource(String id) {
		//return topics;
		List<Cource> topics = new ArrayList<>();
		courceRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Cource> getCourceById(String id) {
		//return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courceRepository.findById(id);
	}
	
	
	public void addCource(Cource cource) {
		//topics.add(topic);
		courceRepository.save(cource);
	}
	
	public void updateCource(Cource topic) {
//		for(int i =0; i< topics.size();i++) {
//			Topic t =topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		courceRepository.save(topic);
	}

	public void deleteCource(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courceRepository.deleteById(id);
		
	}

}
