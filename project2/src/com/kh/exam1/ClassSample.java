package com.kh.exam1;

class Kukmin { //국민이라는 클래스를 추상화하는 작업
	 String pNo;
	 String name;
	 char gender;
	 String adderss;
	 String phone;
	 int age; 
	//추상화된 객체들로 기능을 구현하기 위한 코드를 작성한다
	 
	 
	  public void method () {
		    name = "서지우";
			pNo ="900000-2000000";
			gender = 'w';
			adderss= "인천 광역시";
			phone= "010-1234-5678";
			age = 32;
  }
	  
}


public class ClassSample {

	public static void main(String[] args) {
		Kukmin Kim = new Kukmin();
		Kim.method();
		
		
		
		
		
	}

}
