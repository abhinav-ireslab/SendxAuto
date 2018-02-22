package com.sendx.sgt;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class UpdateProfile extends Login{
	
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
	public void Update_First_Name () throws InterruptedException, IOException{
	Drawer Prof = new Drawer();
	Prof.Profile();
		
	driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_first_name']")).click();
	driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_first_name']")).clear();
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@index='5' and @resource-id='com.sendx.sgt:id/save']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_first_name']")).sendKeys("Akash");
	}
		
	@Test(priority=15)
	public void Update_Last_Name() throws InterruptedException{

		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_last_name']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_last_name']")).clear();
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='5' and @resource-id='com.sendx.sgt:id/save']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_last_name']")).sendKeys("Garg");
		
	}
	
	@Test(priority=17)
	public void Update_Email() throws InterruptedException{
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_email_address']")).click();
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_email_address']")).clear();
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='5' and @resource-id='com.sendx.sgt:id/save']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_email_address']")).sendKeys("abhinavgarg003@gmail.com");
		driver.hideKeyboard();
	}

	@Test(priority=19)
	public void Save(){

		driver.findElement(By.xpath("//*[@index='5' and @resource-id='com.sendx.sgt:id/save']")).click();
		
	}
	
}
