package com.kh.exam3;

import com.kh.exam2.NoAccessClass; // 해당 클래스에서 public을 지우면 접근제한자로 됨
import com.kh.exam2.OtherClass;

public class OtherPackage {
	
	public static void main(String[]args) {
	OtherClass other = new OtherClass();
	System.out.println("OtherClass 접근 가능 -> " + other.attribute);
	
	NoAccessClass noAccess = new NoAccessClass();
	System.out.println("NoAccessClass 접근 가능 -> " + noAccess.attribute);
	}
}
