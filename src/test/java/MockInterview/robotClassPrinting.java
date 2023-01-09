package MockInterview;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

public class robotClassPrinting {
	@Test
	public void printingUsingRobotClass() throws AWTException{
		System.out.println("Enter the word");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_H);
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		System.out.println();
	}
}
