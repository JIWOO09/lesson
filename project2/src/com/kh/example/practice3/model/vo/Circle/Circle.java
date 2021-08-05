package com.kh.example.practice3.model.vo.Circle;


public class Circle {
	  
    private double PI = 3.14;
	private int radius = 1;
	  
	  public Circle () {}
	  
	  public void incrementRadius() {
		  //반지름 1 증가
		  this.radius++;
		  }
	  
	  public void getAreaOfCircle() {
		  //원의 넓이
		  //raidus * radius * PI
		  
		  System.out.println(this.radius * this.radius * this.PI);
	  }
	  public void getSizeOfCircle() {
		  //원의 둘레
		  //2 * PI * radius
		  System.out.println(2 * this.PI * this.radius);
		  
	  }
	  
 }	  