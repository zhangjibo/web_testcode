package com.lemon.common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * @Title: BaseCase.java
 * @Description: TODO(用例的共性操作-打开浏览器、关闭浏览器、刷新、最大化浏览器)
 * @author 歪歪欧巴
 * @date 2020年2月6日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BaseCase {

	// 日志对象
	public Logger logger = Logger.getLogger(BaseCase.class);

	public static String browser = "";

	// 驱动对象，在整个程序运行期间都是存在的
	public static WebDriver driver;

	public void openBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			// 相当于设置全局属性，能够让我们的代码认识到chromeDriver是存放在哪里
//			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			// 1、打开chrome浏览器
			driver = new ChromeDriver();
			browser = "chrome";
		} else if (browserName.equals("firefox")) {
			// 设置firefox可执行文件的路径
			System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
			// 设置firefox驱动的路径
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			// 1、打开Firefox ，实例化fireFoxDriver
			driver = new FirefoxDriver();
			browser = "firefox";
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
			browser = "ie";
		}
		logger.info("==================打开浏览器===================");
		logger.info("浏览器名:【" + browserName + "】");
	}

	/**
	 * 访问某个页面
	 * 
	 * @param url
	 */
	public void to(String url) {
		logger.info("访问页面:" + url);
		driver.get(url);
	}

	/**
	 * 关闭浏览器
	 */
	public void closeBrowser() {
		logger.info("====================关闭浏览器==================");
		driver.quit();
	}

	/**
	 * 最大化浏览器
	 */
	public void maximizeBrowser() {
		logger.info("【最大化浏览器】");
		driver.manage().window().maximize();
	}

	/**
	 * 刷新浏览器
	 */
	public void refreshBrowser() {
		logger.info("【刷新浏览器】");
		Navigation navigation = driver.navigate();
		navigation.refresh();
	}

	/**
	 * 浏览器前进
	 */
	public void forwardBrowser() {
		logger.info("【浏览器前进】");
		Navigation navigation = driver.navigate();
		navigation.forward();
	}

	public void backBrowser() {
		logger.info("【浏览器后退】");
		Navigation navigation = driver.navigate();
		navigation.back();
	}


	/**
	 * 截图的方法
	 * @param path 截图生成的路径
	 */
	public static File takeScreenshot(String path) {
		File sourceFile = null;
		if (browser.equals("chrome")) {
			// Webdriver没有截图方法，必须转换成对应浏览器驱动类型
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			// OutputType.FILE表示让截图最终生成的是File对象
			sourceFile= chromeDriver.getScreenshotAs(OutputType.FILE);
		}else if(browser.equals("firefox")){
			FirefoxDriver firefoxDriver = (FirefoxDriver) driver;
			sourceFile = firefoxDriver.getScreenshotAs(OutputType.FILE);
		}else if(browser.equals("ie")){
			InternetExplorerDriver internetExplorerDriver = (InternetExplorerDriver) driver;
			sourceFile = internetExplorerDriver.getScreenshotAs(OutputType.FILE);
		}
		
		// 目标文件的对象
		File targetFile = new File(path);
		// 把源文件对象拷贝到目标对象中，即可完成path文件创建
		// FileUtils需要导入commons.io依赖
		try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetFile;
	}
}
