/*
import java.util.Collections;
import java.util.LinkedList;

public class WrongSolution {
	static int ticket_len;
	static int max_len = -1;
	static int[] used;
	static LinkedList<pair> queue = new LinkedList<pair>();
	public static String[] wrong_solution(String[][] tickets) {
		    String[] answer;
			ticket_len = tickets.length;
			used = new int[ticket_len];
		 	int ans_idx=0;
		 	answer = new String[ticket_len+1];
		 	answer[ans_idx++] = "ICN";		 	
		 	for(int i = 0; i < ticket_len; i++)
		 	{
		 		if("ICN".compareTo(tickets[i][0]) == 0)
		 		{
		 			pair p = new pair(tickets[i][0], tickets[i][1],i);		 			
		 			queue.add(p);
		 		}
		 	}
		 	Collections.sort(queue);
		 	pair p2 = queue.pop();
		 	used[p2.idx] = 1;
		 	answer[ans_idx++] = p2.end;
		 	String temp_start = p2.end;
		 	queue.clear();
		 	int run = 1;
		 	while(run < ticket_len)
		 	{
			 	for(int i = 0; i < ticket_len; i++)
			 	{
			 		if(temp_start.compareTo(tickets[i][0]) == 0 && used[i] == 0)
			 		{
			 			pair p = new pair(tickets[i][0], tickets[i][1],i);		 			
			 			queue.add(p);
			 		}
			 	}		 		
			 	Collections.sort(queue);
			 	p2 = queue.pop();
			 	used[p2.idx] = 1;
			 	answer[ans_idx++] = p2.end;
			 	temp_start = p2.end;
			 	queue.clear();
			 	run++;
		 	}

		 	for(int i = 0 ; i < answer.length; i++)
		 		System.out.print(answer[i]+" ");
		 	return answer;
	 }
	 
	 public static void main(String args[])
	 {
		 String[][] tickets = {{"ABC", "ICN"}, {"ABZ","ICN"},{"ICN", "ABC"}, {"ICN", "ABZ"}};
		 wrong_solution(tickets);
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
}*/