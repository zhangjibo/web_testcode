package com.lemon.testcases;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Title: InvestTest.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年2月4日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class InvestTest {

	public static WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		openBrowser("chrome");
		//最大化浏览器
		driver.manage().window().maximize();
		// 测试数据的准备
		// 在后台去加标
		addBid();
	}
	
	@Test
	public void testInvest(){
		
	}

	public void addBid() throws InterruptedException {
		driver.get("http://120.78.128.25:8765/Admin/Index/login.html");
		// 输入用户名
		waitElementVisible(By.name("admin_name")).sendKeys("lemon7");
		// 输入密码
		waitElementVisible(By.name("admin_pwd")).sendKeys("lemonbest");
		// 输入万能的验证码"hapi"
		waitElementVisible(By.name("code")).sendKeys("hapi");
		// 点击登录后台
		waitElementTobeClickable(By.xpath("//button[text()='登陆后台']")).click();
		// 点击借款管理
		waitElementTobeClickable(By.xpath("//span[text()='借款管理']")).click();
		// 切换iframe
		waitIframeAvailable(By.id("mainFrame"));
		// 点击加标
		waitElementTobeClickable(By.xpath("//span[text()='加标']")).click();
		Thread.sleep(3000);
		// 输入借款人的信息
		WebElement webElement = waitElementVisible(By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]"));
		webElement.sendKeys("13323234545");
		// 通过键盘的操作选中搜索结果中的借款人13323234545
		Thread.sleep(1000);
		webElement.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		webElement.sendKeys(Keys.ENTER);
		// 输入贷款标题
		waitElementVisible(By.xpath("//td[text()='贷款标题:']/following-sibling::td/input[1]")).sendKeys("测试"+System.currentTimeMillis());
		// 输入年利率
		waitElementVisible(By.xpath("//td[text()='年利率利息:']/following-sibling::td/input[1]")).sendKeys("10");
		// 输入借款的期限
		waitElementVisible(By.xpath("//td[text()='借款期限:']/following-sibling::td/input[1]")).sendKeys("6");
		// 输入借款的额度
		waitElementVisible(By.xpath("//td[text()='借款额度:']/following-sibling::td/input[1]")).sendKeys("200000");
		// 输入竞标的期限
		waitElementVisible(By.xpath("//td[text()='竞标期限:']/following-sibling::td/input[1]")).sendKeys("6");

		// 点击风控评测
		waitElementTobeClickable(By.xpath("//span[text()='风控评测']")).click();
		// 输入评估价值
		waitElementVisible(By.xpath("//td[text()='评估价值:']/following-sibling::td/input[1]")).sendKeys("1000000");

		// 点击项目录入
		waitElementTobeClickable(By.xpath("//span[text()='项目录入']")).click();
		// 输入籍贯
		waitElementVisible(By.xpath("//td[text()='籍贯:']/following-sibling::td/input[1]")).sendKeys("湖南长沙");
		// 输入职业
		waitElementVisible(By.xpath("//td[text()='职业:']/following-sibling::td/input[1]")).sendKeys("测试工程师");
		// 输入年龄
		waitElementVisible(By.xpath("//td[text()='年龄:']/following-sibling::td/input[1]")).sendKeys("25");
		
		//点击提交
		waitElementTobeClickable(By.xpath("//span[text()='提交']")).click();
		Thread.sleep(3000);
		//选择创建的标
		waitElementTobeClickable(By.id("datagrid-row-r1-2-0")).click();
		//审核一下
		waitElementTobeClickable(By.xpath("//span[text()='审核']")).click();
		//点击审核通过
		waitElementTobeClickable(By.xpath("//span[text()='审核通过']")).click();
	
		//创建标的剩余流程自行补充
	}

	/**
	 * 二次封装的显示等待，等待元素可见
	 */
	public WebElement waitElementVisible(By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * 二次封装的显示等待，等待元素可点击
	 */
	public WebElement waitElementTobeClickable(By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * 二次封装的显示等待，等待iframe可用 并且会切换到iframe中
	 */
	public void waitIframeAvailable(By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public static void openBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			// 相当于设置全局属性，能够让我们的代码认识到chromeDriver是存放在哪里
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			// 1、打开chrome浏览器
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
			driver = new ChromeDriver(chromeOptions);
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
