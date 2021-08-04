package com.kh.exam1;

// 1.편의점에서 판매하는 커피에 상품에 대한 클래스를 작성
// 2.임의의 직업에 대한 클래스를 작성
// 멤버 메서드에 대해서는 구체화된 기능은 필요 없으며 이름만 작성
// public void 메서드명() 형식으로 
// 멤버 변수는 최소 5개
// 멤버 메서드는 최소 3개


 class coffee {
	 
	private String name;
	private String origin;
	private String company;
	private int price;
	private int ml;
	 
	 public void 뚜껑열기() {}
	 public void 뚜껑닫기() {}
	 public void 마시기() {}  //객체 커피에 관한 기능? 행동 같은
	 
	 // 메서드는 객체에 대한 이런 기능을 구체화 하는 
	 
		 
 }	 
 
 class 개발자 {
	 
	 private String 분야;
	 private String 사용언어;
	 private String 소속기업;
	 private int 연봉;
	 private int 연차;
	 
	 public void 휴가 () {}
	 public void 연차 () {}
	 public void 상여 () {}
	 
	 
	 
	 
 }


public class ClassPrac {

	public static void main(String[] args) {
			//만든 클래스를 사용할 때는 메인에 
		coffee c = new coffee();
		c.뚜껑열기();
		
		개발자 노예1 = new 개발자 ();
		노예1.상여();
		
	}
}

