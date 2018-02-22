package com.sendx.sgt;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;


public  class Appium {

	public static AndroidDriver driver;
	public static DesiredCapabilities capabilities =new DesiredCapabilities();
	DesiredCapabilities capabilities1 = DesiredCapabilities.android();


	@BeforeClass
	public static void SetUp() throws MalformedURLException {
		System.out.println("before class");
		// Created object of DesiredCapabilities class.
		//DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("device", "Android");

		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", "S5");

		// Set BROWSER_NAME desired capability. It's Android in our case here.
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		// Set android VERSION desired capability. Set your mobile device's OS version.
		capabilities.setCapability("VERSION", "6.0");

		// Set android platformName desired capability. It's Android in our case here.
		capabilities.setCapability("platformName", "Android");

		// Set your application's appPackage if you are using any other app. 
		capabilities.setCapability("appPackage", "com.sendx.sgt");

		// Set android appActivity desired capability.
		capabilities.setCapability("appActivity", "com.sendx.sgt.activity.SplashActivity");
		//capabilities.setCapability("appActivity", ".activity.RegisterActivity");
		//capabilities.setCapability("app-wait-activity",".activity.SignupActivity");

		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string. 
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

	}
	@Test
	public void test () throws InterruptedException {
		Thread.sleep(500);
		System.out.println("Appium process start");
	}

}

