package com.kh.exam7;

import java.util.Scanner;

public class PracWHILE {
		
	
	
	static Scanner sc = new Scanner(System.in);
		
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
			
			int min, max, row;
			
			System.out.print("최소값 입력 : ");
			min = sc.nextInt(); sc.nextLine();
			
			System.out.print("최대값 입력 : ");
			max = sc.nextInt(); sc.nextLine();
			
			System.out.print("열 수  : ");
			row = sc.nextInt(); sc.nextLine();
			
			
			int cnt = 0;
			for(int i = min; i <= max; i++) {
				System.out.print(i);
				cnt += 1;
				
				if(cnt == row) {
					System.out.print("\n");
					cnt = 0;
				} else {
					System.out.print("\t");
				}
				
				
			}
				
			
		}
		public static void ex5() {
			
			/*
			 * 100~ 999 범위에 해당하는 배수 값을 출력
			 * 출력할 배수값은 사용자 입력을 통해 알아낸다
			 * 
			 * 배수값 : 13
			 * 
			 * 104  117  130  143 156---- 5개씩 끊어서
			 * 
			 */
			int num;
			
			System.out.print("배수 값 입력 : ");
			num = sc.nextInt(); sc.nextLine();
			
			int cnt = 0;
			for(int i = 100; i <= 999;) {
				if ( i % num == 0) {
				System.out.print(i);
				cnt += 1;
			
				if(cnt % 5 == 0) {
					System.out.print("\n");
			} else {
				System.out.print("\t");
			 }
				i += num;
	 	  } else {
	 		  i++;
	 	  }
		}
	}
		public static void ex6() {
		
		/*
		 * 사용자로 부터 임의의 문자열을 입력받은 후 
		 * a, e, i, o, u, 문자가 얼마나 포함되어 있는지 확인하는 코드를 작성한다
		 * 
		 * tip 사용자가 입력한 문자열의 문자를 탐색하기 위해 .charAt(index) 메서드를 활용한다
		 * tip 문자열의 길이를 알기 위해 .length() 메서드를 활용
		 * 
		 */
		
		String text;
		System.out.print("문자열 입력 : ");
		text = sc.nextLine(); 
		
		System.out.print(" 입력한 문자열의 길이 : " + text.length());
	
		int cnt = 0;
		for(int i =  0; i < text.length(); i++) {
			switch(text.charAt(i)) {
			case 'a' :
			case 'e' :
			case 'i' :
			case 'o' :
			case 'u' :
				cnt += 1;
				}
			System.out.println(i +  " : " + text.charAt(i));
		}
		System.out.println("a, e, i, o, u 문자가" + cnt + "개 있습니다.");
	}
		
		//인덱스는 0부터 셈 글자수와 출력하는 코드 숫자가 안맞으면 인덱스 벗어났다고 함 그래서 렝스(글자수)를 쓰는것
		
//		System.out.println(text.charAt(0));
//		System.out.println(text.charAt(1));
//		System.out.println(text.charAt(2));
//		System.out.println(text.charAt(3));
//		System.out.println(text.charAt(4));
		
			
			
			
			
		
		
		
		
		public static void ex7() {}
		
		
		
		
		
		
	


	public static void main(String[] args) {
		
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		ex6();
//		ex7();
	}

}