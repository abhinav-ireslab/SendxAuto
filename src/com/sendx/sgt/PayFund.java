package com.sendx.sgt;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PayFund extends Login {

	@Test
	public Boolean checkElementPresence(String xpath,String id){

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MILLISECONDS);
		boolean exists ;
		if(xpath!=""){
			exists = driver.findElements( By.xpath(xpath)).size() != 0;

		}else{
			exists = driver.findElements( By.id(id)).size() != 0;

		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return exists;
	}

	@Test(priority=15)
	public void Currency_Selection() throws InterruptedException{
		Drawer PayFund = new Drawer();
		PayFund.PayFund();
		
		//Select country currency symbol
		 driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/country_spinner']")).click();
		 List ListofActivity = driver.findElements(By.xpath("//*[@class='android.widget.CheckedTextView' and @resource-id='android:id/text1']"));
		 driver.scrollTo("ETH");
		 int numOfFrames = ListofActivity.size(); 	
		 System.out.println("No. of Currency Symbols: " +ListofActivity.size()); 	
		 driver.findElement(By.xpath("//*[@index='1' and @resource-id='android:id/text1']")).click();
	}
	
	@Test(priority=17)
	public void Add_Money (){


		//Check User can add money less than 1 SDX	
		/*		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).sendKeys(".5");
		//click confirm button
		driver.findElement(By.xpath("//*[@index='7' and @resource-id='com.sendx:id/confirm_button']")).click();
		System.out.println("Minimum 1.00 token required for top up");
		 */
		//Check User can add money more than 100 SDX	
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).clear();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).sendKeys("101");
		driver.hideKeyboard();
		//click confirm button
		driver.findElement(By.xpath("//*[@index='11' and @resource-id='com.sendx.sgt:id/confirm_button']")).click();


		//Check User can add money more than 1 SDX	
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).clear();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/token_amount']")).sendKeys("1.5");
		driver.hideKeyboard();

	}
	
	@Test(priority=19)
	public void Payment_Method(){
		driver.findElement(By.xpath("//*[@index='0' and @text='PayPal']")).click();
	}
	
	@Test(priority=21)
	public void Confirm(){
	//click confirm button
	driver.findElement(By.xpath("//*[@index='11' and @resource-id='com.sendx.sgt:id/confirm_button']")).click();
	
	}
	
}
