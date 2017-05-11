package graph;

import java.util.ArrayList;
import java.util.Scanner;


public class SteppingNumbers {
	ArrayList<Integer> steppingNumber =  new ArrayList<Integer>();
	public static void main(String [] args){
		int n=30,m=50;
		SteppingNumbers steppingNumbers = new SteppingNumbers();
		steppingNumbers.steppingNumbers(n,m);
		for(int stepingNum:steppingNumbers.steppingNumber){
			System.out.println("Stepping Numbers in range :: "+n+" and :: "+m+" are :: "+stepingNum);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		}
	}
	
	public void steppingNumbers(int n,int m){
		for(int i=0;i<9;i++){
			dfs(i,n,m);
		}
	}
	
	public  void dfs(int currNum,int lowerLimit,int upperLimit){
		int ones=0,stepNumA=0,stepNumB=0;
		if(currNum<lowerLimit || currNum>upperLimit){
			return;
		}
		if(currNum<0 || currNum>upperLimit){
			return;
		}
		steppingNumber.add(currNum);
		ones =  currNum%10;
		stepNumA = (currNum*10)+ones+1;
		stepNumB = (currNum*10)+ones-1;
		if(ones==0){
			dfs(stepNumA,lowerLimit,upperLimit);
		}
		else if(ones==9){
			dfs(stepNumB,lowerLimit,upperLimit);
		}else{
			dfs(stepNumA,lowerLimit,upperLimit);
			dfs(stepNumB,lowerLimit,upperLimit);
		}
	}
}
