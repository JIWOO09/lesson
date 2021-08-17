package com.kh.exam12;

class Person {
	
	
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

class Student extends Person {
	
	public Student(String name, int age) {
		super(name, age);
//		this.setName(name);
//		this.setAge(age);
	}
	
	@Override
	public String toString() {
		return "Student [name=" + this.getName() + ", age=" + this.getAge() + "]";
	}
}


class Sample1 {

	public static void main(String[] args) {
		Student s = new Student("홍길동", 30);
		System.out.println(s);
	}

}


