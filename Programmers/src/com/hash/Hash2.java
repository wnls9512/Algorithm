package com.hash;

/**
 * 
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중,
 * 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book이 solution 함수의 매개변수로 주어질 때, 
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * 
 */
public class Hash2 {

	public static void main(String[] args) {
		
		String[] phoneBook = {"119", "97674223", "1195524421"};
		boolean answer = new Hash2().solution(phoneBook);
		System.out.println("answer = " + answer);
	}

	public boolean solution(String[] phoneBook) {
		boolean answer = true;
		
		//startWith(searchString, length)
		//문자열이 특정 문자열로 시작하는지 확인하는 메소드.
		//searchString : 검색할 문자열. 대소문자를 구분.
		//length : 문자열 중 어디까지 검색할지 정합니다. 값이 없으면 전체 문자열을 대상으로 합니다.
		
		//endsWith() - 특정 문자열로 끝나는지 확인
		//incluedes() - 특정 문자열을 포함하는지 확인
		
		for(int i=0; i<phoneBook.length-1; i++) {
			for(int j=i+1; j<phoneBook.length; j++) {
				if(phoneBook[i].startsWith(phoneBook[j]))
					return false;
				if(phoneBook[j].startsWith(phoneBook[i]))
					return false;
			}
		}
		return true;
	}

}
