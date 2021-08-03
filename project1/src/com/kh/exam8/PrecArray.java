package com.kh.exam8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PrecArray {
	
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	
	
	public static void ex1 () {
		
		
		
		
		//길이가 10인 정수 배열을 선언하고 1 ~ 10까지의 값을 배열에 초기화하는 코드를 작성
		
		int [] iArr = new int [10];
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = i + 1; //초기화 하는법
			
			
		}
		//2. 초기화 (별도의 변수 활용)
		int val = 1;
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = val;
			val++;
		}
		
		//3. 초기화 (와일문)
				int i = 0;
				while (i < iArr.length) 
					iArr[i] = i + 1;
					i++;
		
	

		for( i = 0; i < iArr.length; i++) {
				System.out.println("iArr[" + i + "] -> " + i);
		}
		
	
		
	}
	public static void ex2 () {
		
		/* 
		 * 길이가 10인 정수 배열을 선언하고 짝수에 해당하는 값을 배열에 순차적으로 초기화하는 코드를 작성
         */
		
		
		int [] iArr = new int [10];
		
		//1.초기화
		int val = 2;
		for(int i = 0; i < iArr.length; i++) {
		 iArr[i] = val;
		 val += 2;
		 
		}	
		//2. 초기화 인덱스 활용
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = ( i + 1) * 2;
		}
		
		//3. 초기화 (와일문)
		int i = 0;
		while (i < iArr.length) {
			iArr[i] = (i + 1) * 2;
			i++;
		}
		
		for (i = 0; i < iArr.length; i++) {
		System.out.println("iArr[" + i + "]  -> " + iArr[i]);
		
		}
		
	}
	public static void ex3 () {
		
		/*
		 * 길이가 20인 정수 배열을 선언하고 홀수에 해당하는 값을 배열에 순차적으로 초기화하는 코드를 작성
		 * 단 99부터 역순으로 초기화
		 * 
		 * int[] iArr = new int [20];
		 * int[0] = 99; int[1] = 97;
		 * int[2] = 95; int[3] = 93;
		 * .....
		 * 
		 * 
		 */
		
		 
		int [] iArr = new int [20];
			
		//1.초기화 
		int val = 99;
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = val;
			val -= 2;
		}
		
		//2. 초기화
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = 99 - i * 2;
		}	
		
		
		//3. 초기화 (와일문)
				int i = 0;
				while (i < iArr.length) {
					iArr[i] = 99 - i * 2;
					i++;
		}
		
		//4. 초기화 역순으로
				for (i = iArr.length - 1; i >= 0; i--) {
					iArr[i] = 99 - i * 2;
				}			
				
		//5.초기화 (와일문)
				i = iArr.length -1;
				while (i >= 0) {
					iArr[i] = 99 - i * 2;
					i--;
		}
				
				
				
		for (i = 0; i < iArr.length; i++) {
				System.out.println("iArr[" + i + "] -> " +  iArr[i]);
		}	
				
	}
		
		
		
		
	public static void ex4 () {
		
		/*길이가 26인 정수 배열을 선언하고 아스키 문자 대문자를 순차적으로 초기화는 코드 작성
		 * 
		 */
		
		
		
		
		
		
		
	}
	
	
	public static void ex5() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 100 부터 배열의 크기만큼
		 * 초기화를 진행한다.
	     * 
		 */
		
	  int arrSize;
	  System.out.print(" 생성할 배열 크기 (정수) : ");
	  arrSize = sc.nextInt(); sc.nextLine();
	  
	  int[] iArr = new int[arrSize];
	  
	  //1.초기화
	 for (int i = 0; i < iArr.length; i ++) {
		 	iArr[i] = 100+i;
	 }
	  
	 for(int i = 0; i < iArr.length; i++) {
		 System.out.println("iArr[" + i + "]-> " + iArr[i]);
	 }
	 
	}



	public static void ex6() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 다시 사용자 입력을 이용하여
		 * 사용자가 직접 배열의 크기 만큼 초기화 할 수 있도록 한다.
		 * (생성 할 배열 타입은 문자열로 한다.)
		 */
		
		int arrSize;
		System.out.print("생성할 배열 크기 (정수) : ");
		arrSize =sc.nextInt(); sc.nextLine();
		
		String[] sArr = new String [arrSize];
		
		//1.초기화
		for (int i = 0; i < sArr.length; i ++) {
			System.out.print("초기값 입력 [" + i + "] : ");
		 	sArr[i] =sc.nextLine();
	 }
		
	  
	 for(int i = 0; i < sArr.length; i++) {
		 System.out.print("iArr[" + i + "]-> " + sArr[i]);
	 }	
		
}
	
	
	
	

	public static void ex7() {
		/*
		 * 2021년 7월에 한정하여 사용자 입력을 통해 일자 데이터를 입력 받고 해당하는 일자가
		 * 어떤 요일인지 알려주는 코드를 배열을 활용하여 작성한다.
		 */
		
		
		
		int day;
		String[] dayArr = new String [] {"수" ,"목", "금", "토", "일", "월", "화"};
		
		
		System.out.println("요일 입력 (1 ~ 31) : ");
		day = sc.nextInt(); sc.nextLine();
		
		
		if(day >= 1 && day <= 31) {
			System.out.println(dayArr[day % 7] + "요일 입니다." );
			} else {
				System.out.println("1 ~ 31 사이의 값을 입력하세요. ");
			}
		
	}

		//아래 긴 문장을 위에 배열을 이용하여 짧게 
		
		
		
