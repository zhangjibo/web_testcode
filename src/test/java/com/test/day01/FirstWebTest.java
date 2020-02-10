package com.test.day01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @Title: FirstWebTest.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年1月2日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class FirstWebTest {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		openBrowser("chrome");
		// 访问百度的网址
		driver.get("http://www.baidu.com");
		WebElement webElement = driver.findElement(By.id("kw"));
		
	}

	public static void openBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			// 相当于设置全局属性，能够让我们的代码认识到chromeDriver是存放在哪里
//			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");//TODO mac环境需注释
			// 1、打开chrome浏览器
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			// 设置firefox可执行文件的路径
			System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
			// 设置firefox驱动的路径
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			// 1、打开Firefox ，实例化fireFoxDriver
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			// 忽略掉保护模式
			// DesiredCapabilities-->赋予给浏览器一个额外的能力
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			// 忽略掉浏览器缩放
			desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			// 设置IE驱动的路径
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver(desiredCapabilities);
		}
	}

}
