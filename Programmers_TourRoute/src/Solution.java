import java.util.*;
public class Solution {
	static int ticket_len;
	static int max_len = -1;
    static String[] answer = {};
	public static String[] solution(String[][] tickets)
	{
		ticket_len = tickets.length;
		int[] used = new int[ticket_len];
		for(int i = 0 ; i < ticket_len ; i++)
		{
			used[i] = 0;
		}
	    String[] temp_ans = new String[ticket_len+1];
	    int temp_idx = 0;
	    dfs("ICN",tickets,temp_ans,temp_idx,-1,used);
	    for(int i = 0 ; i< answer.length; i++)
	    	System.out.print(answer[i] +" ");
	    return answer;
	}
	public static boolean dfs(String start,String[][] tickets, String[] temp_, int temp_idx, int visited_idx, int[] used)
	{
		LinkedList<pair> queue = new LinkedList<pair>();

		int[] temp_used = new int[ticket_len];
		for(int i = 0 ; i < ticket_len ; i++)
		{
			temp_used[i] = used[i];
		}
		if(visited_idx >= 0)
			temp_used[visited_idx] = 1;	 	

		if(temp_idx >= ticket_len)
		{
			temp_[temp_idx] = start;
			answer = temp_;
			return true;
		}
		String[] temp_ans = new String[ticket_len+1];
		for(int t = 0;  t< temp_idx; t++)
		{
			temp_ans[t] = temp_[t];
		}
		temp_ans[temp_idx++] = start;

		for(int i = 0; i < ticket_len; i++)
	 	{
	 		if(start.compareTo(tickets[i][0]) == 0 && temp_used[i] == 0)
	 		{
	 			pair p = new pair(tickets[i][0], tickets[i][1],i);		 			
	 			queue.add(p);
	 		}
	 	}

		if(queue.isEmpty())
			return false;
		Collections.sort(queue);
	 	while(!queue.isEmpty())
	 	{	
	 		pair temp = queue.pop();
	 		if(dfs(temp.end, tickets, temp_ans, temp_idx,temp.idx,temp_used))
	 			return true;
	 	}
		return false; //이거 true면 1번 testcase 안 돌아감 왜지
	}
	public static void main(String args[])
	 {
		 String[][] tickets = {{"ICN", "JFK"}, {"JFK", "ICN"}, {"ICN", "JFK"}, {"JFK", "ICN"}};
		 solution(tickets);
	 }
}
class pair implements Comparable<pair>
{
	int idx = 0;
	String start;
	String end;
	pair(String s, String e, int i)
	{
		start = s;
		end = e;
		idx = i;
	}
	@Override
	public int compareTo(pair p) {
		if(this.end.compareTo(p.end) > 0)
			return 1;
		else if(this.end.compareTo(p.end) < 0)
			return -1;
		else return 0;
	}
}
