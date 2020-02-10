package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @Title: WebDriverOperate.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年1月7日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class WebDriverOperate {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		openBrowser("chrome");
		// 访问百度的网址
		driver.get("http://www.baidu.com");
		// getCurrentUrl()
		//System.out.println(driver.getCurrentUrl());
		// 获取当前页面的url地址
		// getTitle()
		//System.out.println(driver.getTitle());
		// 获取当前页面的标题
		//获取当前页面的源代码
		//System.out.println(driver.getPageSource());
		
		//driver.findElement(By.id("kw")).sendKeys("柠檬班");
		//driver.findElement(By.id("su")).click();
		//获取打开新窗口之前的窗口句柄
		//System.out.println("打开新窗口之前的窗口句柄"+driver.getWindowHandle());
		//System.out.println("打开新窗口之前的所有窗口句柄"+driver.getWindowHandles());
		//Thread.sleep(2000);
		//在搜索的结果中点击柠檬班_腾讯课堂
		//driver.findElement(By.xpath("//a[text()='_腾讯课堂']")).click();
		//Thread.sleep(3000);
		//System.out.println("打开新窗口之后的窗口句柄"+driver.getWindowHandle());
		//System.out.println("打开新窗口之后的所有窗口句柄"+driver.getWindowHandles());
		//句柄 --》 窗口的标识
		//selenium默认在打开的第一个窗口中，将默认的关闭的
		//如果你要关闭第二个窗口，你要切换到第二个窗口中
		//driver.close();
		
		//navigate对象
		//Navigation navigate = driver.navigate();
		//Thread.sleep(2000);
		//navigate.to("https://www.jd.com");
		//Thread.sleep(2000);
		//涮新
		//navigate.refresh();
		//Thread.sleep(2000);
		//回退
		//navigate.back();
		//Thread.sleep(2000);
		//前进
		//navigate.forward();
		
		//window对象
		//Window window = driver.manage().window();
		//浏览器全屏
		//window.fullscreen();
		//浏览器最大化
		//window.maximize();
		//得到窗口的大小
		//Dimension dimension = window.getSize();
		//System.out.println(dimension.getWidth());
		//System.out.println(dimension.getHeight());
		//获取窗口的位置
		//Point point =  window.getPosition();
		//System.out.println(point.getX());
		//System.out.println(point.getY());
		//driver.
		
	}

	public static void openBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			// 相当于设置全局属性，能够让我们的代码认识到chromeDriver是存放在哪里
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
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
