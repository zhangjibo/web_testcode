package com.test.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * @Title: SpecialElement.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年1月9日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class SpecialElement {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		openBrowser("chrome");
		// alert弹框
		// driver.get("D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\模态框\\alert.html");
		// Thread.sleep(2000);
		// driver.findElement(By.id("abtn")).click();
		// Thread.sleep(2000);
		// 定位到alert弹框 切换
		// 得到alert弹框
		// Alert alert = driver.switchTo().alert();
		// 确认
		// alert.accept();
		// 取消
		// alert.dismiss();
		// 获取弹框的文本信息
		// System.out.println(alert.getText());

		// comfirm弹框
		// driver.get("D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\模态框\\confirm.html");
		// Thread.sleep(2000);
		// driver.findElement(By.id("abtn")).click();
		// Thread.sleep(2000);
		// 得到comfirm弹框
		// Alert alert = driver.switchTo().alert();
		// alert.accept();
		// alert.dismiss();
		// System.out.println(alert.getText());

		// div弹框
		 driver.get("http://120.78.128.25:8765/");
		// 点击计算器
		 driver.findElement(By.className("calculator-btn")).click();
		// 等待div弹框元素可见才能继续去进行点击
		 WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		 WebElement webElement = webDriverWait
		 .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='等额本息']")));
		 webElement.click();

		 Thread.sleep(3000);
