package com.qa.friday.assignment;

import java.util.Set;
import java.util.TreeSet;

public class FindIngMissingNumberInArray {
	public static void main(String[] args) {
		
		int[] arr= {1,2,3,5,7,9,12,14,15,16,20};
		
		Set<Integer> missingnumber=new TreeSet<Integer>();
		
		
		for(int i=1; i<=20; i++) {
			
			boolean flag=false;
			for(int j=0; j<arr.length; j++) {
				if(i==arr[j]) {
					flag=true;
					break;
				}
			}
			if(flag==false) {
				missingnumber.add(i);
			}
		}
		System.out.println(missingnumber);
		
	}

}
