package com.test.day03;

import java.util.concurrent.TimeUnit;

import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Title: ElementWait.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年1月7日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ElementWait {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// 打开浏览器--》实例化driver
		openBrowser("chrome");
		// 设置隐式等待，规定的时间的为5S
		// 隐式等待：一直不断的在规定的时间内去找元素，只要找到为止，如果超过了规定时间，那么就会报错
		// 针对于全局的元素查找
		// 粒度比较粗
		// 等待条件--》元素是否可见 、元素是否可编辑...
		// 全局性配置
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 访问百度的网址
		driver.get("http://www.baidu.com");

		// driver.findElement(By.id("kw")).sendKeys("柠檬班");
		// driver.findElement(By.id("su")).click();

		// Thread.sleep(5000);
		// 在搜索的结果中点击柠檬班_腾讯课堂,默认此元素需要时间加载出来，主要问题：代码和元素显示的时间不同步

		// 显示等待
		// WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		// until..:表示满足。。。条件为止
		// 1、elementToBeClickable -->元素可被点击
		// 2、visibilityOfElementLocated --》元素可见
		// 3、presenceOfElementLocated -->元素在html文档存在
		// 4、frameToBeAvailableAndSwitchToIt -->iframe元素可用
		// WebElement webElement = webDriverWait
		// .until(ExpectedConditions.visibilityOfElementLocated(By.id("kw")));
		// webElement.sendKeys("柠檬班");
		// driver.findElement(By.xpath("//a[text()='_腾讯课堂']")).click();

		//隐式等待 VS 显示等待
		//1、超时的话，隐式等待抛出NoSuchElementException，显示等待超时会抛出TimeOutException
		
		
		// 1、点击设置
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='u1']//a[text()='设置']")).click();
		Thread.sleep(2000);
		//2、给输入框输入数据
		driver.findElement(By.id("kw")).sendKeys("柠檬班");
		Thread.sleep(2000);
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		WebElement webElement = webDriverWait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='高级搜索']")));
		webElement.click();  //这一行报错
		
		//如果代码中设置的了隐式等待，并且对应的元素设置了显示等待（尽量不要混用）
		//1、先以显示等待为准
		//2、隐式等待找元素
		//建议大家在项目中尽量去用显示等待
		//框架优化--》显示等待代码多的问题
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
