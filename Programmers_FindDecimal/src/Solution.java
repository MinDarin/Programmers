
public class Solution {
    public static int solution(String numbers) {
        int answer = 0;
        char[] num_char = numbers.toCharArray();
        int[] num_int = new int[num_char.length];
        for(int i = 0 ; i < num_char.length; i++)
        {
        	num_int[i] = num_char[i] - 48;        	
        }
        return answer;
    }
    public static void main(String args[])
    {
    	String numbers="17";
    	solution(numbers);
    }
}
