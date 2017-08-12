package com.src.starters.Entities;

public class Game {
	 String gameName ;
	 String category ;
	 String courseName ;
	 String description;
	 int time ;
	 String teacher_mail;
	
	 public void setdescription(String des){
			this.description=des;
		} 
	 
	 public String getdescription(){
			return description;
		}
		
	 
	public void setName(String name){
		this.gameName=name;
	}
	
	public void setTeacher(String teacher){
		this.teacher_mail=teacher;
	}
	
	public String getName(){
		return gameName;
	}
	
	public String getTeacher(){
		return teacher_mail;
	}
	
	public void setCategory(String category){
		this.category=category;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setTime(int Time){
		this.time=Time;
	}
	
	public int getTime(){
		return time;
	}

	public void setCoursename(String coursename)
	{
		this.courseName=coursename ;
	}
	
    public String getCoursename()
	{
		return courseName ;
	}
	
	

}
