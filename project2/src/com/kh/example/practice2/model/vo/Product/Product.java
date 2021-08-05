package com.kh.example.practice2.model.vo.Product;

public class Product {
    private String pName = "키보드";
    private int price = 250000;
	private String brand = "레오타드";
	  
	
	  public Product () {}
	  
	  public void information () {
	  System.out.println("제품명 : " + this.pName);
	  System.out.println("가 격 : " + this.price);
	  System.out.println("제품명 : " + this.brand);
	}
}	  