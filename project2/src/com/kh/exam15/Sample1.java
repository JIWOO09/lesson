package com.kh.exam15;

import java.util.Arrays;

public class Sample1 {

	public static void main(String[] args) {
		/*
		 * 1. 페이지 인터페이스 생성
		 *     a. read()
		 *     
		 * 2. 페이지 인터페이스를 상속하여 책 클래스 생성
		 *     a. 전체 페이지 번호, 현재 페이지 번호 속성을 정의
		 *     ㅠ. page(), next(), prev() 메서드 정의
		 *     
		 * 3. 책 클래스를 상속하여 소설, 만화, 잡지 클래스 정의
		 *     a. 책이름, 출판사
		 *     b. 소설은 read() 구현할 때 "글자를 읽습니다." 로 구현
		 *        만화는 read() 구현할 때 "그림을 봅니다." 로 구현
		 *        잡지는 read() 구현할 때 "그림과 글자를 보고 읽습니다." 로 구현
		 *        
		 * 4. 소설 클래스에는 다음의 내용을 추가 구현
		 *     a. 장르, 작가 속성 
		 *     b. search() 구현
		 *     
		 * 5. 만화 클래스에는 다음의 내용을 추가 구현
		 *     a. 글작가, 그림작가, 연령 제한 속성
		 *     
		 * 6. 잡지 클래스에는 다음의 내용을 추가 구현
		 *     a. 에디터, 종류 속성
		 *     b. QRCapture() 구현
		 */
		
		Book[] books = new Book[5];
		books[0] = new Novel("해리포터 마법사의 돌 1", "문학수첩", "판타지", "J.K 롤링", 268);
		books[1] = new Comics("원피스 98", "대원", "오다에이이치로", "오다에이이치로", 12, 192);
		books[2] = new Magazine("에스콰이어", "허스트중앙", "에스콰이어편집부", "여성/남성", 156);
		books[3] = new Novel("해리포터 마법사의 돌 2", "문학수첩", "판타지", "J.K 롤링", 244);
		books[4] = new Comics("원피스 97", "대원", "오다에이이치로", "오다에이이치로", 12, 192);
		
		for(Book b: books) {
			// toString() 을 오버라이딩 하여 책의 모든 정보가 출력 될 수 있도록 한다.
			// 형식은 다음과 같이 한다.
			// 소설책 [제목:해리포터 마법사의 돌 1, 출판사:문학수첩, 장르:판타지, 작가:J.K 롤링, 총페이지:268, 현재페이지:0]
			// 코믹스 [제목:원피스, 출판사:대원, 글작가:오다에이치로, 그림작가:오다에이치로, 연령제한:12세, 총페이지:192, 현재페이지:0]
			// 잡지 [제목:에스콰이어, 출판사:허스트중앙, 에디터:에스콰이어편집부, 종류:여성/남성 총페이지:156, 현재페이지:0]
			System.out.println(b);
		}
		
		// 위의 Book 배열 객체에서 소설책, 코믹스, 잡지를 분류하고 분류된 객체를 각 배열
		// (Novel 배열, Comics 배열, Magazine 배열)로 이동 시킨다.
		// 동적 배열이 어려우면 정적 배열로 만들어서 진행해도 됨.
		Novel[] novels = null;			int nCnt = 0;
		Comics[] comices = null;		int cCnt = 0;
		Magazine[] magazines = null;	int mCnt = 0;
		for(Book b: books) {
			if(b instanceof Novel) {
				nCnt++;
			} else if(b instanceof Comics) {
				cCnt++;
			} else if(b instanceof Magazine) {
				mCnt++;
			}
		}
		novels = new Novel[nCnt];
		comices = new Comics[cCnt];
		magazines = new Magazine[mCnt];
		nCnt = cCnt = mCnt = 0;
		for(Book b: books) {
			if(b instanceof Novel) {
				novels[nCnt++] = (Novel)b;
			} else if(b instanceof Comics) {
				comices[cCnt++] = (Comics)b;
			} else if(b instanceof Magazine) {
				magazines[mCnt++] = (Magazine)b;
			}
		}
		
		System.out.println(Arrays.toString(novels));
		System.out.println(Arrays.toString(comices));
		System.out.println(Arrays.toString(magazines));
	}

	}


