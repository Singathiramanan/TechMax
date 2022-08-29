package com.TechMax.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 *   it's Contains java specific libraries like getRandomdata & getsystemDate   etc
 * @author Deepak
 *
 */

public class JavaUtility {
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
		
		public void DateStock(WebElement dateStockWE) throws InterruptedException, AWTException {
			dateStockWE.click();
			Robot rob=new Robot();
			rob.keyPress(KeyEvent.VK_LEFT);
			rob.keyRelease(KeyEvent.VK_LEFT);
			rob.keyPress(KeyEvent.VK_LEFT);
			rob.keyRelease(KeyEvent.VK_LEFT);
			Date date1 = new Date(0);
			String currentDate = date1.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");
			String yyyy = arr[5];
			String dd = arr[2];
			int mm = date1.getMonth()+1;
		
				String formate = mm+dd+yyyy;
				System.out.println(formate);
			char[] dateArr = formate.toCharArray();
			Thread.sleep(2000);
			for (int i = 0; i < dateArr.length; i++) {
				int num = Character.getNumericValue(dateArr[i]);
				Robot rob1=new Robot();
				switch (num) {
				case 0:
					rob1.keyPress(KeyEvent.VK_0);
					rob1.keyRelease(KeyEvent.VK_0);
					Thread.sleep(2000);
					break;
				case 1:
					rob1.keyPress(KeyEvent.VK_1);
					rob1.keyRelease(KeyEvent.VK_1);
					break;
				case 2:
					rob1.keyPress(KeyEvent.VK_2);
					rob1.keyRelease(KeyEvent.VK_2);
					break;
				case 3:
					rob1.keyPress(KeyEvent.VK_3);
					rob1.keyRelease(KeyEvent.VK_3);
					break;
				case 4:
					rob1.keyPress(KeyEvent.VK_4);
					rob1.keyRelease(KeyEvent.VK_4);
					break;
				case 5:
					rob1.keyPress(KeyEvent.VK_5);
					rob1.keyRelease(KeyEvent.VK_5);
					break;
				case 6:
					rob1.keyPress(KeyEvent.VK_6);
					rob1.keyRelease(KeyEvent.VK_6);
					break;
				case 7:
					rob1.keyPress(KeyEvent.VK_7);
					rob1.keyRelease(KeyEvent.VK_7);
					break;
				case 8:
					rob1.keyPress(KeyEvent.VK_8);
					rob1.keyRelease(KeyEvent.VK_8);
					break;
				case 9:
					rob1.keyPress(KeyEvent.VK_9);
					rob1.keyRelease(KeyEvent.VK_9);
					break;
				default:
					System.out.println("INVALID CHAR");
				}
			}
		}
		/**
		 * its used to generate the random number with in the range 
		 * @return
		 */
		public static String getRanDomNumber(int range) {
			Random ranDom = new Random();
			int ranDomNum =  ranDom.nextInt(range);
			String randomInteger = Integer.toString(ranDomNum);
			return randomInteger;
		
		}


}
