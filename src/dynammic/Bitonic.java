package dynammic;

import java.util.Arrays;

public class Bitonic {
	
	/*
	3,10,2,1,20 
	*/

	public static void main(String [] args){
		
		int [] array = new int[]{25,30,35,29,15,50};
		longestIncreasingSubsequence(array,6);
		longestDecreasingSubsequence(array,6);
		
		
	}
	public static void longestDecreasingSubsequence(int [] array,int n){
		int [] DIS = new int[6];
		Arrays.fill(DIS, 1);
		int max=0,high=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(array[i]<array[j] && high<DIS[i]){
					high = DIS[j];
				}
				
			}
			DIS[i]  =high+1;
		}
		for(int i=0;i<n;i++){
			if(DIS[i]>max){
				max = DIS[i];
			}
		}
		System.err.println("Highest DIS ::"+max);
	}


	public static void longestIncreasingSubsequence(int [] array,int n){
		int [] LIS = new int[6];
		Arrays.fill(LIS, 1);
		int max=0,high=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(array[i]>array[j] && high<LIS[i]){
					high = LIS[j];
				}
				
			}
			LIS[i]  =high+1;
		}
		for(int i=0;i<n;i++){
			if(LIS[i]>max){
				max = LIS[i];
			}
		}
		System.err.println("Highest LIS ::"+max);
	}
	
	

}
