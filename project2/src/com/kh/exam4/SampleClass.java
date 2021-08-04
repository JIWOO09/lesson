package com.kh.exam4;

 class Other {
	 static int share = 100;
	 int noshare = 200;
	 
	 public Other () {} //생성자

 }

public class SampleClass {

	public static void main(String[] args) {

		Other oth1 = new Other();
		Other oth2 = new Other();
		
		System.out.println(oth1.noshare + "|" + oth2.noshare);
		System.out.println(oth1.share + "|" + oth2.share);
		
		oth1.noshare = 250;
		oth2.share = 150;
		
		System.out.println(oth1.noshare + "|" + oth2.noshare);
		System.out.println(oth1.share + "|" + oth2.share);
		
		
	}

}
