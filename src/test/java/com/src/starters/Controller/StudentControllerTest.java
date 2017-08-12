package com.src.starters.Controller;



import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.src.starters.Entities.Student;

public class StudentControllerTest {

//  @Test
//  public void Load_Notifications() {
//    //throw new RuntimeException("Test not implemented");
//  }

  @Test
  public void Login() {
	  String pass="20140077";
	  String mail ="amira@yahoo";
	  Student x =new Student();
	  StudentController c =new StudentController();
	  x=c.Login(pass, mail);
	  
	  Assert.assertEquals("amira",x.getName());
	  Assert.assertEquals("20140077",x.getPassword());
	  Assert.assertEquals("amira@yahoo",x.getMail());
	  Assert.assertEquals(21,x.getAge());
	  Assert.assertEquals("female",x.getGender());
	  Assert.assertEquals(20,x.getScore());
	  
    // throw new RuntimeException("Test not implemented");
  }

//  @Test
//  public void SignUp() throws SQLException {
//	  Student x =new Student();
//	  StudentController c =new StudentController();
//	  x=c.SignUp("2020", "amr tarek ", "male", "amr@yahoo", 29);
//	  
//	  Assert.assertEquals("amr_tarek ",x.getName());
//	  Assert.assertEquals("20200",x.getPassword());
//	  Assert.assertEquals("amr@yahoo",x.getMail());
//	  Assert.assertEquals(29,x.getAge());
//	  Assert.assertEquals("male",x.getGender());
//	  
//   // throw new RuntimeException("Test not implemented");
//  }
  

  @Test
  public void updateScore() throws SQLException {
	  
	  StudentController c =new StudentController();
	  Assert.assertEquals("updated",c.updateScore(40, "20120"));
    //throw new RuntimeException("Test not implemented");
  }
  
}
