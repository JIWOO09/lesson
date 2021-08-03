package com.kh.exam8;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDate {

	
	static Scanner sc = new Scanner(System.in);
	
	public static void sample1() {
		
		//배열 선언  > 자료형 [] 배열명 ;
		//배열 할당 자료형[] 배열명 =  new 자료형[]배열크기
								// 참조 주소를 새로 형성하는것 new (배열크기에 맞는 크기를 형성해주세염)
								//ex int arr[] = new int [3]; > int(4바이트)가 들어가게 끔 3만큼 (0부터니까 0123) 공간 주셈
								// 오른쪽꺼 왼쪽으로 할당하기 = 는 같은 아님 대입하는거 (박스안에 넣는거)
		
		int [] iArr  = new int [5];
		//정수 배열에 접근
		System.out.println(iArr[0]);
		System.out.println(iArr[1]);
		System.out.println(iArr[2]);
		System.out.println(iArr[3]);
		System.out.println(iArr[4]);
		
		
	}
	
	
	public static void sample2() {
		
		
		int [] iArr = new int[5];
		//반목문 사용하여 정수배열에 접근
		for(int i = 0; i < iArr.length; i++) {  
		//i = 0은 인덱스 0부터 시작해서 배열의 길이 보다 작을때 < 까지 반복하는 의미의 for문 
			System.out.println(iArr[i] + " ");

		
		}
				
	}		
		
	public static void sample3() {
		
		//선언과 동시에 초기화
		int [] iArr  = {1, 2, 3, 4, 5}; //초기화 하면 자동 배열 할당
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}	
		
	}	
				
 
	public static void sample4() {
		//선언 후 초기화

		int [] iArr = new int[5];
		
		//초기화를 위해 반복문 사용
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
	} 
	
	
	
	
	public static void sample5 () {
		
		boolean [] boolArr  = new boolean[] {true, false};
		byte [] bArr   = {1, 2, 3, 4, 5};
		char [] cArr  = {'a', 'b', 'c'}; //프린트 형태에서 char 형식이 있기 때문에 제대로 출력함
		double [] dArr  = new double [] {1.0, 2.0, 3.0};
		String [] sArr = new String[] {"hello", "안녕하세요"};
		
		
		for(int i = 0; i < boolArr.length; i++) {
			System.out.print(i + " : " +boolArr[i] + " "); //인덱스 번호까지 출력하는것
		}
		
		System.out.println();
		
		for(int i = 0; i < bArr.length; i++) {
			System.out.print(i + " : " +bArr[i] + " "); 
		}
		System.out.println();
		
		for(int i = 0; i < cArr.length; i++) {
			System.out.print(i + " : " +cArr[i] + " "); 
		}
		System.out.println();
		
		for(int i = 0; i < dArr.length; i++) {
			System.out.print(i + " : " +dArr[i] + " "); 
		}
		System.out.println();
		
		for(int i = 0; i < sArr.length; i++) {
			System.out.print(i + " : " +sArr[i] + " "); 
		}
				
	}	
//		System.out.println(boolArr);
//		System.out.println(cArr);
//		System.out.println(dArr);
//		System.out.println(dArr);
//		
		
		
		public static void sample6() {
			
			//배열 복사
			int x1 = 10;
			int x2 = x1;
			System.out.println("x1:" + x1 + "|x2:" + x2);
		
			x1 = 15;
			x2 = 25;
			System.out.println("x1:" + x1 + "|x2:" + x2);
			
			System.out.println("배열 복사 (얇은 복사)");
			
			int[] iArr1 = new int[] {1,2,3,4};
			int[] iArr2 = iArr1;
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("iArr1[" + i +"];" + iArr1[i] + "|iArr2[" + i +"]:");
			}
			
			System.out.println("배열 복사 후 값 변경");
		
			
			iArr1[0] = 15;
			iArr2[3] = 25;
			for(int i = 1; i <iArr1.length; i++) {
				System.out.println("iArr1[" + i +"]:" + iArr1[i] + "|iArr2[" + i + "]; + iArr2[i]");
			}
			
			System.out.println(" 참조값 확인");
			System.out.println("iArr1 참조값 : " + iArr1);
			System.out.println("iArr2 참조값 : " + iArr2);
	}
	
	
		public static void sample7() {
			
			//배열의 깊은 복사 방법
			
			int[] iArr1 = new int[] {1,2,3,4};
			int[] iArr2 = new int[iArr1.length];
			
			for(int i = 0; i < iArr1.length; i++) {
				iArr2[i] = iArr1[i];
			}
			
			for(int i = 0; i < iArr1.length; i++) {
				
			}
			
		}
		
		
		public static void sample8() {
			// 깊은 복사를 사용하여 배열의 크기 늘리기.
			int[] iArr1 = new int[] {1, 2, 3, 4};
			
			System.out.println("-----배열의 크기를 늘리기 전-----");
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("iArr1[" + i + "]:" + iArr1[i]);
			}
			
			int[] iArr2 = new int[iArr1.length + 1];
			for(int i = 0; i < iArr1.length; i++) {
				iArr2[i] = iArr1[i];
			}
			
			iArr1 = iArr2;
			iArr1[iArr1.length - 1] = 5;	// 마지막 index에 값 저장
			
			System.out.println("-----배열의 크기를 늘린 후-----");
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("iArr1[" + i + "]:" + iArr1[i]);
			}
				
		}
		public static void sample9() {
			// 깊은 복사를 사용하여 배열의 크기 줄이기.
			int[] iArr1 = new int[] {1, 2, 3, 4};
			
			System.out.println("-----배열의 크기를 줄이기 전-----");
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("iArr1[" + i + "]:" + iArr1[i]);
			}
			
			int[] iArr2 = new int[iArr1.length - 1];
			for(int i = 0; i < iArr2.length; i++) {
				iArr2[i] = iArr1[i];
			}
			
			iArr1 = iArr2;
			
			System.out.println("-----배열의 크기를 줄인 후-----");
			for(int i = 0; i < iArr1.length; i++) {
				System.out.println("iArr1[" + i + "]:" + iArr1[i]);
			}
		}
		
		public static void sample10() {
			int[] iArr = new int[0];
			int num;
			
			while(true) {
				System.out.print("정수 입력(-1 입력하면 종료) : ");
				num = sc.nextInt();	sc.nextLine();
				
				if(num != -1) {
					int[] copyArr = new int[iArr.length + 1];
					
					//               원본   원본복사위치    복사본     복사본복사위치 복사할길이(원본길이)
					System.arraycopy(iArr, 0,          copyArr, 0,        iArr.length);
//					for(int i = 0; i < iArr.length; i++) {
//						copyArr[i] = iArr[i];
//					}
					iArr = copyArr;
					
					iArr[iArr.length - 1] = num;
					System.out.println(Arrays.toString(iArr));
				} else {
					break;
				}
			}
			
			int tot = 0;
			for(int i = 0; i < iArr.length; i++) {
				tot += iArr[i];
			}
			System.out.println("사용자가 입력한 정수의 총합 : " + tot);
		}
		
	public static void main(String[] args) {
	
		//sample1();
		//sample2();
		//sample3();
		//sample4();
		//sample5();
		//sample6();
		//sample7();
		//sample8();
		//sample9();
		sample10();
		
		
		
		
		
		
		
	}

}
