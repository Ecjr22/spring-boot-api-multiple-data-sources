package com.carmona.springboot.springbootapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	private String gender;
	
	private String age;
	
	@Column(name = "favorite_color")
	private String favoriteColor;

	public Person() {
		
	}

	public Person(String firstName, String gender, String age, String favoriteColor) {
		this.firstName = firstName;
		this.gender = gender;
		this.age = age;
		this.favoriteColor = favoriteColor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

	@Override
	public String toString() {
		return "Person [Id=" + id + ", firstName=" + firstName + ", gender=" + gender + ", age=" + age
				+ ", favoriteColor=" + favoriteColor + "]";
	}
	
}
