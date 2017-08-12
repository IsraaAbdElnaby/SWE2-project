package com.src.starters.Model;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.src.starters.Entities.Student;
import com.src.starters.Entities.Teacher;

public class TeacherModel {
	
	
	public String AddTeacher(String password , String name ,String gender , String mail , int age ) throws SQLException
	{
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		conn.statement= (PreparedStatement) conn.connection.prepareStatement("insert into teacher (password,name,gender,mail,age) VALUES (?, ?, ?,?, ?)");
		conn.statement.setString(1, password);
		conn.statement.setString(2,name);
		conn.statement.setString(3,gender);
		conn.statement.setString(4,mail);
		conn.statement.setInt(5,age);	
		conn.statement.executeUpdate();
		conn.statement.close();
		conn.connection.close();
		
		return "Added";
		
	}
	
   public Teacher GetTeacher(String password , String mail) throws SQLException
	{
		Teacher x =new Teacher();
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		
		String sql="SELECT * FROM teacher where password=? and mail=?" ;
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, password);
		conn.statement.setString(2, mail);
		ResultSet result=conn.statement.executeQuery();

		if(result.next())
		{
			//x.setimage(result.getBlob("profilepicture"));
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
	
	public void UpdateScore(int score,String password) throws SQLException
	{
		DBConnection conn =new DBConnection();
        conn.Connectiontomysql();
		
		String sql ="update teacher set score=? where password=?";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setInt(1, score);
		conn.statement.setString(2, password);
		conn.statement.executeUpdate();
		conn.statement.close();
		conn.connection.close();
	}
	
	
	public void UpdateProfilePicture(Image x , String password ) //// to be continue //////
	{
		
	}
	
	public String add_collaborator(String game_name , String t1_mail , String t2_mail ) throws SQLException
	{
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		
		String sql="SELECT mail_of_teacher1 FROM games where gamename=? " ;
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, game_name);
		ResultSet result=conn.statement.executeQuery();
		
		if(result.next())
		{
			if(t1_mail.equals(result.getString("mail_of_teacher1")))
			{
				conn.statement= (PreparedStatement) conn.connection.prepareStatement("insert into games (mail_of_teacher2) VALUES (?)");
				conn.statement.setString(1, t2_mail);
				conn.statement.executeUpdate();
				conn.statement.close();
				conn.connection.close();
				return "Added";
			}	
		}
			return "Can't be add ";
	}

	public void Load_Notifications(ArrayList<String> Notifications ,String teacher_mail , int readed_or_not) throws SQLException
	{
		DBConnection conn=new DBConnection();
		conn.Connectiontomysql();
		
		String sql ="SELECT notification FROM notifications where t_mail=? and readed_or_not=? ";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(sql);
		conn.statement.setString(1, teacher_mail);
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
