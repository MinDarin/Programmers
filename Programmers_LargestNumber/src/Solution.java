/*
import java.util.*;
public class Solution {
	public static String solution (int[] numbers)
	{
		String answer = "";

		LinkedList<String> list = new LinkedList<String>();
		int[] skip_list = new int[numbers.length];
		permutation(numbers,"",list,skip_list, 0);
		list.sort(new comparator());
		answer = list.getLast()+"";
		return answer;
	}
	public static void main(String []args)
	{
		int[] numbers= {6,10,2};
		System.out.println(solution(numbers));
		int[] numbers2= {3,30,34,5,9};
		System.out.println(solution(numbers2));
	}
	public static void permutation(int[] numbers, String sub, LinkedList list, int[] skip_list, int count)
	{
		if(count >= 3)
		{
			if(sub != "")
				list.add(sub);
		}
	
		for(int i = 0 ; i < numbers.length; i++)
		{
			if(skip_list[i] == 1)
				continue;
			int[] new_skip_list = new int[numbers.length];
			new_skip_list = Arrays.copyOf(skip_list, skip_list.length);
			new_skip_list[i] = 1;
			permutation(numbers,""+sub+numbers[i], list, new_skip_list, count +1);
		}
	}
}
class comparator implements Comparator<String>
{
 @Override
 public int compare(String i1, String i2)
 {
	 if(i1.compareTo(i2) > 0)
		 return 1;
	 else if(i1.compareTo(i2) < 0)
		 return -1;
	 else
		 return 0;
 }
}*/

import java.util.*;
public class Solution {
	public static String solution (int[] numbers)
	{
		String answer ="";
		
		return answer;
	}
	public static void main(String []args)
	{
		int[] numbers= {6,10,2};
		System.out.println(solution(numbers));
		int[] numbers2= {3,30,34,5,9};
		System.out.println(solution(numbers2));
	}
}