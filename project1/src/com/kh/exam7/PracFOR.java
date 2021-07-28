package com.kh.exam7;

import java.util.Scanner;

public class PracFOR {

	
	static Scanner sc = new Scanner(System.in);
	public static void ex1() {
		/*
		 * 정수값을 입력받아 1부터 입력받은 값까지 1씩 증가된 값을 출력 하는 코드 작성
		 * 예 : 정수입력 3
		 * 			1
		 *          2
		 *          3
		 */
		int unm;// 변수 선언 꼭꼭
		System.out.println("정수값 입력 : ");
		unm  = sc.nextInt(); sc.nextLine();
		
		
		for(int i = 1; i <= unm; i++) {
			System.out.println(i);
		}
			
} 
			
	
	public static void ex2() {
		/*
		 * 정수값을 입력받고 입력받은 값부터 1씩 감소된 값을 출력하는 코드 작성
		 * 
		 */
		int munm;
		System.out.println("정수값 입력 : ");
		munm = sc.nextInt(); sc.nextLine();
		
			for(int i = munm; i >= 1; i--) {
				System.out.println(i);
			}
			
		
		
		
	}
	public static void ex3() {
		/*
		 * 정수값을 입력 받을 때 지정된 범위의 입력값이 아닌 경우 최대 3번 다시
		 * 입력 받을 수 있도록 하는 코드 작성
		 * 지정 범위는 1 ~ 100
		 * 
		 */
		
		
	}
	
	
	public static void ex4() {
		
		
		
		
		
	}
	public static void ex5() {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {


			//ex1();
			//ex2();
			//ex3();
//			ex4();
//			ex5();
//			
	}

}
