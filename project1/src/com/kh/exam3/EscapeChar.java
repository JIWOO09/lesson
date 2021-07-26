package com.kh.exam3;

public class EscapeChar {

	public static void main(String[] args) {
		
		
		//이스케이프문자 - 중첩되지 않도록하기 위해
		System.out.println("안녕하세요 \n반갑습니다");
		//엔터역할
		
		System.out.println("안녕하세요 \r반갑습니다");
		//커서를 이 위치로 이동
		
		System.out.println("안녕하세요 \t반갑습니다");
		//문자초함 8칸의 공백 생김
		
		System.out.println("안녕하세요 \"반갑습니다\"");
		//기호까지 출력 '',//,\\, 등 가능함
		
		
	}

}
