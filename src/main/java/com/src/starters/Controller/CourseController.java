package com.src.starters.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.starters.Entities.Course;
import com.src.starters.Model.CourseModel;

@RestController
public class CourseController 
{
	@RequestMapping("/Teacher/createcourse/{cname}/{teachermail}/{objective}")
	public String Create_Course(@PathVariable String cname ,@PathVariable String teachermail ,@PathVariable String objective   ) throws SQLException
	{
		CourseModel m = new CourseModel();
		m.Addcourse(cname ,teachermail , objective);
		return "Added" ;
	}
	
	@RequestMapping("/showcourses")
	public ArrayList<Course> Show_Courses() throws SQLException
	{
		ArrayList<Course> C=new ArrayList<Course>();
		CourseModel m =new CourseModel();
		m.LoadCourses(C);
		return C;	
	}
}
