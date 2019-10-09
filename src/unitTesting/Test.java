package unitTesting;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
	        String[] first = s.nextLine().split(" ");
	        String res="";
	        int hr = 0;
	        int min = 0;
	        int[] time = new int[first.length];
	        int temp1 = -1;
	        int temp2 = -1;
	        int rest = -1;
	        String t2 = "";
	        for(int i=0;i<first.length;i++) {
	        	if(Integer.parseInt(first[i]) < 60)
	        		time[i] = Integer.parseInt(first[i]);
	        	
	        	
	        }
	        int len = time.length;
	        for(int j=0;j<len;j++) {
	        	for(int k=0;k<time.length;k++) {
	        		
	  
	        		if(j != k) {
	        			String prehour = time[j] +""+ time[k];
		        		int prehr = Integer.parseInt(prehour);
		        		if(prehr < 24) {
		        			if(prehr > hr) {
		        				hr = prehr;
		        				temp1 = time[j];
		        				temp2 = time[k];
		        				
		        				
		        			}
		        		}
		        		
		        		if(time[k] != temp1 || time[k] != temp2) {
		        			if(rest < time[k]) {
		        				int t = rest;
		        				 t2 = rest +""+time[k];
		        			}else {
		        				t2 = time[k]+""+rest;
		        			}
		        		}

	        		}
	        		
	        		
	        	}
	   
	        }
	        System.out.println(hr+":"+t2);
		
		  

	}

}
