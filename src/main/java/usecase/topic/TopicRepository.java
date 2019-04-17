package usecase.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
	public List<Topic> findByOwner(String owner);

	//getAllTopics()
	//getTopic(String  id)
	//updateTopic(Topic t)
	//delete topic(String id)
}
