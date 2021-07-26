package com.kh.exam4;

import java.util.Scanner;

public class Prac1 {

	/* 문제
	 * 국어, 영어, 수학 세과목의 점수를 입력 받아서 총점과 평균을 구하고
	 * 출력하는 코드 작성하기
	 * 총점은 반드시 정수로 저장하고 출력해야한다.
	 */
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		double kor; // 실수형 변수 선언 먼저 (float도 가능) > 정수면 int 또는 short, long
		double eng;
		double mth;
		int total; // 데이커 크기가 맞으면 다른것도 선언가능
		double avg;
		
		
		System.out.println("국어 점수 : ");
		kor = sc.nextDouble(); sc.nextLine();
		
		System.out.println("영어 점수 : ");
	    eng = sc.nextDouble();  sc.nextLine();
	    
		System.out.println("수학 점수 : ");
		mth = sc.nextDouble(); sc.nextLine();
		
		total = (int)(kor + eng + mth);
		avg = (kor + eng + mth) / 3.0;
		
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f\n", avg);
		
	
		
		
		
		
		

	}

}
