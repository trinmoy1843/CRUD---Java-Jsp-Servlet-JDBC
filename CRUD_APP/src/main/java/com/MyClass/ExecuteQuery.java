package com.MyClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery {
	static Connection con = CreateCon.getCon();
	static String query;
	static PreparedStatement pstm;
	static Statement stm;
	
	//insert into the database
	public static int insert(User obj) {
		query = SQL_Query.insert;
		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1,obj.name);
			pstm.setString(2, obj.email);
			pstm.setLong(3, obj.number);
			pstm.setString(4, obj.password);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//retrieving the name of the user
	public static String name(String password) {
		query = SQL_Query.name;
		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, password);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) return rs.getString("name");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "Nothing";
	}
	
	//retrieving the user id
	public static int user_id(long number) {
		query = SQL_Query.id;
		try {
			pstm = con.prepareStatement(query);
			pstm.setLong(1, number);
			ResultSet result = pstm.executeQuery();
			while(result.next())return result.getInt("uid");
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//logging in into the system
	public static boolean login(User obj) {
		if(obj.uid != 0) { //id is available
			query = SQL_Query.login_id;
			try {
				pstm = con.prepareStatement(query);
				pstm.setInt(1, obj.uid);
				pstm.setString(2, obj.password);
				ResultSet rs = pstm.executeQuery();
				return rs.next();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else { //number is available
			query = SQL_Query.login_num;
			try {
				pstm = con.prepareStatement(query);
				pstm.setLong(1, obj.number);
				pstm.setString(2,obj.password);
				ResultSet rs = pstm.executeQuery();
				return rs.next();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;	
	}
	
	//updating the name
	public static boolean upd_name(int uid, String name) {
		String query = SQL_Query.upd_name;
		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2,  uid);
			int n = pstm.executeUpdate();
			if(n>0) return true;
			else return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//updating the email
	public static boolean upd_email(int uid, String email) {
		String query = SQL_Query.upd_email;
		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setInt(2, uid);
			int n = pstm.executeUpdate();
			if(n>0) return true;
			else return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//updating the contact number
	public static boolean upd_contact(int uid, long number) {
		String query = SQL_Query.upd_contact;
		try {
			pstm = con.prepareStatement(query);
			pstm.setLong(1, number);
			pstm.setInt(2, uid);
			int n = pstm.executeUpdate();
			if(n>0) return true;
			else return false;
		}catch(Exception e) {
			return false;
		}
	}
	
	//updating the password
	public static boolean upd_password(int uid, String password) {
		String query = SQL_Query.upd_password;
		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, password);
			pstm.setInt(2, uid);
			int n = pstm.executeUpdate();
			if(n>0) return true;
			else return false;
		}catch(Exception e) {
			return false;
		}
	}
	
	//deleting a profile from the database
	public static boolean del_profile(User obj) {
		if(obj.uid == 0) {
			String query = SQL_Query.del_profile_num;
			try {
				pstm = con.prepareStatement(query);
				pstm.setLong(1, obj.number);
				pstm.setString(2, obj.password);
				int n = pstm.executeUpdate();
				if(n>0) return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			String query = SQL_Query.del_profile_id;
			try {
				pstm = con.prepareStatement(query);
				pstm.setInt(1, obj.uid);
				pstm.setString(2, obj.password);
				int n = pstm.executeUpdate();
				if(n>0) return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//display the database
	public static ResultSet display_table() {
		query = SQL_Query.display;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
