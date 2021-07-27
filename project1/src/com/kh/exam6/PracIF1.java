package com.kh.exam6;

import java.util.Scanner;

public class PracIF1 {
	
	static Scanner sc = new Scanner(System.in);
	public static void ex1() {
		System.out.println("문제 1번.");
		/*
		 * 영문자 알파벳 범위의 ASCII 코드 번호를 입력받은 경우에만 해당하는 문자를
		 * 출력하고 범위를 벗어난 경우에는 "ASCII 코드 영문자 범위를 벗어났습니다."
		 * 라는 메세지를 출력한다
		 */
	
		int code;
		System.out.println("ASCII 코드 입력 : ");
		code = sc.nextInt(); sc.nextLine();
		
		if(code >= 'A' && code <= 'Z') {
			System.out.printf("입력한 ASCII 코드 %d 의 영문자는 %c 입니다. \n" ,code, code);
		} else if (code >= 'a' && code <= 'z') {
			
				System.out.printf("입력한 ASCII 코드 %d 의 영문자는 %c 입니다. \n" ,code, code);
		} else {
			System.out.println("ASCII 코드 영문자 범위를 벗어났습니다.");
			
		}
	}		
	
	public static void ex2() {
		System.out.println("문제 2번.");
		/*
		 * 국어,영어,수학 세과목의 시험 점수를 입력받아 총점과 평균을 구하고
		 * 평균이 60점이상인 경우에 "합격입니다." 메세지를 출력하고
		 * 60점 이상이 아닌 경우에 "불합격입니다/" 메세지를 출력한다
		 */
		
		double kor, eng, mth;
		double tot, avg;
		
		System.out.println("국어 점수 : ");
		kor = sc.nextDouble(); sc.nextLine();
		
		System.out.println("영어 점수 : ");
		eng = sc.nextDouble(); sc.nextLine();
		
		System.out.println("수학 점수 : ");
		mth = sc.nextDouble(); sc.nextLine();
		
		tot = kor + eng + mth;
		avg = tot / 3.0;
		
		System.out.println("총점 : " + tot);
		System.out.printf("평균 :  %.2f\n" , avg);
		
		if(avg >= 60) {
			System.out.println(avg + "-> 합격 입니다");
		} else if (avg < 60) {
			System.out.println(avg + "-> 불합격 입니다");
		}
		
		
	}
	
	
	public static void ex3() {
		System.out.println("문제 3번 : ");
		/*
         *  2021년 7월에 한하여 1 ~31 일 범위의 일자값을 입력받고 해당 일자의
         *  요일을 출력하게 한다. 입력값의 범위를 벗어난 경우 "1 ~31 사이의 값을
         *  입력하세요." 라는 메시지를 출력한다.
         *  
         */
		
		int day;
		System.out.println("요일 입력 (1 ~ 31) : ");
		day = sc.nextInt(); sc.nextLine();
		
		
		//switch 문
		if(day >= 1 && day <= 31) {
			switch(day & 7) {
				case 0:
					System.out.println("수요일 입니다."); break;
				case 1:
					System.out.println("목요일 입니다."); break;
				case 2:
					System.out.println("금요일 입니다."); break;
				case 3:
					System.out.println("토요일 입니다."); break;
				case 4:
					System.out.println("일요일 입니다."); break;
				case 5: 
					System.out.println("월요일 입니다."); break;
				case 6:
					System.out.println("화요일 입니다."); 
			}
			
			switch(day % 7 ) {
			//여러 케이스를 작성.
			case 3 : case 4:
					System.out.println("주말입니다."); break;
			default :
					System.out.println("주중입니다.");
			}
		} else {
			System.out.println("1 ~ 31 사이의 값을 입력하세요. ");
		}
		
		
		
		
//		if(day >=1 && day <= 31) {
//			if((day % 7) == 0) {
//				System.out.println("수요일 입니다");
//			} else if(day % 7 ) == 1) {
//				System.out.println();
		
//			
//		}
		
		
		
		
		
	}
	
	
	
