package com.test.day03;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @Title: ElementOperate.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年1月7日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ElementOperate {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		openBrowser("chrome");
		// 访问百度的网址
		driver.get("http://120.78.128.25:8765/Index/login.html");
		// findElement的返回值就是为找到的web元素
		//WebElement webElement = driver.findElement(By.id("kw"));
		// 输入搜索内容
		//webElement.sendKeys("柠檬班");
		// 等待3S（代码执行的速度很快） 让代码停留3S
		Thread.sleep(3000);
		// driver.findElement(By.id("kw")).clear();
		// 键盘组合-全选
		// webElement.sendKeys(Keys.CONTROL,"a");
		// Thread.sleep(1000);
		// 剪切
		// webElement.sendKeys(Keys.CONTROL,"x");
		// 复制
		// webElement.sendKeys(Keys.CONTROL,"c");
		// Thread.sleep(1000);
		// 粘贴
		// webElement.sendKeys(Keys.CONTROL,"v");
		// webElement.sendKeys(Keys.CONTROL,"v");
		// webElement.sendKeys(Keys.CONTROL,"v");
		// 回车
		// webElement.sendKeys(Keys.ENTER);

		// #### getTagName()
		// 获取元素的的标签名
		//System.out.println("元素的标签名:"+webElement.getTagName());
		// #### getAttribute(属性名)
		// 根据属性名获取元素属性值
		//System.out.println("元素的class属性值："+webElement.getAttribute("class"));
		//System.out.println("元素的maxlength属性值："+webElement.getAttribute("maxlength"));
		// #### getText()
		// 获取当前元素的文本值
		//System.out.println("元素的文本值："+webElement.getText());
		// #### isDisplayed()
		// 查看元素是否显示
		//System.out.println("元素是否显示:"+webElement.isDisplayed());
		//点击设置
		//driver.findElement(By.xpath("//div[@id='u1']/a[text()='设置']")).click();
		//Thread.sleep(3000);
		//找到高级搜索元素
		//默认打开百度，高级搜索默认渲染不存在于html文档中，所以说我们是找不到元素
		//要找到高级搜索，高级搜索显示出来--》存在于html文档中
		//WebElement webElement = driver.findElement(By.xpath("//a[text()='高级搜索']"));
		//webElement.click();
		//System.out.println(webElement.isDisplayed());
		//
		
		//前程带登录窗口
		//输入手机号码
		driver.findElement(By.xpath("//input[@placeholder='手机号']")).sendKeys("13323234545");
		//输入密码
		driver.findElement(By.xpath("//input[@placeholder='密码']")).sendKeys("lemon123456");
		//点击登录按钮
		//driver.findElement(By.xpath("//button[text()='登录']")).click();
		// #### submit()
		// 提交表单
		//先去找到表单元素
		driver.findElement(By.name("login-form")).submit();
		// 退出驱动、退出浏览器所有窗口
		Thread.sleep(3000);
		driver.quit();
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
