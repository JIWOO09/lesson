package com.kh.exam17;

import java.util.*;

class Subject {
	private int score;
	private String name;
	
	public Subject(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Subject [score=" + score + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		System.out.println("this == obj -> " + this + "|" + obj);
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		System.out.println("getClass() != obj.getClass() -> "
			+ getClass() + "|" + obj.getClass());
		
		Subject other = (Subject) obj;
		System.out.println("return -> " + Objects.equals(name, other.name) + "|"
				+ (score == other.score));
		return score == other.score;
	}
	
}	

public class Sample3 {
	
	public static void main(String[] args) {
		List<Subject> sList = new ArrayList<Subject>();
		sList.add(new Subject("과학", 70));
		sList.add(new Subject("국어", 80));
		sList.add(new Subject("영어", 85));
		
		Subject s = new Subject("국어", 85);
		// boolean resBool = sList.contains(s);
		// System.out.println("contains 최종 결과 : " + resBool);
		
		int resInt = sList.indexOf(s);
		System.out.println("indexOf 최종 결과 : " + resInt);
	}

}
