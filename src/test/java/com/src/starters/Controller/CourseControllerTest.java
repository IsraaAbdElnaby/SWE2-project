package com.src.starters.Controller;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.src.starters.Entities.Course;

import org.testng.Assert;

public class CourseControllerTest {

  @Test
  public void Create_Course() throws SQLException {
	  
	  CourseController c =new CourseController();
	 // Assert.assertEquals("Added",c.Create_Course("Science","Amr@yahoo" , "To Learn Basics of Science ") );
	  
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void Show_Courses() throws SQLException {
	  
	  CourseController c =new CourseController(); 
	  ArrayList<Course> courses = new ArrayList<Course>();
	  courses= c.Show_Courses();
	  
		//Assert.assertEquals(, Array.get(array, index));  
	  ///// put courses in the database /////////////////
	  
   // throw new RuntimeException("Test not implemented");
  }
}