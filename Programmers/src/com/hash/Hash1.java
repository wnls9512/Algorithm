package com.hash;

import java.util.Arrays;
import java.util.HashMap;

import org.xml.sax.SAXParseException;

/**
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
 * 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
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
	 * 방법 1 HashMap
	 */
	public String solution1(String[] participant, String[] completion) {
		String answer = "";
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		//참가자의 이름을 key값으로 map에 모두 담는다. 
		//중복된 이름이 없다면 0
		//중복된 이름이 있다면 +1을 한다
		for(String player : participant)
			//getOrDefault(key, defaultValue)
			//찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본값을 반환한다.
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		
		//완주자의 이름이 map에 담겨 있다면 값을 -1 한다.
		//map은 Key값이 동일한 요소(중복)를 추가하면, 늦게 추가한 값으로 치환된다.
		for(String player : completion)
			hm.put(player, hm.get(player) - 1);
		
		//map의 값이 1이면 완주를 못한 것!
		//keySet : key만 모아서 목록화
		for(String key : hm.keySet()) {
			if(hm.get(key) != 0) {
				answer = key;
			}
		}
		
		return answer;
	}
	
	/**
	 * 방법 2 정렬 
	 */
	public String solution2(String[] participant, String[] completion) {
		String answer = "";
		
		//Arrays.sort()
		//전달 받은 배열의 모든 요소를 오름차순 정렬
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		//정렬 순서가 다른 것을 찾으면 됨!
		int i;
		for(i=0; i<completion.length; i++) {
			if(!participant[i].equals(completion[i])) break;
		}	
		return participant[i];
	}
}
