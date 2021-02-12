package com.sort;

import java.util.Arrays;

/**
 * ���� ����
 * �迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.
 * 
 * ���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
 * array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
 * 1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
 * 2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
 * 
 * �迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, 
 * commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� 
 * �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 */
public class Sort1 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		
		int[] answer = new Sort1().solution(array, commands);
		
		System.out.print("answer = ");
		for(int num : answer)
			System.out.print(num + " ");
	}

	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        //copyOfRange(original, from, to)
        //from ���� ~ to �ٷ� ������ �迭 ��Ҹ� ����
        for(int i=0; i<commands.length; i++) {
        	int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        	//temp[] = 5,2,6,3                     -1�ϴ� ���� : (index�� 0���� �����̹Ƿ�)

        	Arrays.sort(temp);
        	//temp[] = 2,3,5,6
        	
        	answer[i] = temp[commands[i][2]-1];
        }
        
        return answer;
    }
}
