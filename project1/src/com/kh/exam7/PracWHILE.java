package com.kh.exam7;

import java.util.Scanner;

public class PracWHILE {
		
		Scanner sc = new Scanner(System.in);
		
		public static void ex1() {
			/*
			 * 영문자 소문자 a ~ z 출력
			 * a, b, c, ~ z
			 */
			
		for(char c = 'a'; c <= 'z'; c++) {
			System.out.print(c);
			
			if(c != 'z') {
				System.out.print(", ");
			}
		}
		System.out.println("\nWhile 문으로 출력한 결과");
		
		char c = 'a';
		while (c <= 'z') {
			System.out.print(c);
			
			if(c != 'z') {
				System.out.print(", ");
			}
			c++;	
		}
		
		
		System.out.println("\nDo~While 문으로 출력한 결과");
		c = 'a';
		
		do {
			System.out.print(c);
			
			if(c != 'z') {
				System.out.print(", ");
			}
			c++;	
		} while(c <= 'z');
	}
		
	


		
		public static void ex2() {
			
			/* 
			 * 영문자 대문자를 역순으로 
			 */
			//'Z' ~ 'A'; 문자 1개씩 감소 정수 값 1개씩 감소
			
			for(char c = 'Z'; c >= 'A' ; c-- ) {
				System.out.print(c);
				
				if ( c != 'A') {
				System.out.print(", ");
				}
			}
			
			char c ='Z';
			while (c >= 'A') {
				System.out.print(c);
			
			if (c != 'A') {
				System.out.print(", ");
			} 
			c--;
			}

		} 
		
			
			
		
		
		
		
		
		
		
		public static void ex3() {
			/*
			 * 다음과 같이 출력
			 * 1   2   3   4   5
			 * 6   7   8   9   10
			 * 11  12  13  14  15 
			 * 16  17  18  19  20
			 */
			System.out.println("중첩 반복을 사용하지 않고 출력");
			for(int i = 1; i <= 20; i++) {
				System.out.print(i +"\t ");
				if(i % 5 == 0) {
					System.out.print("\n");
				} else {
					System.out.print("\t");
				}
			
			}
			
			System.out.println("while문으로 출력");
			
			int i = 1;
			while (i <= 20) {
				System.out.print(i);
				
				if(i % 5== 0) {
					System.out.print("\n");
				} else {
					System.out.print("\t");
				} 
				i++;	
			}
			
			System.out.println("중첩 반복을 사용하여 출력");
			int num = 1;
			for(int x = 1; x <= 4; x++) {
				for(int y = 1; y <= 5 ; y++) {
					System.out.print(num + "\t");
					num++;
			
			  }
			System.out.println();
			}
			
			System.out.println("while 중첩반복을 사용하여 출력");
			
			num = 1;
			int x = 1;
			while (x <= 4) {
				int y = 1;
			while (y <= 5){
				System.out.print(num + "\t");
				num++;
				y++;
				}
			System.out.println();
			x++;
		}
		
}
	
		
		
		
		public static void ex4() {
			
			/*
			 * 사용자가 입력한 정수값 범위에 해당하는 값만 출력하시오
			 * 예 - 최소값 : 11
			 * 	 최대값 : 99
			 * 	열 수 : 10
			 * 
			 * 11  12  13  14  15  16  17  18 19 20 
			 * 21  22  23  24  25  26  27  28  29  30
			 * ...
			 * 
			 * 91  92  93  94  95  96  97  98  99 100
			 */ 
			
		}
		public static void ex5() {}
		public static void ex6() {}
		public static void ex7() {}
		
		
		
		
		
		
	


	public static void main(String[] args) {
		
		//ex1();
		//ex2();
		ex3();
//		ex4();
//		ex5();
//		ex6();
//		ex7();
	}

}