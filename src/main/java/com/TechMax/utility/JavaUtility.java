package com.TechMax.utility;

import java.util.Date;
import java.util.Random;

/**
 *   it's Contains java specific libraries like getRandomdata & getsystemDate   etc
 * @author Deepak
 *
 */

public class JavaUtility {

	
		/**
		 * its used to generate the random number with in the range of 1000
		 * @return
		 */
		public String getRanDomNumber() {
			Random ranDom = new Random();
			int ranDomNum =  ranDom.nextInt(1000);
			String ranString = Integer.toString(ranDomNum);
			return ranString;
		
		}
		/**
		 *  its used to get the current system date based on YYYY-MM-DD formate
		 * @return
		 */
		public String  getSystemDate() {
			Date date = new Date();
			String currentDate = date.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");
			String time=arr[3];
			String[] hms = time.split(":");
			String sec = hms[2];
			String min = hms[1];
			String hr = hms[0];
			
			String yyyy = arr[5];
			String dd = arr[2];
			@SuppressWarnings("deprecation")
			int mm = date.getMonth()+1;
		
				String formate = yyyy+"-"+mm+"-"+dd+"_"+hr+min+sec;
				return formate;
		}
		/**
		 *  its used to get the current system date based on DD-MM-YYYY format 
		 * @return
		 */
		public String  getSystemDateInIST() {
			Date date = new Date();
			String currentDate = date.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");
			String time=arr[3];
			String[] hms = time.split(":");
			String sec = hms[2];
			String min = hms[1];
			String hr = hms[0];
			String yyyy = arr[5];
			String dd = arr[2];
			@SuppressWarnings("deprecation")
			int mm = date.getMonth()+1;
		
				String formate = dd+"-"+mm+"-"+yyyy+"_"+hr+min+sec;
				return formate;
		}
		

	


}
