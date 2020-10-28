/******************************************************************************
A leetcode Problem
Major Element-> element having more than n/2 occurrene in an array

This problem is mostly asked in Big Tech Companies like Google, Amazon
*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) {
		    arr[i]=sc.nextInt();
		}
		int maxElement=arr[0];   //initially let major element
		int counter=1;
		
		//check for possible major element
		for(int i=1; i<n; i++) {
            if(arr[i]==maxElement) {
                counter++;
            } else if(counter>0) {
                counter--;
            } else {
                counter=1;
                maxElement=arr[i];
            } 
		}
		int maxOccur=0;
		if(counter>0) {
		    for(int element:arr) {
		        if(element==maxElement) 
		            maxOccur++;
		    }
		}
		if(maxOccur>n/2) {
		    System.out.println("Major Element is: "+maxElement);
		}else {
		    System.out.println(" No Major Element is");
		}
	}
}

//Input-1: 6
//         2 2 2 4 5 2 
//Output-1: Major Element is: 2

//Input-2: 9
//         4 4 4 4 5 2 4 4 5 
//Output-2: Major Element is: 4

//Time Complexity: O(n)
