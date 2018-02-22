package com.sendx.sgt;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class Signup extends Appium{

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

	//Click on Sign Up 

	@Test(priority=2)
	public void AccessContact() throws InterruptedException {

		Thread.sleep(5000);
		//driver.scrollToExact("Allow");
		if(checkElementPresence("//*[@index='1' and @text='Allow']",""));
		{
			driver.findElement(By.xpath("//*[@index='1' and @text='Allow']")).click();
		}
	}

	@Test(priority=2)
	public void SignUp() throws InterruptedException{


		Thread.sleep(5000);	
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/sign_up']")).click();
	}

	@Test(priority=3)
	public void Confirmation() throws InterruptedException{

		Thread.sleep(5000);
		driver.scrollTo("OK");
		if(checkElementPresence("//*[@index='1' and @text='OK']",""));
		{
			driver.findElement(By.xpath("//*[@index='1' and @text='OK']")).click();
		}

		Thread.sleep(5000);
		driver.scrollTo("Allow");
		if(checkElementPresence("//*[@index='1' and @text='Allow']",""));
		{
			driver.findElement(By.xpath("//*[@index='1' and @text='Allow']")).click();
		}
	}

	@Test(priority=4)
	public void First_Name(){
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_first_name']")).sendKeys("Abhinav");
	}

	@Test(priority=5)
	public void Last_Name(){
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_last_name']")).sendKeys("Garg");
	}

	@Test(priority=6)
	public void Country_Code() throws InterruptedException{
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/country_code']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='android:id/text1']")).click();
	}

	@Test(priority=7)
	public void Mobile_Number(){
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/mobile_number']")).sendKeys("8285314693");
	}


	@Test(priority=8)
	public void Email_Address(){
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_email_address']")).sendKeys("abhinavgarg003@gmail.com");
	}

	@Test(priority=9)
	public void Password(){
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_password']")).sendKeys("Qwerty@123");
	}

	@Test(priority=10)
	public void View_Password(){
		driver.findElement(By.xpath("//*[@index='7' and @resource-id='com.sendx.sgt:id/toggle_pass']")).click();
	}

	@Test(priority=11)
	public void Confirm_Password(){
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/input_password_confirm']")).sendKeys("Qwerty@123");
	}

	@Test(priority=12)
	public void View_Confirm_Password(){
		driver.findElement(By.xpath("//*[@index='9' and @resource-id='com.sendx.sgt:id/toggle_pass_confirm']")).click();
	}


	@Test(priority=14)
	public void Sign_Up(){

		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='14' and @resource-id='com.sendx.sgt:id/next']")).click();
	}

	//Automatic set verification code

	@Test(priority=16)
	public void Verification_Code() throws InterruptedException{

		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@index='4' and @text='Submit']")).click();

	}

	@Test(priority=18)
	public void Verification_Success() throws InterruptedException{

		Thread.sleep(5000);
		driver.scrollTo("OK");
		driver.findElement(By.xpath("//*[@index='0' and @text='OK']")).click();

	}

	//Welcome Screen
	@Test(priority=20)
	public void Welcome() throws InterruptedException{

		Thread.sleep(30000);
		driver.scrollTo("OK");
		driver.findElement(By.xpath("//*[@index='0' and @text='OK']")).click();

	}
}
