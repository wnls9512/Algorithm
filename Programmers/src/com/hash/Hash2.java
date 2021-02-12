package com.hash;

/**
 * 
 * ���� ����
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��,
 * �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
 * ��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
 * ������ : 119
 * ���ؿ� : 97 674 223
 * ������ : 11 9552 4421
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book�� solution �Լ��� �Ű������� �־��� ��, 
 * � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� 
 * �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
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
		//���ڿ��� Ư�� ���ڿ��� �����ϴ��� Ȯ���ϴ� �޼ҵ�.
		//searchString : �˻��� ���ڿ�. ��ҹ��ڸ� ����.
		//length : ���ڿ� �� ������ �˻����� ���մϴ�. ���� ������ ��ü ���ڿ��� ������� �մϴ�.
		
		//endsWith() - Ư�� ���ڿ��� �������� Ȯ��
		//incluedes() - Ư�� ���ڿ��� �����ϴ��� Ȯ��
		
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
