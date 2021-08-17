package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.*;



public class SnackController {
	
	private Snack s = new Snack();
	public SnackController() {}
	
	
	public String saveDate (String kind, String name, String flavor, int numOf, int price) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료 되었습니다.\n";
		
		
	}
		
	public String  confirmDate () {
		return s.information();
	}	
		
		
	}

