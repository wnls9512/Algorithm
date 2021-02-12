package com.hash;

import java.util.Arrays;
import java.util.HashMap;

import org.xml.sax.SAXParseException;

/**
 * ���� ����
 * ������ ������ �������� �����濡 �����Ͽ����ϴ�. 
 * �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
 * �����濡 ������ �������� �̸��� ��� �迭 participant�� 
 * ������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
 * �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���ѻ���
 * ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
 * completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
 * �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
 * ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
 * 
 */
public class Hash1 {
	
	public static void main(String[] args) {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"}; 
		
		String answer1 = new Hash1().solution1(participant, completion);
		String answer2 = new Hash1().solution2(participant, completion);
		
		System.out.println("answer1 = " + answer1);
		System.out.println("answer2 = " + answer2);
	}
	
	/**
	 * ��� 1 HashMap
	 */
	public String solution1(String[] participant, String[] completion) {
		String answer = "";
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		//�������� �̸��� key������ map�� ��� ��´�. 
		//�ߺ��� �̸��� ���ٸ� 0
		//�ߺ��� �̸��� �ִٸ� +1�� �Ѵ�
		for(String player : participant)
			//getOrDefault(key, defaultValue)
			//ã�� Ű�� �����Ѵٸ� ã�� Ű�� ���� ��ȯ�ϰ� ���ٸ� �⺻���� ��ȯ�Ѵ�.
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		
		//�������� �̸��� map�� ��� �ִٸ� ���� -1 �Ѵ�.
		//map�� Key���� ������ ���(�ߺ�)�� �߰��ϸ�, �ʰ� �߰��� ������ ġȯ�ȴ�.
		for(String player : completion)
			hm.put(player, hm.get(player) - 1);
		
		//map�� ���� 1�̸� ���ָ� ���� ��!
		//keySet : key�� ��Ƽ� ���ȭ
		for(String key : hm.keySet()) {
			if(hm.get(key) != 0) {
				answer = key;
			}
		}
		
		return answer;
	}
	
	/**
	 * ��� 2 ���� 
	 */
	public String solution2(String[] participant, String[] completion) {
		String answer = "";
		
		//Arrays.sort()
		//���� ���� �迭�� ��� ��Ҹ� �������� ����
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		//���� ������ �ٸ� ���� ã���� ��!
		int i;
		for(i=0; i<completion.length; i++) {
			if(!participant[i].equals(completion[i])) break;
		}	
		return participant[i];
	}
}
