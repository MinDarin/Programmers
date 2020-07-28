import java.util.*;
public class Solution {
	public static int[] solution(int[] array, int[][] commands)
	{
		int[] answer= {};
		answer = new int[commands.length];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int c = 0 ; c < commands.length; c++)
		{
			int start = commands[c][0];
			int end = commands[c][1];
			int k = commands[c][2];
			for(int i = start-1; i <= end-1; i++)
				list.add(array[i]);
			Collections.sort(list);
			answer[c] = list.get(k-1);
			System.out.println(answer[c]);
			list.clear();
		}
		
		return answer;
	}
	public static void main(String[] args)
	{
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		solution(array, commands);
	}
}
class comparator implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2)
			return 1;
		else if (o1 < o2)
			return -1;
		return 0;
	}
}