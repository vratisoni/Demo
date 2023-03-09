package demo;

import java.util.Arrays;

public class removeduplicatearray {
	public static int[] removeduplicate(int[] a)
	{
		
		
		int n = a.length;
		int[] temp = new int[n];
		int j=0; ;
		for(int i =0;i<n-1;i++)
		{
			if(a[i]!=a[i+1])
			{
				temp[j++]=a[n-1];
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] a = {10,20,10,30};
Arrays.sort(a);
int[] result = removeduplicate(a);
for(int i =0;i<result.length;i++)
{
	if(result[i]!=0)
	{
		System.out.println(result[i]+" ");
	}
}
	}

}
