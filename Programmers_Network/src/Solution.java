import java.util.*;

public class Solution {
	static LinkedList<Integer> queue = new LinkedList<Integer>();
	static int[] group;
	static int group_num = 1;
	static int max = -1;
	public static int Solution(int n, int[][] computers)
	{
		int answer = 0;
		group = new int[n];
		bfs(n,computers,false);
		for(int i = 0 ; i < n ; i++)
		{
			if(group[i] == 0)
				answer++;	//단독 네트워크 수
			if(max < group[i])
				max = group[i];
		}
		answer+=max; //그룹 네트워크 수
		System.out.println(answer);
		return answer;
	}
	public static void bfs(int n, int[][] computers,boolean flag)
	{
		for(int i = 0 ; i < n; i++)
		{
			if(group[i] == 0)
			{
				for(int j = i+1; j < n;j++)
				{
					if(computers[i][j] == 1 && group[j] == 0 )
					{
						{
						group[i] = group_num;
						group[j] = group_num;					
						}						
						queue.add(j);
						while(!queue.isEmpty())
						{
							int t_i = queue.pop();
							for(int t_j = 0; t_j <n ; t_j++)
							{
								if(t_i == t_j)		//자기 자신
									continue;
								if(group[t_j] != 0) //이미 방문
									continue;
								if(computers[t_i][t_j] == 1)
								{
									if(group[t_i] != -1)
										group[t_j] = group[t_i];
									queue.add(t_j);
								}
							}
						}
						group_num++;
					}
				}				
			}
		}
	}
	public static void main(String args[])
	{
		int n = 5;
		int[][] computers = {{1,0,1,0,0},{0,1,0,1,0},{1,0,1,1,1},{0,1,1,1,0},{0,0,1,0,1}};
		Solution(n,computers);
	}
}
