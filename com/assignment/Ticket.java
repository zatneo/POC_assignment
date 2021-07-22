package com.assignment;

import java.util.Random;
import java.util.Scanner;


public class Ticket {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int r=3,c=9; 
		Scanner sc = new Scanner(System.in);
		int r,c;
		System.out.println("Enter number of row and column:");
		r=sc.nextInt();c=sc.nextInt();
		TicketGenerator ticket = new TicketGenerator(r,c);
		
		ticket.Randomize();
		ticket.fillTicket();
		System.out.println("This is your ticket\n");
		ticket.print();
		System.out.println();
		ticket.printArray();

	}

}
