package com.kh.example.practice1.model.vo.Member;

public class Member {
	
		private String memberId;
		private String memberPwd;
		private String memberName;
		private int age;
		private char gender;
		private String phone;
		private String email;
		 
		
		
		 public Member() {} //생성자
		 
		 public void changeName(String name) {
			 this.memberName = name;
		 } //+ 표시는 퍼블릭
		 public void prinntName() {
			 System.out.println(this.memberName);
		 }		   
}
              