package com.kh.exam7;

public class LoopStatement1 {

	public static void main(String[] args) {

		//sample1();
		//sample2();
		//sample3();
		//sample4();
		sample5();
		
	}

	
	
	public static void sample1() {
		
		int i =  1;
		while (i <= 5) {
			System.out.println(i + "번째 반복");
			i++;
		}	
	}
	
	
	public static void sample2 () {
		
		int i = 5;
		while (i >= 1) {
			System.out.println( i + "입니다");
			i--;
		}		
	}
	
	
	public static void sample3() {
	
		
		while(true) {
			System.out.println("트루를 쓰면 무한 반복 ");
		
			}
	
	}
	
	
	
	public static void sample4() {
	
		int i = 1;
	
	while(true) {
		System.out.println("트루를 쓰면 무한 반복 , 반복문 안에 종료 조건을 만들어서 사용");
		if (i == 1) {
			break; //무한반복 종료됨 
			
		}
     
	}
 	
 }
	
	public static void sample5() {
		
		int num;
		do {
			System.out.println("일단 한번은 실행 한다. ");
			num = 10;
		} while (num < 10);
		System.out.println("반복 끝");
		
	}
	
	
	
}