//		 driver.quit();

		// iframe切换处理
		/*
		 * driver.get(
		 * "D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\iframe\\a.html"
		 * ); Thread.sleep(2000); //在a.html页面中输入框输入数据
		 * driver.findElement(By.id("aa")).sendKeys("1111"); Thread.sleep(2000);
		 * //切换iframe //在内嵌的iframe中--》b.html 输入数据 WebDriverWait webDriverWait =
		 * new WebDriverWait(driver, 5); //等待iframe可用，并且会切换到iframe中
		 * //webDriverWait.until(ExpectedConditions.
		 * frameToBeAvailableAndSwitchToIt(By.id("bframe")));
		 * //driver.switchTo().frame();
		 * //driver.findElement(By.id("bb")).sendKeys("2222");
		 * //切换到c.html对应的iframe中 Thread.sleep(2000);
		 * webDriverWait.until(ExpectedConditions.
		 * frameToBeAvailableAndSwitchToIt(By.id("cframe")));
		 * driver.findElement(By.id("cc")).sendKeys("333"); Thread.sleep(2000);
		 * //切换到默认的页面中 driver.switchTo().defaultContent();
		 * driver.findElement(By.id("aa")).sendKeys("444"); Thread.sleep(3000);
		 * driver.quit();
		 */
		// 从c对应的iframe返回到第一个iframe（b），调用defaultContent方法返回默认的a页面，再去切换到第一个iframe

		// window切换处理
		// window-->窗口 根据窗口的标识--》句柄 来去切换窗口
		// driver.get("D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\window\\a.html");
		// driver.findElement(By.id("aa")).sendKeys("1111");
		// System.out.println("跳转之前窗口句柄："+driver.getWindowHandle());
		// 点击“跳转到b页面”
		// driver.findElement(By.id("bb")).click();
		// 点击“跳转到c页面”
		// driver.findElement(By.id("cc")).click();
		// 定位b页面中的输入框-->窗口切换
		// 句柄每一次打开都会有变化,关键点：怎么得到对应的窗口句柄
		// System.out.println("跳转之后窗口句柄："+driver.getWindowHandle());
		// Thread.sleep(2000);
		// System.out.println(driver.getWindowHandles());
		// 打开新窗口之后的所有句柄
		/*
		 * Set<String> handles = driver.getWindowHandles(); for (String handle :
		 * handles) { //关键点：怎么得到对应的窗口句柄 driver.switchTo().window(handle);
		 * //切换之后的窗口是不是为第二个窗口？？怎么验证？？，根据窗口的title标题或者url来进行判断
		 * if(driver.getTitle().equals("b.html")){ //跳出循环 break; }
		 * 
		 * }
		 */
		// 定位到第二个窗口的元素
		// driver.findElement(By.id("bb")).sendKeys("222");
		// driver.switchTo().window();
		// 定位到第三个窗口的元素
		// mySwitchWindow("c.html");
		// driver.switchTo().window("c.html");
		// driver.findElement(By.id("cc")).sendKeys("123456");

		// Thread.sleep(3000);
		// driver.quit();

		// 单选/复选按钮
		/*
		 * driver.get(
		 * "D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\单选多选框\\radio.html"
		 * );
		 * 
		 * Thread.sleep(2000); WebElement webElement =
		 * driver.findElement(By.cssSelector("input[value='female']"));
		 * System.out.println("点击之前:"+webElement.isSelected());
		 * webElement.click();
		 * System.out.println("点击之后:"+webElement.isSelected());
		 */

		// driver.get("D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\单选多选框\\checkbox.html");
		// Thread.sleep(2000);
		// 选中“数学”&“体育”
		// driver.findElement(By.cssSelector("input[value='Math']")).click();
		// driver.findElement(By.cssSelector("input[value='Sport']")).click();

		// Select下拉框
		/*
		 * driver.get("https://www.baidu.com"); //点击设置
		 * driver.findElement(By.xpath("//div[@id='u1']//a[text()='设置']")).click
		 * (); Thread.sleep(2000); //点击高级搜索
		 * driver.findElement(By.xpath("//a[text()='高级搜索']")).click();
		 * Thread.sleep(2000); //找到select下拉框元素，通过Select类将其封装成select对象 WebElement
		 * webElement = driver.findElement(By.name("gpc")); Select select = new
		 * Select(webElement);
		 */
		// 根据索引来选择下拉框选项，注意：索引从0开始
		// select.selectByIndex(1);
		// 根据选项value属性来选择
		// select.selectByValue(arg0);
		// 根据选项的文本来选择
		// select.selectByVisibleText("最近一月");
		// 不选择 --》 下拉框必须得要是多选下拉框
		// select.deselectByIndex(0);

		// 复选下拉框
		/*
		 * driver.get(
		 * "D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\select\\mult-select.html"
		 * ); //定位到复选下拉框 WebElement webElement =
		 * driver.findElement(By.id("m-select")); Select select = new
		 * Select(webElement); Thread.sleep(2000); select.selectByValue("3");
		 * Thread.sleep(2000); select.selectByValue("5"); Thread.sleep(2000);
		 * //取消选择全部的 select.deselectAll(); //这个API用来判断你的下拉框是单选的还是复选的
		 * System.out.println(select.isMultiple()); Thread.sleep(3000);
		 * driver.quit();
		 */

		// 日期时间选择框
		// 1、手动输入时间
		// driver.get("https://www.fliggy.com/?ttid=sem.000000736&hlreferid=baidu.082076&route_source=seo");
		// 找到出发日期时间选择输入框
		// driver.findElement(By.xpath("//form[@id='J_FlightForm']//input[@name='depDate']")).sendKeys("2020-01-20");

		// 2、时间输入框有限制了输入，通过执行javaScript代码移除掉readonly属性
		/*
		 * driver.get("https://www.12306.cn/index/");
		 * //要去执行javaScript，你首先的要有JavaScript的执行对象--JavascriptExecutor
		 * Thread.sleep(3000); JavascriptExecutor javascriptExecutor
		 * =(JavascriptExecutor)driver; WebElement webElement =
		 * driver.findElement(By.id("train_date")); //String str="readonly";
		 * //调用executeScript方法即可执行javaScript
		 * //java和javaScript做交互，java的值传给javaScript去执行
		 * //arguments[i]数组来去接收java代码传过来的值
		 * //document.getElementById('train_date').removeAttribute('readonly')
		 * -- 原始的 javascriptExecutor.executeScript(
		 * "arguments[0].removeAttribute('readonly')",webElement);
		 * webElement.clear(); webElement.sendKeys("2020-01-20");
		 */

		// 针对一些元素比较快就消失，调试的办法
		// 1、调整网速 ，chrome打开F12选择network-->slow 3G
		// 2、暂停浏览器渲染，chrome打开F12选择source，点击右边的暂停按钮（按下快捷F8）都可以

		// javaScript的应用
		/*
		driver.get("https://sj.qq.com/myapp/category.htm?orgame=1&categoryId=122");
		// 先去点击“闲鱼”
		// driver.findElement(By.xpath("//a[text()='闲鱼']")).click();
		// 点击“孩子王”
		// driver.findElement(By.xpath("//a[text()='孩子王']")).click();
		Thread.sleep(2000);
		// 找到“正在加载中”元素
		WebElement webElement = driver.findElement(By.xpath("//div[@class='loading']"));
		// 通过javaScript滚动到“正在加载中..”元素这里 scrollIntoView
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

		// WebElement webElement2 =
		// driver.findElement(By.xpath("//a[text()='孩子王']")"));
		// 循环的滚动--判断元素有没有加载出来
		String beforePageSource = "";
		String afterPageSource = "";
		int num = 1;
		while (true) {
			// 如果当前包含某个元素的话，元素已经加载出来
			if (driver.getPageSource().contains("孩子王")) {
				WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
				webDriverWait.until(ExpectedConditions.
						elementToBeClickable(By.xpath("//a[text()='孩子王']"))).click();
				// 当元素找到之后，就跳出循环
				break;
			}
			// 滑动前的页面的源代码pageSource
			beforePageSource = driver.getPageSource();
			Thread.sleep(1000);
			javascriptExecutor.executeScript("arguments[0].scrollIntoView()", webElement);
			System.out.println("第" + num + "滑动");
			num++;
			// 滑动后的页面源代码pageSource
			afterPageSource = driver.getPageSource();

			// 不管加载了多少次，元素都找不到，也是要跳出循环
			// 问题：判断到了最底部？
			// 1、根据关键字来判断
			/*
			 * if(driver.getPageSource().contains("去搜索更多")){
			 * System.out.println("滑动到了最底部"); break; }
			 */
			// 2、判断滑动前和滑动后页面的pageSource有没有变化--》到了最底部
			
		/*if (beforePageSource.equals(afterPageSource)) {
				System.out.println("滑动到了最底部");
				break;
			}

		}
	*/
		
		
		//鼠标操作
		/*driver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
		//Actions类来去处理鼠标
		Actions actions = new Actions(driver);
		//拖拽元素，source-》原来元素  target--》目标元素
		//actions.dragAndDrop(source, target)
		//移动到指定元素位置
		//actions.moveToElement(target)
		//找到元素：随意拖拽1-1
		WebElement webElement = driver.findElement(By.id("treeDemo_2_span"));
		//找到元素：随意拖拽1-2
		WebElement webElement2 = driver.findElement(By.id("treeDemo_3_span"));
		//通过鼠标长按“随意拖拽1-1” 拖拽到 “随意拖拽1-2”的位置，鼠标释放release 
		//build --> 构建一连串的工作
		//perform --> 让鼠标动作生效
		Thread.sleep(2000);
		actions.clickAndHold(webElement).moveToElement(webElement2).release().build().perform();
		*/
		
		
		//文件上传
		//1、元素是input类型，直接调用sendKeys即可
		/*driver.get("D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\文件上传\\fileupload.html");
		Thread.sleep(2000);
		driver.findElement(By.id("fu")).sendKeys("D:\\eclipse-workspace\\web_auto_test_java15\\111.png");
		driver.findElement(By.id("fc")).click();
		Thread.sleep(5000);
		driver.quit();*/
		
		//2、元素不是input类型，而是使用了第三方控件 AutoIT -->自己去找相关的资料
		
		//验证码
		//- 去除验证码
		//- 自动识别 --不推荐  难度太高 图像识别 打码平台 成本高
		//- 万能验证码（推荐）  在后台开一个后门 adadasdasdasda
		//  - 前程贷：hapi
		
		//前程贷前台项目的地址：http://120.78.128.25:8765/Index/login.html
		//帐号密码：
		//13323234545  lemon123456
		//万能验证码：hapi
		
		//前程贷后台的地址：http://120.78.128.25:8765/Admin/Index/login.html
		//帐号密码：
		//lemon7 lemonbest
		//万能验证码：hapi
		
	}

	/**
	 * 自己封装的去切换窗口的方法
	 * 
	 * @param title
	 *            要切换窗口对应的标题
	 */
	public static void mySwitchWindow(String title) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			// 关键点：怎么得到对应的窗口句柄
			driver.switchTo().window(handle);
			// 切换之后的窗口是不是为第二个窗口？？怎么验证？？，根据窗口的title标题或者url来进行判断
			if (driver.getTitle().equals(title)) {
				// 跳出循环
				break;
			}

		}
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
