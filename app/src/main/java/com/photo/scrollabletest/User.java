package com.photo.scrollabletest;

public class User {
	private String name;
	private String email;
	private String image;

	public User(String name, String email, String image) {
		this.name = name;
		this.email = email;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getImage() {
		return image;
	}
}
