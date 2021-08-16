package com.kh.practice.snack.veiw;


import com.kh.practice.snack.controller.*;
import java.util.Scanner;



public class SnackMenu {
	
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		
		
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		
		System.out.print("갯수 : ");
		int numOf = sc.nextInt(); sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt(); sc.nextLine();
		
		System.out.print(scr.saveDate(kind, name, flavor, numOf, price));
		
		System.out.print("저장한 정보를 확인하시겠습니다? (y / n) : ");
		String yn = sc.nextLine();
		
		
		if(yn.equals("y")) {
			System.out.print(scr.confirmDate());
		} else if(yn.equals("n")){
				return;
		}
	}

}
