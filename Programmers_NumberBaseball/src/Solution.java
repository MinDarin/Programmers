import java.util.*;
public class Solution {
	static int[] no_used = new int[1000];
	public static int solution(int[][] baseball)
	{
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int answer = 0;
		int cur_num;
		int strike;
		int ball;

		
		for(int c = 0; c < baseball.length; c++)
		{
			cur_num = baseball[c][0];
			strike = baseball[c][1];
			ball = baseball[c][2];
			int[] input_arr = new int[3];
			input_arr[0] = cur_num / 100;
			cur_num -= input_arr[0] * 100;
			input_arr[1] = cur_num / 10;
			cur_num -= input_arr[1] * 10;
			input_arr[2] = cur_num;
		
			for(int i = 111; i <= 999; i++)
			{
				if(no_used[i] == -1 )
					continue;

				int[] temp_arr = new int[3];
				int cur_i = i;
				int cur_strike = 0;
				int cur_ball = 0;
				temp_arr[0] = cur_i / 100;
				cur_i -= temp_arr[0] * 100;
				temp_arr[1] = cur_i / 10;
				cur_i -= temp_arr[1] * 10;
				temp_arr[2] = cur_i;
				
				if(temp_arr[0] == 0 || temp_arr[1] == 0 || temp_arr[2] == 0 || temp_arr[0] == temp_arr[1] || temp_arr[1] == temp_arr[2] || temp_arr[0] == temp_arr[2])	
					continue;
			
				if(temp_arr[0] == input_arr[0])
					cur_strike++;
				else if(temp_arr[0] == input_arr[1] || temp_arr[0] == input_arr[2])
					cur_ball++;
				if(temp_arr[1] == input_arr[1])
					cur_strike++;
				else if(temp_arr[1] == input_arr[0] || temp_arr[1] == input_arr[2])
					cur_ball++;
				if(temp_arr[2] == input_arr[2])
					cur_strike++;
				else if(temp_arr[2] == input_arr[0] || temp_arr[2] == input_arr[1])
					cur_ball++;
				if(cur_strike == strike && cur_ball == ball)
				{   }
				else
				{
					no_used[i] = -1;
				}
			}
		}
		for(int i = 111; i <= 999; i++)
		{
			int cur_i = i;
			int[] temp_arr = new int[3];
			temp_arr[0] = cur_i / 100;
			cur_i -= temp_arr[0] * 100;
			temp_arr[1] = cur_i / 10;
			cur_i -= temp_arr[1] * 10;
			temp_arr[2] = cur_i;

			if(temp_arr[0] == 0 || temp_arr[1] == 0 || temp_arr[2] == 0 || temp_arr[0] == temp_arr[1] || temp_arr[1] == temp_arr[2] || temp_arr[0] == temp_arr[2] || no_used[i] == -1)	
				continue;
			else answer++;
		}
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args)
	{
		int[][] baseball= {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
		solution(baseball);
	}
}
