package usecase.githubrepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GithubRepoRepository extends CrudRepository<GithubRepo, String> {
	
	public List<GithubRepo> findByOwner(String owner);

	//getAllTopics()
	//getTopic(String  id)
	//updateTopic(Topic t)
	//delete topic(String id)
}
