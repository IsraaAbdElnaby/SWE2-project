package com.src.starters.Model;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;

import com.mysql.jdbc.PreparedStatement;
import com.src.starters.Entities.Student;

public class StudentModel {
	
	
	public Student AddStudent( String password , String name ,String gender , String mail , int age ) throws SQLException
	{
		/////////// handel the dupliacate
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		conn.statement= (PreparedStatement) conn.connection.prepareStatement("insert into student (password,name,gender,mail,age) VALUES (?, ?, ?,?, ?)");
		conn.statement.setString(1, password);
		conn.statement.setString(2,name);
		conn.statement.setString(3,gender);
		conn.statement.setString(4,mail);
		conn.statement.setInt(5,age);	
		conn.statement.executeUpdate();
		conn.statement.close();
		conn.connection.close();
		
		Student x=new Student();
		x.setName(name);
		x.setAge(age);
		x.setGender(gender);
		x.setMail(mail);
		x.setPassword(password);
		return x;
		
	}
	
	public Student GetStudent( String password , String mail) throws SQLException
	{
        Student x =new Student();
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		
		String sql ="SELECT * FROM student where password=? and mail=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, password);
		conn.statement.setString(2, mail);
		ResultSet result=conn.statement.executeQuery();
		
		if(result.next())
		{
			//x.setimage(result.getBlob("profilepicture")) ;
			x.setPassword(result.getString("password"));
			x.setMail(result.getString("mail"));
			x.setAge(result.getInt("age"));
			x.setGender(result.getString("gender"));
			x.setName(result.getString("name"));
			x.setScore(result.getInt("score"));
			
		}
		conn.statement.close();
		conn.connection.close();
		return x;
		
	}
	
	public void UpdateScore(int score , String password) throws SQLException
	{
		DBConnection conn =new DBConnection();
        conn.Connectiontomysql();
		
		String sql ="update student set score=? where password=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setInt(1, score);
		conn.statement.setString(2, password);
		conn.statement.executeUpdate();
		conn.statement.close();
		conn.connection.close();
	}

	public void UpdateProfilePicture(Image x , String password )  ///// to be continue //////
	{
		
	}
	
	public void Load_notification(ArrayList<String> Notifications ,String student_mail , int readed_or_not) throws SQLException
	{	
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		
		String sql ="SELECT notification FROM notifications where s_mail=? and readed_or_not=? ";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, student_mail);
		conn.statement.setInt(2, readed_or_not);
		
		ResultSet result=conn.statement.executeQuery();
		String n ;
		
			while(result.next())
			{
				n=result.getString("notification");
				Notifications.add(n);
			}	
	}

}
