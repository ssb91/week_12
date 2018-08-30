package qa.team3.springboot.database.hello.dvdRent.model;


import java.io.Serializable;


import java.util.Date;

import javax.persistence.*;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "dvd")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)

public class DvdRentDataModel implements Serializable {
		
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank
private String title;

private Integer price;

@Column(nullable = false, updatable = false)
@Temporal(TemporalType.TIMESTAMP)
@CreatedDate
private Date creationDate;

@Column(nullable = false)
@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate
private Date lastModified;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}



public void setPrice(Integer price) {
	this.price = price;
}

public Integer getPrice() {
	return price;
}

public Date getCreationDate() {
	return creationDate;
}

public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}

public Date getLastModified() {
	return lastModified;
}

public void setLastModified(Date lastModified) {
	this.lastModified = lastModified;
}


}
