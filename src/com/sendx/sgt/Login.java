package com.sendx.sgt;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Login extends Appium {


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

	@Test(priority=0)
	public void Login_Allow() throws InterruptedException{


		//Allow access your contacts
		Thread.sleep(5000);
		driver.scrollTo("Allow");
		if(checkElementPresence("//*[@index='1' and @text='Allow']",""));
		{
			driver.findElement(By.xpath("//*[@index='1' and @text='Allow']")).click();
		}
		
	}
	
	@Test(priority=1)
	public void SwitchMobileNumber(){
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/mobile_sign']")).click();
	}

	
	
	@Test(priority=2)
	public void CountryCode() throws InterruptedException{

		//Enter Country Code
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@index='0' and @resource-id='com.sendx.sgt:id/country_code']")).click();
		Thread.sleep(50);
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='android:id/text1']")).click();
		System.out.println("Select country code");

	}


		@Test(priority=3)
	public void InvalidUsername_ValidPassword() throws InterruptedException{

		//Invalid UserName and Valid Password

		//Enter UserName
		WebElement el = driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']"));
		el.sendKeys("9897095000");
		System.out.println("Invalid Username:" + el.getText());

		//Enter Password

		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("Qwerty@123");
		System.out.println("Valid Password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Invalid credentials']")).getText(),"Invalid credentials");		

	}

	@Test(priority=4)
	public void ValidUsername_InvalidPassword() throws InterruptedException{

		//Valid UserName and Invalid Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("9897095008");
		System.out.println("Valid Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("Qwerty");
		System.out.println("Invalid password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Please enter valid password']")).getText(),"Please enter valid password");		

	}

	@Test(priority=5)
	public void InValidUsername_InavlidPassword() throws InterruptedException{

		//Invalid UserName and Invalid Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("98970950");
		System.out.println("Invalid Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("qwerty");
		System.out.println("Invalid password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Please enter valid mobile number']")).getText(),"Please enter valid mobile number");		

	}

	@Test(priority=6)
	public void ValidUsername_BlankPassword() throws InterruptedException{

		//Valid UserName and Blank Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("9897095008");
		System.out.println("Valid Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("");
		System.out.println("Blank password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Please enter valid password']")).getText(),"Please enter valid password");		

	}

	@Test(priority=7)
	public void BlankUsername_ValidPassword() throws InterruptedException{

		//Blank UserName and Valid Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("");
		System.out.println("Balnk Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("Qwerty@123");
		System.out.println("Valid password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Please enter valid mobile number']")).getText(),"Please enter valid mobile number");		

	}

	@Test(priority=8)
	public void InvalidUsername_BlankPassword() throws InterruptedException{

		//Invalid UserName and Blank Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("9897095");
		System.out.println("Invalid Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("");
		System.out.println("Blank password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Please enter valid mobile number']")).getText(),"Please enter valid mobile number");		

	}

	@Test(priority=9)
	public void BlankUsername_InvalidPassword() throws InterruptedException{

		//Blank UserName and Invalid Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("");
		System.out.println("Blank Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("Qwerty");
		System.out.println("Invalid password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Please enter valid mobile number']")).getText(),"Please enter valid mobile number");		

	}

	@Test(priority=10)
	public void BlankUsername_BlankPassword() throws InterruptedException{

		//Blank UserName and Blank Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("");
		System.out.println("Blank Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("");
		System.out.println("Blank password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='com.sendx.sgt:id/snackbar_text' and @text='Please enter valid mobile number']")).getText(),"Please enter valid mobile number");		
	}
	

	@Test(enabled=false, priority=11)
	public void ValidUsername_ValidPassword() throws InterruptedException{

		//Valid UserName and Valid Password

		//Enter UserName
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).click();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).clear();
		driver.findElement(By.xpath("//*[@index='2' and @resource-id='com.sendx.sgt:id/email_id']")).sendKeys("8285314693");
		System.out.println("Valid Username");

		//Enter Password
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).clear();		
		driver.findElement(By.xpath("//*[@index='1' and @resource-id='com.sendx.sgt:id/password']")).click();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAPS_LOCK);
		driver.getKeyboard().sendKeys("Qwerty@123");
		System.out.println("Valid password");


		//Click on Login button
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@index='3' and @resource-id='com.sendx.sgt:id/login_button']")).click();
		Thread.sleep(1000);

	}
}
