package com.sendx.sgt;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Drawer extends Login implements DrawerMethod{
	
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
	
	@Test(priority=13)
	public void Drawer_Button(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
	}

	@Test(priority=14)
	public void Home(){
		driver.findElement(By.xpath("//*[@index='0' and @text='Home']")).click();
	}
	
	
	@Test(priority=15)
	public void Profile(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Profile']")).click();
	}
	
	
	@Test(priority=16)
	public void PayFund(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Pay/Fund']")).click();
	}
	
	
	@Test(priority=18)
	public void SendPay(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Send/Pay']")).click();
	}
	
	@Test(priority=19)
	public void Transfer_Out(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Transfer Out']")).click();
	}
	
	
	@Test(priority=20)
	public void Transactions(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Transactions']")).click();
	}
	
	
	@Test(priority=21)
	public void Locate_Agent(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Locate Agent']")).click();
	}
	
	@Test(priority=22)
	public void Term_and_condition() throws InterruptedException{
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Terms and Conditions']")).click();
		
	}
	
	@Test(priority=23)
	public void back() throws InterruptedException{
		Thread.sleep(14000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	@Test(priority=24)
	public void Help() throws InterruptedException{
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Help']")).click();
	
	}
	
	@Test(priority=25)
	public void backHelp() throws InterruptedException{	
		Thread.sleep(14000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}
	
	@Test(priority=26)
	public void Redirect_Drawer_Button(){
		driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
	}
	
	@Test(priority=27)
	public void LogOut(){
		//driver.findElement(By.xpath("//*[@index='0' and @content-desc='Open navigation drawer']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @text='Sign Out']")).click();
	}
}
