package dynammic;

import java.util.Scanner;

public class CountWaysToReachNSteps {
	
	int [] arr =  new int[]{1,2}; 
	
	public static void main(String [] args){
		int [] arr =  new int[]{1,2};
		Scanner sc =new Scanner(System.in);
		System.out.println(countSteps(5,arr,1));
		
	}
	
	public static int countSteps(int steps,int [] arr,int m){
		
		if(steps<=0){
			return 0;
		}
		if(m<0){
			return 0;
		}
		
		if(steps==1){
			return 1;
		}
		return countSteps(steps,arr,m-1)+countSteps(steps-arr[m],arr,m); 
		
	}

}
