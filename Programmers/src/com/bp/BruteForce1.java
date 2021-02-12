package com.bp;

import java.util.ArrayList;

/**
 * ���� Ž��(Brute Force)
 * ��ǻ���� ���� ��� �ɷ��� �̿��Ͽ� ��� ����� ���� ���� Ž���ϴ� ���
 * 
 *
 * ���� ����
 * ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�.
 * �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.
 * 
 * 1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
 * ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 *
 * ������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
 * ������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
 * ���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
 *
 */
public class BruteForce1 {

	public static void main(String[] args) {

		int[] answer = {1,2,3,4,5};
		new BruteForce1().solution(answer);
	}
	
	public int[] solution(int[] answer) {
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        
        			 //���� ����
        for(int i=0; i<answer.length; i++) {
        	if(answer[i] == a[i%a.length])
        		score[0]++;
        	if(answer[i] == b[i%b.length])
        		score[1]++;
        	if(answer[i] == c[i%c.length])
        		score[2]++;
        }
        
        //���� ū �� ã��
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0])
        	list.add(1);
        if(maxScore == score[1])
        	list.add(2);
        if(maxScore == score[1])
        	list.add(3);

        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

}
