package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pojo.Topic;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("1","Spring","This is Spring"),
			new Topic("2","SpringBoot","This is SpringBoot"),
			new Topic("3","React","This is React")
			
			));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopicById(String id) {
		return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id,Topic topic) {
		for(int i =0; i< topics.size();i++) {
			Topic t =topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}

}
