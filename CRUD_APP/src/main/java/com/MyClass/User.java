package com.MyClass;

public class User {
	
	String name, email, password, new_pass;
	long number;
	int uid;
	
	public User(String name, String email, long number, String password){
		this.name = name;
		this.email = email;
		this.number = number;
		this.password = password;
	}
	
	public User(int uid, String password) {
		this.uid = uid;
		this.email = null;
		this.number = 000l;
		this.password = password;
	}
	
	public User(long number, String password) {
		this.uid = 0;
		this.email = null;
		this.number = number;
		this.password = password;
	}
	
}
