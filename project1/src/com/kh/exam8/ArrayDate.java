package com.kh.exam8;

public class ArrayDate {

	
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
		for(int i = 0; i < iArr.length; i++) { //또는  i <= (iArr.legth - 1); > 부등호 다름 
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
		
		
		
		
		
//		System.out.println(boolArr);
//		System.out.println(cArr);
//		System.out.println(dArr);
//		System.out.println(dArr);
//		
		
	}
	
	
	public static void main(String[] args) {
	
		//sample1();
		sample2();
//		sample3();
		//sample4();
		//sample5();
		
		
		
		
		
		
		
	}

}
