package com.kh.exam8;

import java.util.Scanner;

public class PrecArray {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void ex1 () {
		
		
		
		
		//길이가 10인 정수 배열을 선언하고 1 ~ 10까지의 값을 배열에 초기화하는 코드를 작성
		
		int [] iArr = new int [10];
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = i + 1; //초기화 하는법
			
			
		}
		//2. 초기화 (별도의 변수 활용)
		int val = 1;
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = val;
			val++;
		}
		
		//3. 초기화 (와일문)
				int i = 0;
				while (i < iArr.length) 
					iArr[i] = i + 1;
					i++;
		
	

		for( i = 0; i < iArr.length; i++) {
				System.out.println("iArr[" + i + "] -> " + i);
		}
		
	
		
	}
	public static void ex2 () {
		
		/* 
		 * 길이가 10인 정수 배열을 선언하고 짝수에 해당하는 값을 배열에 순차적으로 초기화하는 코드를 작성
         */
		
		
		int [] iArr = new int [10];
		
		//1.초기화
		int val = 2;
		for(int i = 0; i < iArr.length; i++) {
		 iArr[i] = val;
		 val += 2;
		 
		}	
		//2. 초기화 인덱스 활용
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = ( i + 1) * 2;
		}
		
		//3. 초기화 (와일문)
		int i = 0;
		while (i < iArr.length) {
			iArr[i] = (i + 1) * 2;
			i++;
		}
		
		for (i = 0; i < iArr.length; i++) {
		System.out.println("iArr[" + i + "]  -> " + iArr[i]);
		
		}
		
	}
	public static void ex3 () {
		
		/*
		 * 길이가 20인 정수 배열을 선언하고 홀수에 해당하는 값을 배열에 순차적으로 초기화하는 코드를 작성
		 * 단 99부터 역순으로 초기화
		 * 
		 * int[] iArr = new int [20];
		 * int[0] = 99; int[1] = 97;
		 * int[2] = 95; int[3] = 93;
		 * .....
		 * 
		 * 
		 */
		
		 
		int [] iArr = new int [20];
			
		//1.초기화 
		int val = 99;
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = val;
			val -= 2;
		}
		
		//2. 초기화
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = 99 - i * 2;
		}	
		
		
		//3. 초기화 (와일문)
				int i = 0;
				while (i < iArr.length) {
					iArr[i] = 99 - i * 2;
					i++;
		}
		
		//4. 초기화 역순으로
				for (i = iArr.length - 1; i >= 0; i--) {
					iArr[i] = 99 - i * 2;
				}			
				
		//5.초기화 (와일문)
				i = iArr.length -1;
				while (i >= 0) {
					iArr[i] = 99 - i * 2;
					i--;
		}
				
				
				
		for (i = 0; i < iArr.length; i++) {
				System.out.println("iArr[" + i + "] -> " +  iArr[i]);
		}	
				
	}
		
		
		
		
	public static void ex4 () {
		
		/*길이가 26인 정수 배열을 선언하고 아스키 문자 대문자를 순차적으로 초기화는 코드 작성
		 * 
		 */
		
		
		
		
		
		
		
	}
	
	
	public static void ex5() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 100 부터 배열의 크기만큼
		 * 초기화를 진행한다.
	     * 
		 */
		
	  int arrSize;
	  System.out.print(" 생성할 배열 크기 (정수) : ");
	  arrSize = sc.nextInt(); sc.nextLine();
	  
	  int[] iArr = new int[arrSize];
	  
	  //1.초기화
	 for (int i = 0; i < iArr.length; i ++) {
		 	iArr[i] = 100+i;
	 }
	  
	 for(int i = 0; i < iArr.length; i++) {
		 System.out.println("iArr[" + i + "]-> " + iArr[i]);
	 }
	 
	}



	public static void ex6() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 다시 사용자 입력을 이용하여
		 * 사용자가 직접 배열의 크기 만큼 초기화 할 수 있도록 한다.
		 * (생성 할 배열 타입은 문자열로 한다.)
		 */
		
		int arrSize;
		System.out.print("생성할 배열 크기 (정수) : ");
		arrSize =sc.nextInt(); sc.nextLine();
		
		String[] sArr = new String [arrSize];
		
		//1.초기화
		for (int i = 0; i < sArr.length; i ++) {
			System.out.print("초기값 입력 [" + i + "] : ");
		 	sArr[i] =sc.nextLine();
	 }
		
	  
	 for(int i = 0; i < sArr.length; i++) {
		 System.out.print("iArr[" + i + "]-> " + sArr[i]);
	 }	
		
}
	
	
	
	

	public static void ex7() {
		/*
		 * 2021년 7월에 한정하여 사용자 입력을 통해 일자 데이터를 입력 받고 해당하는 일자가
		 * 어떤 요일인지 알려주는 코드를 배열을 활용하여 작성한다.
		 */
		
		
		
		int day;
		String[] dayArr = new String [] {"수" ,"목", "금", "토", "일", "월", "화"};
		
		
		System.out.println("요일 입력 (1 ~ 31) : ");
		day = sc.nextInt(); sc.nextLine();
		
		//아래 긴 문장을 위에 배열을 이용하여 짧게 
		
		
		if(day >= 1 && day <= 31) {
			System.out.println(dayArr[day % 7] + "요일 입니다." );
			} else {
				System.out.println("1 ~ 31 사이의 값을 입력하세요. ");
			}
		
		
		
//			switch(day & 7) {
//				case 0:
//					System.out.println("수요일 입니다."); break;
//				case 1:
//				System.out.println("목요일 입니다."); break;
//				case 2:
//					System.out.println("금요일 입니다."); break;
//				case 3:
//					System.out.println("토요일 입니다."); break;
//				case 4:
//					System.out.println("일요일 입니다."); break;
//				case 5: 
//					System.out.println("월요일 입니다."); break;
//				case 6:
//					System.out.println("화요일 입니다."); 
//			}
//			
//			switch(day % 7 ) {
//			//여러 케이스를 작성.
//			case 3 : case 4:
//				System.out.println("주말입니다."); break;
//			default :
//					System.out.println("주중입니다.");
//			}
//		} else {
//			System.out.println("1 ~ 31 사이의 값을 입력하세요. ");
//		}
//		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
//		ex4();
		//ex5();
	//ex6();
		ex7();
	}

}
