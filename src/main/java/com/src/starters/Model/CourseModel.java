package com.src.starters.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.src.starters.Entities.Course;

public class CourseModel {
	
	public void LoadCourses(ArrayList<Course> c) throws SQLException
	{
		Course x ;
		DBConnection conn=new  DBConnection();
		conn.Connectiontomysql();
		String Q="SELECT * FROM course";
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(Q);
		ResultSet result=conn.statement.executeQuery(Q);
		while(result.next())
		{
			x =new Course();
			x.setCoursename(result.getString("coursename"));
			x.setCourse_teacher_mail(result.getString("teachermail"));//////////////////
			x.setCourse_objective(result.getString("objective"));
			c.add(x);
		}
		
	}
	
	public void  Addcourse(String cname , String teachermail  , String objective) throws SQLException
	{
		DBConnection conn=new  DBConnection();
		conn.Connectiontomysql();
		String Q="insert into course (coursename,teachermail ,objective) VALUES (?, ?, ?)" ;
		conn.statement= (PreparedStatement) conn.connection.prepareStatement(Q);
		conn.statement.setString(1, cname);
		conn.statement.setString(2, teachermail);
		conn.statement.setString(3,objective);
		conn.statement.executeUpdate();
		conn.statement.close();
		conn.connection.close();
        
	}
	

}