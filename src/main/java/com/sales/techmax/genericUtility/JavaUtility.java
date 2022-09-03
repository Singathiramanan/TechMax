package com.sales.techmax.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class JavaUtility {
	public static String getRanDomNumber(int range) {
		Random ranDom = new Random();
		int ranDomNum =  ranDom.nextInt(range);
		String ranDomNumber = Integer.toString(ranDomNum);
		return ranDomNumber;
	
	}
	/**
	 *  its used to get the current system date based on YYYY-MM-DD format
	 * @return
	 */
	public String  getSystemDate() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		
		String yyyy = arr[5];
		String dd = arr[2];
		@SuppressWarnings("deprecation")
		int mm = date.getMonth()+1;
	
			String formate = yyyy+"-"+mm+"-"+dd;
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
		
		String yyyy = arr[5];
		String dd = arr[2];
		@SuppressWarnings("deprecation")
		int mm = date.getMonth()+1;
	
			String formate = dd+"-"+mm+"-"+yyyy;
			return formate;
	}
	public String  getSystemDateTime() {
		Date date = new Date();
		String currentDate = date.toString();
		//System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
		String time = arr[3].replace(":", "");
			String formate = dd+mm+yyyy+"&"+time;
			return formate;
	}


	public void DateStock(String date, WebElement dateStockWE) throws InterruptedException, AWTException {
		dateStockWE.click();
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_LEFT);
		rob.keyRelease(KeyEvent.VK_LEFT);
		rob.keyPress(KeyEvent.VK_LEFT);
		rob.keyRelease(KeyEvent.VK_LEFT);
		String date1 = date.replace("", "");
		char[] dateArr = date1.toCharArray();
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
}

		
			
	



