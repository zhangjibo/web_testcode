package com.test.day02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @Title: ElementLocate.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年1月4日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ElementLocate {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		//1、打开chrome浏览器
		openBrowser("chrome");
		//2、访问百度网页
		driver.get("http://www.baidu.com");
		//怎么看元素的属性是不是唯一的
		//1、F12的搜索ctrl+F
		//2、driver.findElements 返回集合的大小为一 
		//3、输入搜索关键字
		//(1),ID定位，一般来说在页面当中id是唯一 身份证号码
		WebElement webElement = driver.findElement(By.id("kw"));
		webElement.sendKeys("柠檬班");
		//(2)tagName 标签名 -->找到的元素会是多个 基本上不用
		List<WebElement> webElements = driver.findElements(By.tagName("input"));
		System.out.println(webElements.size());
		for (WebElement webElement1 : webElements) {
			System.out.println(webElement1.getAttribute("type"));

		}
		//(3)name定位：name属性 -->姓名
		//driver.findElement(By.name("wd")).sendKeys("柠檬班");
		//(4)className定位
		//driver.findElement(By.className("s_ipt")).sendKeys("柠檬班");
		// Compound class names not permitted 复合类名错误（class属性有多个，以空格隔开）
		// 解决方案：以其中一个唯一的去定位
		//driver.findElement(By.className("s_btn")).click();
		//(5)linkText定位：超链接文本
		//driver.findElement(By.linkText("新闻")).click();
		//(6)partialLinkText定位：超链接部分文本定位
		//driver.findElement(By.partialLinkText("闻")).click();
		//driver.findElement(By.partialLinkText("免费注册")).click();
		//driver.findElement(By.partialLinkText("新闻")).click();
		
		//cssSelector元素定位
		//(1) tagName
		//List<WebElement> webElements = driver.findElements(By.cssSelector("input"));
		//System.out.println(webElements.size());
		//(2) ID
		//driver.findElement(By.cssSelector("#kw")).sendKeys("柠檬班");
		//(3) className -->划重点:cssSelector 一定要记得加上.
		//driver.findElement(By.cssSelector(".bg.s_btn")).click();
		
		//(4) 属性选择器定位
		//driver.findElement(By.cssSelector("input[autocomplete='off']")).sendKeys("柠檬班");
		//input --》标签名  [] --》属性选择  autocomplete='off'
		// class属性定位 属性选择 则样式不需要加.
		//driver.findElement(By.cssSelector("input[class='bg s_btn']")).click();
		//多属性选择
		//driver.findElement(By.cssSelector("input[maxlength='255'][autocomplete='off']")).sendKeys("柠檬班");
	
		//xpath相对定位
		//单属性   //*[@name='wd']
		//多属性 //*[@name='wd' and @maxlength='100']
		//全部文本值定位 //*[text()='新闻']
		//部分文本/属性匹配定位  contains -->包含  //*[contains(text(),'闻')]
		
	}

	public static void openBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			// 相当于设置全局属性，能够让我们的代码认识到chromeDriver是存放在哪里
//			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
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
