package main;

import java.util.Scanner;

import model.HDDPlaningAccess;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Select algorithm: \n"
				+ "#1 FCFS\n"
				+ "#2 SCAN\n"
				+ "#3 C_SCAN\n"
				+ "#4 All");
		int a = scan.nextInt();
		scan.nextLine();
		
		System.out.println("\nType requests in one line separated by space: \n");
		String[] lines = scan.nextLine().split(" ");
		
		int[] requests = new int[lines.length];
		for(int i=0; i<lines.length; i++) {
			requests[i] = Integer.parseInt(lines[i]);
		}
		
		System.out.println("\nType pos: \n");
		int pos = scan.nextInt();
		scan.nextLine();
		
		int max=0;
		int min=0;
		boolean direcctionUp=true;
		if(a!=1) {
			System.out.println("\nType max: \n");
			max = scan.nextInt();
			scan.nextLine();
			
			System.out.println("\nType min: \n");
			min = scan.nextInt();
			scan.nextLine();
			
			if(a==2 || a==4) {
				System.out.println("\n Select direction: \n"
						+ "#1. Up"
						+ "\n#2. Down");
				int dirrection = scan.nextInt();
				scan.nextLine();
				
				direcctionUp = dirrection==1;
			}
		}
		
		HDDPlaningAccess calculator = new HDDPlaningAccess();
		
		int result1=calculator.FCFS(requests, pos);
		int result2=calculator.SCAN(requests, pos, max, min, direcctionUp);
		int result3=calculator.C_SCAN(requests, pos, max, min);
		
		switch(a) {
			case 1:
				System.out.println("\n\n Traveled units: "+result1);
				break;
			case 2:
				System.out.println("\n\n Traveled units: "+result1);
				break;
			case 3:
				System.out.println("\n\n Traveled units: "+result1);
				break;
			case 4:
				System.out.println("\n\n Traveled units: \n"
						+ "FCFS: "+result1+"\n"
						+ "SCAN: "+result2+"\n"
						+ "C_SCAN: "+result3);
		}
	}
}
