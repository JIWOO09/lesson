package com.kh.exam11;

public class Student {
	/*
	 * 학생 클래스
	 * 		학생의 정보를 담아서 관리하기 위한 객체로 사용하기 위한 클래스
	 * 		
	 * 		속성(멤버 변수)
	 * 			이름, 성별, 나이, 과목정보(Subject 클래스의 인스턴스가 담겨있는 객체배열)
	 * 
	 * 		기능(메서드)
	 * 			getter/setter, 새로운 과목추가/수정/삭제, 전체과목점수확인, 총점확인, 평균확인
	 */
	
		private String name;
		private String gender;
		private int age;
		private Subject[] subjects;
		private int index;
		
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
			this.subjects = new Subject[0];
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return this.gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return this.age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		public void addSubject(Subject subject) {
			Subject[] copy = new Subject[this.subjects.length + 1];
			System.arraycopy(this.subjects, 0, copy, 0, this.subjects.length);
			copy[copy.length - 1] = subject;
			this.subjects = copy;
		}
		
		public int total() {
			int tot = 0;
			for(Subject s: this.subjects) {
				tot += s.getJumsu();
			}
			return tot;
		}
	}

