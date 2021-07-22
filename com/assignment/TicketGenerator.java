package com.assignment;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TicketGenerator {
	int row,col;
	int[][] ticket,visited;
	TicketGenerator(int r,int c){
		this.row=r;
		this.col=c;
		 ticket= new int[r][c];
		 
		
	}
	private boolean checkRow(int r,int c) {
		// this method check whether given column filled accordingly for all row
		int cnt= 0;
		for(int i=0;i<this.row;i++) {
			if(this.ticket[i][c]==1)cnt++;
		}
		if(cnt>=2)return false;
		return true;
	}
	private boolean checkCol(int r,int c) {
		// this method check whether given row filled accordingly for all column
		int cnt = 0;
	
		for(int i=0;i<this.col;i++) {
			if(this.ticket[r][i]==1)cnt++;
		}
		if(cnt>=5)return false;	
		
		return true;
		
	}
	public void printArray() {
		for(int[] arr:this.ticket) {
			for(int a:arr) {
				
				System.out.print(a+"    ");
			}
			
			System.out.println();
		}
	}
	public void print() {
	
		for(int[] arr:this.ticket) {
			for(int a:arr) {
				if(a==0)System.out.print(",");
				else System.out.print(a+",");
			}
			
			System.out.println();
		}

	}
	
	public void fillTicket(){// To fill ticket according given condition
		
		for(int i=0;i<this.col;i++) {
			// cell must be filled with (column-1)*10+1 to col*10 eg . for col-1 range must be 1 to 10
			
			int start=i*10+1;	
			int end=(i+1)*10+1;
			
			for(int j=0;j<this.row;j++) {
				if(this.ticket[j][i]==1) {
					
					// Random in range is referred from stackoverflow link given below
					// https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
		
					int val = ThreadLocalRandom.current().nextInt(start,end);
					this.ticket[j][i]=val; 
					
				}
			}
		}
	
	}
	public void Randomize() {
		/* 
			 This method is for randomly choosing cell of ticket while satisfying condition
			 condition : 
			 1 - each row can have maximum 5 value filled
			 2 - each column can have maximum 2 value filled 
			 
		 */
		
		Random rand = new Random(); // for picking a random number
		int c=this.col,r=this.row;

		HashSet <Integer> visited_col= new HashSet<>(); // this is to check visited column
		
		// we will itrate over column to fill ticket
		
		while(true){
			if(visited_col.size()== this.col)break; // if all column visited then break
			
			int col = rand.nextInt(c);
			visited_col.add(col);
			
			int row_cnt=0;
			HashSet <Integer> visited_row = new HashSet<>(); // this is to check visited row
			
			while(true) {
				
				if(row_cnt==2)break; // if column have 2 cell(row) filled then break
				if(visited_row.size()== this.row)break;// if all row visited then break
				int row = rand.nextInt(r);
				visited_row.add(row);
				try {
					boolean chk_row,chk_col;
					chk_row= checkRow(row,col);
					chk_col = checkCol(row,col);
					if(chk_row && chk_col) {
						this.ticket[row][col]=1; 
					
						row_cnt++;
					}
				}
				catch(IndexOutOfBoundsException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
		
	
	}
}
