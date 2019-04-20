package usecase.githubrepo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GithubRepos")
public class GithubRepo {
	@Id
	@Column(name ="ID_REPO")
	private String id;
	@Column(name ="Repo_Name")
	private String name;
	@Column(name = "Owner_Name")
	private String owner;
	
	public GithubRepo() {
		super();
		this.id = "";
		this.name = "";
		this.owner = "";
	}
	
	public GithubRepo(String id, String name, String owner) {
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
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
