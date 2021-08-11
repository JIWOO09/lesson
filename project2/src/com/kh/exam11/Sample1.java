package com.kh.exam11;

import java.util.Scanner;

public class Sample1 {
	
	static Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		Subject[] subjects = new Subject[3];
		subjects[0] = new Subject("국어", 70);
		subjects[1] = new Subject("영어", 80);
		subjects[2] = new Subject("수학", 90);
		
		// 1. 사용자 입력을 받아서 과학 과목과 점수 85 를 입력받아서 배열의 마지막 인덱스에 추가
		// 단 점수의 경우 0 ~ 100 사이의 입력이 아니면 계속 입력	받을 수 있게 한다.
		
		// 2. 과목명에서 종료라는 문자열이 입력되기 전까지 계속 정보를 입력받아 Subject 클래스의
		// 인스턴스가 Subjects 객체 배열에 추가될 수 있게 한다.(동적 배열)
		
		// 3. 새로운 과목을 추가 할 때 기존에 저장된 과목이 이미 존재하는 경우 다시 과목명을 입력
		// 하도록 한다.(배열에 저장된 Subject 객체를 전체 탐색해야 함. - 반복 필요.)
		while(true) {
			boolean existed = false;
			System.out.print("과목명 입력 : ");
			String name = sc.nextLine();
			if(!name.equals("종료")) {
				// for each 문
				for(Subject s: subjects) {
					if(name.equals(s.getName())) {
						existed = true;
					}
				}
				// for(int i = 0; i < subjects.length; i++) {
				// 	if(name.equals(subjects[i].getName())) {
				// 		existed = true;
				// 	}
				// }
				if(!existed) {
					Subject[] copy = new Subject[subjects.length + 1];
					System.arraycopy(subjects, 0, copy, 0, subjects.length);
					int last = copy.length - 1;
					copy[last] = new Subject(name, -1);
					while(!copy[last].isValid()) {
						System.out.print(copy[last].getName() + " 점수 : ");
						copy[last].setJumsu(sc.nextInt());	sc.nextLine();
						if(!copy[last].isValid()) {
							System.out.println("점수는 " + Subject.getRangeJumsu()[0] +
									" ~ " + Subject.getRangeJumsu()[1] + "범위로 입력해야 합니다.");
						}
					}
					subjects = copy;
				} else {
					System.out.println("이미 존재하는 과목명 입니다.");
				}
			} else {
				break;
			}
		}
		
		for(Subject s: subjects) {
			System.out.println(s.getName() + " 점수 : " + s.getJumsu());
			System.out.println("등급 : " + s.getGrade());
		}
	}
	
	public static void main(String[] args) {
		Student std = new Student("서지우", 32);
		
		// 과목추가
		Subject sub = new Subject("국어", 70);
		std.addSubject(sub);
		sub = new Subject("영어", 80);
		std.addSubject(sub);
		sub = new Subject("과학", 90);
		std.addSubject(sub);
		
		System.out.println(std.getName() + " 학생의 총점은 " + std.total() + " 점 입니다.");
		
	}

}