//			switch(day & 7) {
//				case 0:
//					System.out.println("수요일 입니다."); break;
//				case 1:
//				System.out.println("목요일 입니다."); break;
//				case 2:
//					System.out.println("금요일 입니다."); break;
//				case 3:
//					System.out.println("토요일 입니다."); break;
//				case 4:
//					System.out.println("일요일 입니다."); break;
//				case 5: 
//					System.out.println("월요일 입니다."); break;
//				case 6:
//					System.out.println("화요일 입니다."); 
//			}
//			
//			switch(day % 7 ) {
//			//여러 케이스를 작성.
//			case 3 : case 4:
//				System.out.println("주말입니다."); break;
//			default :
//					System.out.println("주중입니다.");
//			}
//		} else {
//			System.out.println("1 ~ 31 사이의 값을 입력하세요. ");
//		}
//		
		
	public static void ex8() {
		
		
		//가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
				//배열 응용과 무한반복
				
				/*
				 * 1. 사용자 / 컴퓨터 임의의 가위 바위 보를 입력
				 * 사용자는 스캐너로 직접 입력하여 사용
				 * 컴퓨터는 (입력하지 못하니) 랜덤 사용 012 > 가위바위보로 바꿔서 작동하도록
				 * 
				 * 2.승부 비교를 위한 조건문이 필요
				 * 
				 * 가위 : 바위 -> 바위 승
				 * 가위 : 보 -> 가위 승
				 * 가위 : 가위 -> 무승부	
				 * 
				 * 3. 2번 비교 결과에 따른 승 매 무 저장해두어 승률 출력
				 * 
				 */
				
				
				String player;
				String computer = "";
				int [] score = new int[3]; //0:승 1: 패 2:무 배열등록
				String [] sArr = {"가위", "바위", "보"};		
				boolean exitFlag = false;
				
				
				while (true) {
				while( true ) {
					System.out.print(" 가위 바위 보 중 하나를 입력하세요 (종료를 원하면 종료 입력) : ");
					player = sc.nextLine();
					if (player.equals("가위") || player.equals("바위")|| player.equals("보") || player.equals("종료")) {
						if(player.equals("종료")) {
							exitFlag = true;
						}
						
						break; //사용자 입력에 대한 무한반복을 중단해주는 역할 > 바깥 와일문에는 영향 없음				
					}
				}
					
//				switch(rd.nextInt(3)) {
//				 case 0:
//				 	computer = "가위";  break;
//				 case 1:
//					 computer = "바위"; break;
//				 case 2:
//					 computer = "보"; break;
//				}
				
				
				if(exitFlag) {
				break;
				}
				computer = sArr[rd.nextInt(3)]; //스위치문 대신 배열 사용해서 컴퓨터가 랜덤값을 낼 수 있도록 간략하게 가능
				
				if(player.equals("가위")) {
					if(computer.equals("바위")) {
						System.out.println("컴퓨터 승");
						score [1] += 1;
					} else if (computer.equals("보")){
						System.out.println("플레이어 승");
						score [0] += 1;
					} else if (computer.equals("가위") ){
						System.out.println("무승부");			
						score [2] += 1;
					}
			
				} else if(player.equals("바위")) {
					if(computer.equals("보")) {
						System.out.println("컴퓨터 승");
						score[1] += 1;
					} else if (computer.equals("가위")){
						System.out.println("플레이어 승");
						score[0] += 1;
					} else if (computer.equals("바위") ){
						System.out.println("무승부");			
						score[2] += 1;
					}
					
					
				} else if(player.equals("보")) {
					if(computer.equals("가위")) {
						System.out.println("컴퓨터 승");
						score[1] += 1;
					} else if (computer.equals("바위")){
						System.out.println("플레이어 승");
						score[0] += 1;
					} else if (computer.equals("보") ){
						System.out.println("무승부");			
						score[2] += 1;
					}
						
					
			  }
				
				System.out.println("현재 플레이어의 스코어는 : " + score[0] + "승" + score[1] + "패" + score[2] + "무승부 입니다.");
			}		
				
	}

	public static void ex9() {
		
		
		/*
		 * 사용자 입력을 통해 과목 정보를 입력 받는다.
		 * 사용자 입력이 계속 이루어 질 때마다 배열의 크기를 +1씩 눌러 입력한 만큼 저장
		 * 사용자 입력이 "종료"인 경우 더이상 입력을 받지 않고 최종 입력된 모든 과목 정보를 출력
		 * 
		 * 1.배열의 크기가 0인 문자열 배열을 생성
		 * 2.사용자 입력을 받을 수 있도록 무한반복
		 * 3.무한반복문 안에서 사용자 입력을 받도록 작성
		 * 4. 사용자 입력값이 종료가 아니면 기존 배열의 크기 +1을 한 새로운 배열을 생성
		 * 5.새로 생성한 배열에는 기존 배열의 데이터를 깊은복사 통해 저장
		 * 6.복사본의 참조 주소를 기존 배열 변수에 저장
		 * 7. 4번에서 입력받은 데이처를 새로 추가된 배열의 마지막 인덱스에 저장
		 * 8.4번에서 입력받은 데이터가 종료인 경우 무한반복문을 종료할수있게
		 * 9.8번에서 최종 무한 반복이 종료되면 출력
		 */
		
		
		String[] sArr = new String[0];
		String subject = "";
		
		while(true) {
			System.out.print("과목명 입력 : ");
			subject = sc.nextLine();
			if(!subject.equals("종료")) {
				//배열 크기를 늘려서 깊은 복사를 하기 위한 영역
				String[] copyArr = new String[sArr.length + 1];
				for(int i = 0; i < sArr.length; i++) {
					copyArr[i] = sArr[i];
				}
				sArr = copyArr;
				sArr[sArr.length - 1] = subject;
				
			} else {
				break;
			}
		}
		
		for(int i = 0; i < sArr.length; i++) {
			System.out.println("sArr [" + i + "]:" + sArr[i]);
		}
		
	}
	
	public static void ex10() {
		
		/*
		 * 1 ~ 49 사이의 정수값을 사용자 입력을 통해 입력 받고 이를 정수 배열에 저장
		 * -1이 입력 될때까지 배열의 크기를 +1씩 증가시키면서 사용자 입력값을 배열에 저장하며
		 * -1이 입력 되어 더이상 사용자가 입력받지 않을때 배열에 저장된 모든값의 합을 출력한다.
		 * 
		 */
		
		int[] iArr = new int [0];
		
		
		
		while(true) {
		System.out.println("정수 값 입력 (-1 누르면 종료):");
		int num = sc.nextInt(); sc.nextLine();
		
		if(num != -1) {
			int[] copyArr = new int [iArr.length + 1];
		
		for(int i = 0; i < iArr.length; i++) {
			copyArr[i] = iArr[i];
		
		}	
		 iArr = copyArr;
		 iArr[iArr.length - 1 ] = num;
		 System.out.println(Arrays.toString(iArr)); //출력 된 숫자가 안없어지고 남아있음
		} else {
			break;
		}
	}
		int tot = 0;
		for(int i = 0; i < iArr.length; i++) {
			tot += iArr[i];
		}
		
		System.out.println("사용자가 입력한 정수의 총합 : " + tot);
	}
		
		
	
	public static void ex11() {
		/*
		 * 사용자로 부터 임의의 문자열을 입력 받은 후
		 * a, e, i, o, u 문자가 포함되어 있을 때마다 문자 배열에 저장을 한 후 배열의 길이를
		 * 출력하여 얼마나 포함되어 있는지 확인하게 한다.
		 * 
		 * Tip 1.) 사용자가 입력한 문자열의 문자를 탐색하기 위해 .charAt(index) 메서드를
		 * 활용한다.
		 * 		String text = "hello";
		 * 		text.charAt(0); // 'h'
		 * 		text.charAt(1); // 'e'
		 * 		text.charAt(2); // 'l'
		 * 
		 * Tip 2.) 문자열의 길이를 알기 위해 .length() 메서드를 사용한다.
		 * 		String text = "hello";
		 * 		text.length(); // 5
		 * 
		 * System.arraycopy() 활용할 수 있으면 활용한다.
		 */
		
		String text;
		char [] cArr = new char[0];
		
		System.out.print("문자열 입력 : ");
		text = sc.nextLine();
		
		for(int i = 0; i < text.length(); i++) {
			switch (text.charAt(i)) {
			case 'a': case 'e': case 'i':  case 'o': case 'u':
					char[] copyCArr = new char[cArr.length + 1];
					System.arraycopy(cArr, 0, copyCArr, 0, cArr.length);
					cArr = copyCArr;
					cArr[cArr.length - 1] = text.charAt(i);
			}
		}
		System.out.println("a, e, i, o, u 문자가" + cArr.length + "개 있습니다.");
		
		
	}
	public static void ex12() {
		
		/*
		 *  국어, 영어, 수학, 과학, 사회 과목정보가 있는 배열이 있다.
		 *  위 배열에서 사용자가 제거하기 원하는 과목을 입력하면 배열에서 제거될 수 있도록 한다.
		 *  System.arraycopy() 활용할 수 있으면 활용한다.
		 */
		
		
		String[] arrSubject = new String[] {"국어", "영어", "수학", "과학", "사회"};
		String deleteSubject;
		
		int deleteIndex = -1;
		
		System.out.println("현재 등록된 과목 -> " + Arrays.toString(arrSubject));
		System.out.println("제거 할 과목명 입력 : ");
		
		deleteSubject = sc.nextLine();
		
		for(int i = 0; i <arrSubject.length; i++) {
			if(arrSubject[i].equals(deleteSubject)) {
				deleteIndex = i;
						break;
			}
		}
		
		if(deleteIndex >= 0) {
			String[] arrSubjectCopy = new String[arrSubject.length - 1];
			int j;
			// 삭제할 데이터만 뺴고 복사.
			for(int i = 0; i < arrSubjectCopy.length; i++) {
				if(i != deleteIndex) {
					j = i;
				} else {
					j = i + 1;
				}
				arrSubjectCopy[i] = arrSubject[j];
			}
			
			arrSubject = arrSubjectCopy;
			
			System.out.println("삭제를 완료하였습니다.");
			System.out.println(Arrays.toString(arrSubject));
		} else {
			System.out.println("삭제할 데이터를 찾을 수 없습니다.");
		}
		
	}
		
	
		
	
	

	public static void main(String[] args) {
			
		
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		//ex6();
		//ex7();
		//ex8();
		//ex9();
		//ex10();
		//ex11();
		ex12();

				
				
		
		
		
		
	}

}
