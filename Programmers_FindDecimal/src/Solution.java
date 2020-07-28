import java.util.*;
public class Solution {
    public static int solution(String numbers) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	int answer = 0;
        char[] char_num = numbers.toCharArray();
        int[] point = new int[char_num.length];
        int[] card_num =new int[10];

        for(int i = 0 ; i < char_num.length; i++)
        {        	
        	list.add(char_num[i]-48);
        	card_num[list.get(i)]++;
        }
        list.sort(new comparator());
        int max = 0;
        for(int i = char_num.length-1; i >= 0 ; i--)
        {
        	max+= Math.pow(10, i)*list.get(i);
        }        

        int[] temp_card = new int[10];
        for(int i = 2; i<= max; i++)
        {
    		for(int c = 0 ; c <= 9; c++)
        	{
        		temp_card[c] = card_num[c];
        	}
        	boolean no_ans = false;
        	String s = i+"";
    		char[] t = s.toCharArray();
    		for(int c= 0; c <t.length; c++)
    		{
    			temp_card[t[c]-48]--;
    			if(temp_card[t[c]-48]<0)
    			{
    				no_ans = true;
    				break;
    			}
    		}
    		if(no_ans)
    		{
    			continue;
    		}

        	boolean decimal = false;
        	for(int j = 2; j < i ; j++)
        	{
        		if(i%j == 0)
        		{
        			decimal = true;
        			break;
        		}
        	}

        	if(decimal)
        		continue;        	
        	else answer++;
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args)
    {
    	String numbers ="011";
    	solution(numbers);
    }
}
class comparator implements Comparator<Integer>
{
	@Override
	public int compare(Integer i1, Integer i2)
	{
		if(i1 > i2)
			return 1;
		else if(i1 < i2)
			return -1;
		return 0;
	}
}
