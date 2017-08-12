package com.src.starters.Controller;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.starters.Entities.Student;
import com.src.starters.Model.StudentModel;



@RestController
public class StudentController {
	
	@RequestMapping("/Student/Signup/{password}/{name}/{gender}/{mail}/{age}")
	public  Student SignUp( @PathVariable String password , @PathVariable String name ,
			@PathVariable String  gender , @PathVariable String mail , @PathVariable int age) throws SQLException
	{
		StudentModel x =new StudentModel();
		Student result =x.AddStudent(password, name, gender, mail, age);
		return result;
	}
	
	@RequestMapping("/Student/Login/{password}/{mail}")
	public  Student Login(@PathVariable String password , @PathVariable String mail) 
	{
		StudentModel x =new StudentModel();
		Student y =new Student();
		try {
			y=x.GetStudent( password , mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return y;
		
	}
	
	@RequestMapping("/Student/Updatescore/{password}/{newscore}")
	public String updateScore(@PathVariable int newscore , @PathVariable String password ) throws SQLException
	{
		StudentModel x =new StudentModel();
		x.UpdateScore(newscore , password);
	    return "updated" ;	
		
	}
	
	@RequestMapping("/Student/Updatprofilepicture/{password}/{newimage}")
	public void updateProfilepicture(@PathVariable Image newimage ,@PathVariable String password )
	{
		StudentModel x =new StudentModel();
		x.UpdateProfilePicture(newimage,password);
	}
	
	@RequestMapping("/Student/get_notification/{student_mail}/{readed_or_not}")
    public ArrayList<String> Load_Notifications(@PathVariable String student_mail , @PathVariable int readed_or_not) throws SQLException
    {
    	ArrayList<String> Notifications =new ArrayList<String>();
    	StudentModel m=new StudentModel();
    	
    	m.Load_notification(Notifications ,student_mail , readed_or_not);
    	return Notifications ;
    }
}
