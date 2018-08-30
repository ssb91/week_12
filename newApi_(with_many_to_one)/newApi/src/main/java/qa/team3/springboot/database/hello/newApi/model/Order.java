package qa.team3.springboot.database.hello.newApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Orders")
	

public class Order {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotNull
private String title;

@NotNull
@Lob
private String description;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name =  "person_id", nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIgnore
private NewApiDataModel person;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public NewApiDataModel getPerson() {
	return person;
}

public void setPerson(NewApiDataModel person) {
	this.person = person;
}


}

