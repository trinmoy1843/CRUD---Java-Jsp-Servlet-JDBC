package com.MyClass;

public class SQL_Query {
	static String insert = "INSERT INTO USER(NAME, EMAIL, CONTACT, PASSWORD) VALUES(?, ?, ?, ?)";
	static String display = "SELECT * FROM USER";
	
	static String id = "SELECT * FROM USER WHERE CONTACT = ?";
	static String name = "SELECT * FROM USER WHERE PASSWORD = ?";
	
	static String login_num = "SELECT * FROM USER WHERE CONTACT = ? AND PASSWORD = ?";
	static String login_id = "SELECT * FROM USER WHERE UID = ? AND PASSWORD = ?";
	
	static String upd_name = "UPDATE USER SET NAME = ? WHERE UID = ?";
	static String upd_email = "UPDATE USER SET EMAIL = ? WHERE UID = ?";
	static String upd_contact = "UPDATE USER SET CONTACT = ? WHERE UID = ?";
	static String upd_password = "UPDATE USER SET PASSWORD = ? WHERE UID = ?";
	
	static String del_profile_id = "DELETE FROM USER WHERE UID = ? AND PASSWORD = ?";
	static String del_profile_num = "DELETE FROM USER WHERE CONTACT = ? AND PASSWORD = ?";
}
