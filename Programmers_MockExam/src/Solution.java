import java.util.*;
public class Solution {
	static int[] pattern1= {1,2,3,4,5};
	static int len1 = 5;
	static int grade1 = 0;
	static int[] pattern2= {2,1,2,3,2,4,2,5};
	static int len2 = 8;
	static int grade2 = 0;
	static int[] pattern3= {3,3,1,1,2,2,4,4,5,5};
	static int len3 = 10;
	static int grade3 = 0;

	public static int[] solution(int[] answers) {
        int[] answer = {};    
        int[][] temp = new int[3][2];
        int temp_idx = 0;
        int ans_len = answers.length;
        if(ans_len < len1)
        {
        	for(int i = 0 ; i < ans_len ; i++)
        	{
        		if(answers[i] == pattern1[i])
        			grade1++;
        	}
        }
        else
        {
        	int moc = ans_len / len1;
        	int na = ans_len % len1;
        	int idx = 0;
        	for(int i = 0 ; i < moc; i++)
        	{
        		for(int j = 0; j<len1; j++)
        		{
        			if(answers[idx++] == pattern1[j])
        				grade1++;
        		}
        	}
    		for(int j = 0 ; j < na; j++)
    		{
    			if(answers[idx++] == pattern1[j])
    				grade1++;
    		}
        }
        temp[temp_idx][0] = 1;
        temp[temp_idx][1] = grade1;
        
        if(ans_len < len2)
        {
        	for(int i = 0 ; i < ans_len ; i++)
        	{
        		if(answers[i] == pattern2[i])
        			grade2++;
        	}
        }
        else
        {
        	int moc = ans_len / len2;
        	int na = ans_len % len2;
        	int idx = 0;
        	for(int i = 0 ; i < moc; i++)
        	{
        		for(int j = 0; j<len2; j++)
        		{
        			if(answers[idx++] == pattern2[j])
        				grade2++;
        		}
        	}
    		for(int j = 0 ; j < na; j++)
    		{
    			if(answers[idx++] == pattern2[j])
    				grade2++;
    		}
        }
        
        if(grade1 < grade2)
        {
        	temp[temp_idx][0] = 2;
        	temp[temp_idx][1] = grade2;
        }
        else if(grade1==grade2)
        {
        	temp[++temp_idx][0] = 2;
        	temp[temp_idx][1] = grade2;
        }

        if(ans_len < len3)
        {
        	for(int i = 0 ; i < ans_len ; i++)
        	{
        		if(answers[i] == pattern3[i])
        			grade3++;
        	}
        }
        else
        {
        	int moc = ans_len / len3;
        	int na = ans_len % len3;
        	int idx = 0;
        	for(int i = 0 ; i < moc; i++)
        	{
        		for(int j = 0; j<len3; j++)
        		{
        			if(answers[idx++] == pattern3[j])
        				grade3++;
        		}
        	}
    		for(int j = 0 ; j < na; j++)
    		{
    			if(answers[idx++] == pattern3[j])
    				grade3++;
    		}
        }

        if(temp[temp_idx][1] < grade3)
        {
        	if(temp_idx == 0 )
        		temp[temp_idx][0] =3;
        	else if(temp_idx == 1)
        	{
        		temp[temp_idx][0] =0;
        		temp[temp_idx--][1] =1;
        		temp[temp_idx][0] = 3;
        		temp[temp_idx--][1] =grade3;
        	}
        }
        else if(temp[temp_idx][1] == grade3)
        {
        	temp[++temp_idx][0] = 3;
        }
        answer = new int[temp_idx+1];
        int ans_idx = 0;
        while(ans_idx < 3 && temp[ans_idx][0] != 0)
        {
        	answer[ans_idx] = temp[ans_idx][0];
            System.out.println(answer[ans_idx]);
            ans_idx++;
        }
        return answer;
    }
    public static void main(String args[])
    {
    	int[] answers = {2,3,2,1,3};
    	solution(answers);
    }
}
