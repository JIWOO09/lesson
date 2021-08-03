package com.kh.exam8;

import java.util.Arrays;

public class PracArray1 {

	
	public static void ex1() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다. (동적배열 정적배열)
		 * 1. 변수
		 * 2. 조건문 반복문
		 * 3. 짝수 홀수 
		 */
		
		int [] arr = new int [] {37, 92, 58, 46, 94, 29, 25, 58}; //배열 생성과 초기화 한번에
		int [] arrEven = new int[0]; //짝수 배열
		int [] arrOdd = new int[0]; //홀수 배열
		for(int i = 0; i <arr.length; i++) {
			if(arr[i] % 2== 0) { //짝수 조건
				int [] arrEvenCopy = new int [arrEven.length + 1]; //임시저장소 느낌? 짝수의 길이를 알아야하니까 렝스 넣고 기존꺼에 1개 추가 > 동적배열
				System.arraycopy(arrEven, 0, arrEvenCopy, 0, arrEven.length); //0은 인덱스 0
							//arrEven의 0몇번째의 값을 arrevenCopy로 0번째부터 arrEvenr길이 만큼 복사,
				arrEven = arrEvenCopy;  // 임시로 복사 해둔 카피본을 기존 변수를 사용할 수 있게 주소 알려주는 작업
				arrEven[arrEven.length - 1] = arr[i]; // -1 마지막 인덱스에 저장
			} else {
				//홀수 조건
				int [] arrOddCopy = new int [arrOdd.length + 1]; 
				System.arraycopy(arrOdd, 0, arrOddCopy, 0, arrOdd.length);
				arrOdd = arrOddCopy;
				arrOdd[arrOdd.length - 1] = arr[i];
		
			}
		}
		
		System.out.println(Arrays.toString(arrEven));
		System.out.println(Arrays.toString(arrOdd));
	}
	public static void ex2() {
		
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 가장 큰값과 가장 작은 값만을 분리하여 별도의 배열에 저장하도록 한다.
		 * 
		 */
		
		 	int [] arr = new int [] {37, 92, 58, 46, 94, 29, 25, 58};
			int [] minMax = new int [2];
			
			//큰값 작은값에 대한 비료를 위해 미리 0번 인덱스의 값을 배열에 넣는
			minMax[0] = arr[0];
			minMax[1] = arr[0];
			
			//이미 0번 인덱스의 값을 배열안에 넣어 두었기 때문에 1번 인덱스 부터 반복을 징행
			for(int i = 1; i < arr.length; i++) {
				//minMax의 0번 인덱스에는 가장 작은 값만을 저장하기 위해 아래와 같은 비교식을 사용
				if (minMax[0] > arr[i] ){
					minMax[0] = arr[i]; 
				}
				//minMax의 1번 인덱스에는 가장 큰값만을 저장하기 위해 아래와 같은 비교식을 사용
				if(minMax[1] < arr[i]) {
					minMax[1] = arr[i];
				}
			}			
			System.out.println(Arrays.toString(minMax));
	}
	public static void ex3() {
		
		
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 중복된 값을 찾아 중복이 없는 새로운 배열을 만든다.
		 * 
		 */
		
		
	}
	
	
	public static void ex4() {
		
		/*  문제 1번을 2차 배열로 
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다. (정적배열만 썼음)
		 * 1. 변수
		 * 2. 조건문 반복문
		 * 3. 짝수 홀수 
		 */
		
		int [] arr = new int [] {37, 92, 58, 46, 94, 29, 25, 58}; 
		int [][] arrEvenOdd = new int[2][8]; //짝수 홀수 2개니까 2 / 숫자 8개 니까 8
		
		//aarEvenOdd [0]; 
		//aarEvenOdd [1]; 
		int idx1 = 0; //짝수용 인덱스
		int idx2 = 0; //홀수용 인덱스
		for (int i = 0; i <arr.length; i++) {
			if (arr[i] % 2 == 0) {
				arrEvenOdd[0][idx1] = arr[i];
				idx1++;
			} else {
				arrEvenOdd[1][idx2] = arr[i];
				idx2++;
			}
		}
		System.out.println(Arrays.toString(arrEvenOdd[0]));
		System.out.println(Arrays.toString(arrEvenOdd[1]));
	}
	
	public static void ex5() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열)
		 */
		int[] arr = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int[][] arrEvenOdd = new int[2][];
		
		// arrEvenOdd[0] : 짝수 저장
		// arrEvenOdd[1] : 홀수 저장
		int[] arrEven = new int[0];
		int[] arrOdd = new int[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				// 짝수
				int[] arrEvenCopy = new int[arrEven.length + 1];
				System.arraycopy(arrEven, 0, arrEvenCopy, 0, arrEven.length);
				arrEven = arrEvenCopy;
				arrEven[arrEven.length - 1] = arr[i];
			} else {
				// 홀수
				int[] arrOddCopy = new int[arrOdd.length + 1];
				System.arraycopy(arrOdd, 0, arrOddCopy, 0, arrOdd.length);
				arrOdd = arrOddCopy;
				arrOdd[arrOdd.length - 1] = arr[i];
			}
		}
		
		arrEvenOdd[0] = arrEven;
		arrEvenOdd[1] = arrOdd;
		
		System.out.println(Arrays.deepToString(arrEvenOdd));
	}
	
	
	
	public static void main(String[] args) {

		//ex1();
		//ex2();
		//ex3();
		//ex4();
		ex5();
	}

}
