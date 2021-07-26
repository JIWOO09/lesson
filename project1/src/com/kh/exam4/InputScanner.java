package com.kh.exam4;

import java.util.Scanner;

public class InputScanner {

	static Scanner sc = new Scanner(System.in); 
	      //sc는 클래스 변수라고 함 : 클래스 어느곳에서든 사용 가능
	
	//메서드
	public static void main(String[] args) {
		//지역 변수는 소속된 메서드 안에서만 쓸 수 있음
		
		System.out.println("당신의 이름을 입력하세요 : ");
		String name;
		name = sc.nextLine();
		
		sc.nextLine();//nextIn()로 입력받은 정수값 뒤에 \r\n 값이 있어서 처리하기 위해 사용함
		
		System.out.println("당신의 나이를 입력하세요. : ");
		int age;
		age = sc.nextInt();
		
		
		System.out.printf("당신의 나이는 %d 입니다.\n " , age);
		System.out.printf("당신의 나이는 %s 입니다.\n " , name);
		
		
	}

}
