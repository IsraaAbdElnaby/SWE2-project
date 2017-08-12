package com.src.starters.Entities;

import java.awt.Image;
import java.sql.Blob;

public class User {
	 String Name ;
	 String gender;
	 String mail,Password;
	 //Image profilePicture ;
	 int age;
     int score ;
	
	
	
	public void setName(String Name){
		this.Name=Name;
	}
	public void setScore(int  score){
		this.score=score;
	}
	
	public void setGender(String gender){
		this.gender=gender;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public void setMail(String mail){
		this.mail=mail;
	}
	
	public void setPassword(String Password){
		this.Password=Password;
	}
	
	/*public void setimage(Blob blob)
	{
		profilePicture=(Image) blob;
	}*/
	
	public String getName(){
		return Name;
	}
	
	public String getGender(){
		return gender;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getMail(){
		return mail;
	}
	
	public String getPassword(){
		return Password;
	}
	
	/*public Image getprofilepicture()
	{
		return profilePicture ;
	}*/
	
    public int getScore(){
        return score ;	
       }

}
