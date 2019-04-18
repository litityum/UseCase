package usecase.githubrepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubRepoService {
	
	@Autowired
	private GithubRepoRepository githubRepoRepository;

	public List<GithubRepo> getUserRepos(String owner) {
		List<GithubRepo> githubRepos = new ArrayList<>();
		githubRepoRepository.findByOwner(owner).forEach(githubRepos::add);
		return githubRepos;
	}
	
	public void addUserRepos(String responseBody) {
		JSONParser parser = new JSONParser();
		JSONArray array;
		try {
			//System.out.println(responseBody);
			array = (JSONArray) parser.parse(responseBody);
			//System.out.println(array.size());
			for(int i = 0; i < array.size(); i++) {
				JSONObject json;
				json = (JSONObject) array.get(i);
				//System.out.println(json.get("id"));
				//System.out.println(json.get("name"));
				//System.out.println(((Map<Object, Object>)json.get("owner")).get("login"));
				@SuppressWarnings("unchecked")
				GithubRepo t = new GithubRepo(Long.toString((long)json.get("id")), (String)json.get("name"),(String)((Map<Object, Object>)json.get("owner")).get("login") );
				githubRepoRepository.save(t);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//System.out.println("sıkıntı var");
			e.printStackTrace();
		}
	}
	/*
	public void updateTopic(Topic topic, String id) {
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);			
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
	*/
}
