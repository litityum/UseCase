package usecase.topic;

import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/import/{id}")
	public String importer(@PathVariable String id) {
		ResponseEntity<String> response
		  = restTemplate.getForEntity("https://api.github.com/users/" + id + "/repos", String.class);
		topicService.addTopic(response.getBody());		
		return "Bence Başardık";
	}
	
	@RequestMapping("/search/{id}")
	public List<Topic> search(@PathVariable String id) {
		return topicService.getAllTopics(id);
	}
	/*
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST, value ="/topics")
	public void addTopic(@RequestBody Topic topic) {
		//topicService.addTopic(topic);
	}
	@RequestMapping(method=RequestMethod.PUT, value ="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	*/
}
