package programmers_TargetNumber;

public class Solution {
	static int num_last;
	static int op_last;
	static int answer = 0;
	public static int solution(int[] numbers, int target)
	{
		int answer = 0;
        op_last = (int)Math.pow(2,numbers.length+1) -1;
		int[] op = new int[op_last+1]; // 0Àº + 1 Àº -·Î
        num_last = numbers.length;
        for(int i = 2 ; i <= op_last; i++)
        {
        	if(i%2==1)
        	op[i] = 1;
        	else op[i] = 0;
   		}
        op[1] = -1;
        dfs(1,-1,op,numbers,0,target);
        return answer;
   }
   public static void dfs(int op_idx, int num_idx, int[] op, int[] numbers, int sum, int target)
   {
	   if(num_idx >= num_last)
	   {
		   if(sum == target)
			   answer++;
		   return;
	   }
	   if(op[op_idx] == 1)
		   sum-=numbers[num_idx];
	   else if(op[op_idx] == 0)
		   sum += numbers[num_idx];
	   dfs(op_idx*2,num_idx+1,op,numbers,sum,target );
	   dfs(op_idx*2+1,num_idx+1,op,numbers,sum,target );

   }
   public static void main(String args[])
   {
	   int [] input = {1,1,1,1,1};
	   solution(input,3);
	   System.out.println(answer/2);
   }
}