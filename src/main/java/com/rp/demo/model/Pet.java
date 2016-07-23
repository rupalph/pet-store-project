package com.rp.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.common.base.Objects;
@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PET_ID")
	private long id;

	private String name;
	
	
	private long categoryId;
	
	@ElementCollection
	@Lob
	@Column( length = 100000 )
	private Set<String> photoUrls;
	
	//@OneToMany(targetEntity=Tag.class, fetch=FetchType.EAGER)
	private String tags;
	private String status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void copy(Pet pet) {
		this.name = pet.getName();
		this.categoryId = pet.getCategoryId();
		this.photoUrls = pet.getPhotoUrls();
		this.tags = pet.getTags();
		this.status = pet.getStatus();
		
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategory(long category) {
		this.categoryId = category;
	}
	
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
	public Set<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(Set<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String toString()
	{
		return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("categoryId", categoryId)
                .add("tags", tags)
                .add("status", status)
                .toString();
	}

}
