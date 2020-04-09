/*********************************************************************************************************************
     **
     **  Sqrt Decomposition algorithm
     **  Calculate min between given range
     **  Input in the form of array
     **  Output is minimum from range
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main
{
	//store minimum in each block of size
    static int[]block=new int[10000];

	//input array
    static int[]a;

	//block size
    static int size;

    public static int query(int l,int r)
    {
        int min=Integer.MAX_VALUE;
		
		//while l doesnt come in start point of block
        while(l<=r && (l%size!=0))
        {
            min=Math.min(min,a[l]);
            l++;
        }

		//compare with block minimum till not in same block
        while((l+size)<=r)
        {
            min=Math.min(min,block[l/size]);
            l+=size;
        }

		//compare in same block till l!=r
        while(l<=r)
        {
            min=Math.min(min,a[l]);
            l++;
        }

        return min;

    }

	public static void main (String[] args) throws java.lang.Exception
	{

	    int n=10;
		a=new int[]{2,1,3,2,4,5,12,34,23,12};

		//size is square root of input array
		size=(int)Math.sqrt(n);
		
		Arrays.fill(block,Integer.MAX_VALUE);
		
		//calculate minimum in each block
		for(int i=0;i<n;i++)
		{
		    block[i/size]=Math.min(block[i/size],a[i]);
		}
		
		System.out.println( "Minimum between 1 to 3 is : " + query(1,3) );
		System.out.println( "Minimum between 4 to 8 is : " + query(4,8) );
		System.out.println( "Minimum between 1 to 9 is : " + query(2,9) );

	}
}