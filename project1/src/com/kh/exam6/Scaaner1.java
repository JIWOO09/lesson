package com.kh.exam6;

import java.util.Scanner;

public class Scaaner1 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		//1.스캐너 라는 기능을 생성하는 코드 > 공식임 외워!
		
		//2.스캐너가 가지고 있는 기능을 통해서 콘솔창으로부터 데이터를 입력받음
			//(쉽게 말해서 우리가 원하는 값을 콘솔창에 입력하는것)
		
		System.out.print("자기소개 : ");
		String intro = sc.nextLine(); //공백 (띄어쓰기)를 포함해서 스캔 (우리가 콘솔창에 데이터 입력 시 띄어쓰기도 읽음)
		// sc.nextLine(); 이곳에 입력 받은(한) 데이터를 변수(String 인트로)에 담기
		
		
		System.out.print("이름 : ");
		String name = sc.next(); //공백을 포함하지 않는 단어만
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.println("자기소개 : " + intro);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		sc.close();
	}

}
