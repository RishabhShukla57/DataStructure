package graph;

import java.util.Arrays;

public class BlackShapes {
	
	static int [] di = new int[]{1,-1,0,0};
	static int [] dj = new int[]{0,0,1,-1};
	
	
	public static void main(String [] args){
		char [][] multiDimensionalArray = new char[][]{
			{'O','O','O','X','O','O','O'},{'O','O','X','X','O','X','O'},{'O','X','O','O','O','X','O'}
		};
		int row=3,count=0;
		int column=7;
		int [][] traversed = new int[3][7];
		//Arrays.fill(traversed, 0);
		for(int i=0;i<3;i++){
			for(int j=0;j<7;j++){
				traversed[i][j] =0;
			}
		}
		
		for(int i=0;i<3;i++){
			for(int j=0;j<7;j++){
				if(traversed[i][j]==0 && multiDimensionalArray[i][j]=='X'){
					dfs(i,j,row,column,traversed,multiDimensionalArray);
					count++;
				}
			}
			
		}
		System.out.println("Count :: "+count);
	}
	
	public static  void dfs(int currRow,int currColumn,int row,int column,int [][] traversed,char [][] multiDimensionalArray){
		int ii=0;
		int jj=0;
		traversed[currRow][currColumn] = 1;
		for(int i=0;i<4;i++){
			ii = currRow+di[i];
			jj = currColumn+dj[i];
			
			if(isValid(ii, jj,row ,column) && traversed[ii][jj]==0 && multiDimensionalArray[ii][jj]=='X' ){
				dfs(ii, jj, row, column, traversed, multiDimensionalArray);
			}
		}
	}
		
	public static boolean isValid(int i,int j,int row ,int column){
		if(i<row && j<column && i>0 && j>0){
			return true;
		}
		return false;
	}
	
}
