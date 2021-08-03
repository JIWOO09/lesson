package com.kh.exam8;

import java.util.Arrays;

public class ArratDate1 {

	public static void sample1( ) {
		
		/*
		 * 2차 배열 
		 * 		배열안에 요소가 배열로 구성되어 있는 것을 말한다. (표, 테이블과 같은 구조)
		 */
		
		int[][] arr = new int [3][4];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i + j;
			}
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	
	public static void sample2() {
		int[][] arr = new int[][] {{1, 2, 3}, {4, 5, 6}}; //2차 배열 초기화 방법
		//int[][] arr = {{1, 2, 3}, {4, 5, 6}}
			 //[0][0], [0][1], [0][2] / [1][0], [1][1],[1][2]
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		
	}
		
		
		public static void sample3() {
			
			
			//2차 복사
			int[][] arr =  {{1, 2, 3}, {4, 5, 6},{7, 8, 9}}; 
			int[][] arrCopy = new int [3][3];
			
			// arrCopy = arr; //얕은 복사
			
			for(int i = 0; i < arr.length; i++) { //for문 넣어줘야 깊은복사
			//System.arraycopy(arr, 0, arrCopy, 0, arr.length);
				arrCopy[i] = arr[i].clone(); //복제를 한 주소를 카피본에 저장 해라~ 라는 식
			}
			arr[0][1] = 20; 
			
			System.out.println(Arrays.toString(arr[0]));
			System.out.println(Arrays.toString(arr[1]));
			System.out.println(Arrays.toString(arr[2]));
			
			
		}
		
		
		public static void sample4() {
			//가변 길이 배열 : 2차 배열의 길이가 다르게 구성된 배열
			int[][] arr = new int[3][];
			
			arr[0] = new int [4]; 
			arr[1] = new int [6]; 
			arr[2] = new int [3]; 
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j <arr[i].length; j++) { //두번째 길이 고정시키면 안됨 길이를 구할 수 있도록 
					System.out.println(arr[i] + ":" + i + "|" + j + "\t");
				}
				System.out.println();
			}
			
			
			
			System.out.println(Arrays.deepToString(arr)); //딥스트링 > 한줄로 
		}
	
	
	
		public static void sample5() {
			
			
			//2차 배열 (동적배열)
			int[][] arr = new int[3][];
			
			arr[0] = new int [] {1, 2, 3, 4}; 
			arr[1] = new int [] {5, 6, 7, 8, 9, 10};
			arr[2] = new int [] {11, 12, 13}; 
			
			
			int[][] arrCopy = new int [arr.length + 1][];
			for(int i = 0; i < arr.length; i++) {
				arrCopy[i] = arr[i].clone(); //깊은 복사
			}
			
			arr = arrCopy;
			arr[arr.length - 1] = new int [] {14, 15, 16, 17, 18}; // 늘린 마지막 인덱스에 새로운 배열을 입력
			
			System.out.println(Arrays.deepToString(arr));
			System.out.println(Arrays.deepToString(arrCopy));
														
			
		}
	
	public static void main(String[] args) {

		//sample1();
		//sample2();
		//sample3();
		//sample4();
		sample5();
				
		
		
		
		
	}

}