	public static void ex4() {
		System.out.println("문제 4번 : ");
		/*
		 * 나이를 입력하면 해당 나이대를 출력하도록 한다.
		 * 
		 * 예) 나이입력 : 21 
		 *    20대 입니다.
		 * 
		 * 예) 나이입력 : 12
		 *    청소년 입니다.
		 *    
		 *    1 ~ 4세까지는 영유아, 5 ~ 9세까지는 어린이, 10 ~ 19세까지는 청소년 
		 *    20 ~ 100까지는 20대 30대 40대 50대 형식으로 변화하여 출력한다.
		 */
		
		int age;
		System.out.println("나이 입력 : ");
			age = sc.nextInt(); sc.nextLine();
		
		if(age >= 20 && age <= 100) {
			System.out.println((age / 10 * 10) + " 대 입니다."); 
			// 아래와 같은 패턴이면 이런 공식으로 간단하게 가능
			
			
//		} else if(age > 29 && age < 40){
//			System.out.println("30대 입니다.");
//		
//		} else if (age > 39 && age < 50){
//			System.out.println("40대 입니다.");
//			
//		} else if (age > 49 && age < 60){
//			System.out.println("50대 입니다.");
//			
//		} else if (age > 59 && age < 70) {
//			System.out.println("60대 입니다.");
//			
//		} else if (age > 69 && age < 80){
//			System.out.println("70대 입니다.");
//			
//		} else if (age > 79 && age < 90){
//			System.out.println("80대 입니다.");
//			
//		} else if (age > 89 && age < 100){
//			System.out.println("90대 입니다.");
//			
		} else if (age >= 10 && age < 20) {
			System.out.println("청소년 입니다.");
			
		} else if (age >= 1 && age < 5) {
			System.out.println("영유아 입니다.");
			
		} else if (age >= 5 && age < 10 ) {
			System.out.println("어린이 입니다.");
		}	
		
	}	
		
	
	
	
	public static void ex5() {
		
		/*
		 * 키(cm)와 체중(kg)을 입력하여 BMI 지수를 구하고 BMI 지수에 해당하는 정상, 과체중,
		 * 비만, 고도비만, 등의 정보를 출력하도록 한다.
		 * 
		 * BMI 지수 계산식 > 체중 / 키 * 키
		 * 
		 * 18.5 미만 : 저체중
		 * 18.5 이상 ~ 23 미만 :정상
		 * 23 이상 ~ 25 미만 : 과체중
		 * 25이상 ~ 30 미만 :비만
		 * 30이상 : 고도 비만
		 */
		
		double hei, kg, bmi;
		
		
			System.out.println("키(cm) 입력 : ");
			hei = sc.nextDouble(); sc.nextLine();
			hei = hei / 100.0; //미터 단위로 변환 했어야 bmi 지수 제대로 나옴
			
			
			System.out.println("체중(kg) 입력 : ");
			kg = sc.nextDouble(); sc.nextLine();
			
			
			bmi =  kg / (hei * hei);
			System.out.printf("bmi 지수 :  " + bmi + " -> ");
			
//			bmi = sc.nextDouble(); sc.nextLine(); 쓸 필요 없었음  
			
			
			if(bmi < 18.5 ) {
				System.out.println("저체중 입니다.");
				
			} else if(bmi >= 18.5 && bmi < 23) {
				System.out.println("정상 입니다.");
			} else if(bmi >= 23 && bmi < 25) {
				System.out.println("과체중 입니다.");
			} else if(bmi >= 25 && bmi < 30) {
				System.out.println("비만 입니다");
			} else if (bmi >= 30) {
				System.out.println("과체중 입니다.");
			}
			
	}
	
	
	public static void ex6() {}
	
	
	
	public static void ex7() {
		char op;
		
		System.out.println("사칙연산 기호를 입력하세요 : ");
		
		op = sc.nextLine(). charAt(0);
		//문자 입력 받기 /  0는 앞에 문자 첫번째 1는 두번째 ... 순차적으로 근데 대부분 문자 하나면 0으로

		switch(op) {
			case '+' :
				System.out.println("더하기 기호를 입력했습니다.");	break;
			case '-' :
				System.out.println("빼기 기호를 입력했습니다.");	break;
			case '*' :
				System.out.println("곱하기 기호를 입력했습니다.");	break;
			case '/' :
				System.out.println("나누기 기호를 입력했습니다.");	break;
			default :
				System.out.println("사직연산 기호가 아닙니다.");
		}
	}
	
	
	
		

	
		

	
	public static void main(String[] args) {
		
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		ex5();
		//ex6();
		//ex7();
	
		
	}

}
