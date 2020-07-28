
public class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        int[] map = new int[2];
        for(int i = yellow ; i >= 1; i--)	//¼¼·Î
        {
        	int j = yellow / i;
        		if(i*j == yellow)
        		{
        			if(2*(j+2) + 2*i == brown)
        			{
        				answer[0] = i+2;
        				answer[1] = j+2;
        				break;
        			}
        		}
        }
        System.out.println(answer[0]+","+answer[1]);
        return answer;
    }
    public static void main(String[] args)
    {
    	int brown = 24;
    	int yellow = 24;
    	solution(brown, yellow);
    }
}
