package com.kh.exam5;


 class Other {
	 int x;
	 private int y;
	 
	 public Other() {}
	 
	 public Other(int x) {
		 this.x = x;
	 }
	 
	 
	 //매개변수 명과는 관계없이 타입이int로 동일하기 때문에 에러남
	 // public Other(int y) {
	 // this.y = y;
	 // this.x = x;
	 // }
	 
	// public Other(int y, int x) {
	// this.y = y;
	// this.x = x;
	// }

	 
	 public Other(int x, int y) {
	
	 
		 this.x = x;
		 this.y = y; //이름이 같을 때는 this를 붙여야 구별이 가능
	 
	 }
	 public int getY() {
		 return this.y; //private로 가려진 y를 보기 위한
	 }
 }
	 

public class SampleClass {

	public static void main(String[] args) {
		Other oth1 = new Other();
		Other oth2 = new Other(10, 20); // x, y 값

	System.out.println(oth1.x + "|" + oth2.x);
	System.out.println(oth1.getY() + "|" + oth2.getY());
	
	}

}
