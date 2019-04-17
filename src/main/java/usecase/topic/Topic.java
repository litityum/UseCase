package usecase.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	private String id;
	private String name;
	private String owner;
	
	public Topic() {
		super();
		this.id = "";
		this.name = "";
		this.owner = "";
	}
	
	public Topic(String id, String name, String owner) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setDescription(String owner) {
		this.owner = owner;
	}
}
