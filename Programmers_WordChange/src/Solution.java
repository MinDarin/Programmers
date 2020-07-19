
public class Solution {
		static int word_len = 0;
		static int begin_n = 0;
		static int min = 999999;
		public static int solution(String begin, String target, String[] words) {
			word_len = words.length;
			int[] visited = new int[word_len];
			int answer = 0;
			int count = 0;
			begin_n = begin.length();
			dfs(begin.toCharArray(), target, words,visited,count,0);
			System.out.println(min);
			answer = min;
			if(answer == 999999)
				return 0;
			else
			return answer;
	    }
	   public static void dfs(char[] begin, String target, String[]words,int[] visited,int count, int start_idx)
	   {			   
		   if(start_idx >= word_len)
			   return;
		   if(String.valueOf(begin).compareTo(target) == 0)
		   {
			   if(min > count)
				   min = count;
			   return;
		   }
		   for(int i = 0; i < word_len; i++)
		   {
			   if(visited[i] !=0) continue;
			   char[] temp = words[i].toCharArray();
			   boolean flag = false;
			   int dif = 0;
			   for(int j = 0 ;j < begin_n; j++)
			   {
				  if(temp[j] != begin[j])
				  {
					   dif++;
				  }
				  if(dif > 1)
				  {
					  flag = true;
					  break;
			   	  }
			   }
			   if(flag)
				   continue;
			   else
			   {
			   visited[i] = 1;
			   int[] temp_visited = new int[word_len];
			   for(int l = 0 ; l < word_len; l++)
				   temp_visited[l] = visited[l];
			   dfs(temp,target,words,temp_visited,count+1,start_idx+1);
			   }
		   }
	   }
	   public static void main(String args[])
	   {
		  String begin = "hit";
		  String target = "cog";
		  String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		  solution(begin,target,words);
	   }
}
