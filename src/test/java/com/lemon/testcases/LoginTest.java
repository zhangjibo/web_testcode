package com.lemon.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.common.BaseCase;
import com.lemon.listener.TestngRetry;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.testdatas.LoginDatas;

/**
 * @Title: LoginTest.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年1月16日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class LoginTest extends BaseCase {

	@BeforeMethod
	public void setUp() {
		// 前置
		// 打开浏览器-chrome
		openBrowser("chrome");
		maximizeBrowser();
		to("http://120.78.128.25:8765/Index/login.html");
	}

	/**
	 * 正向用例
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void testLogin_success() throws InterruptedException {
		// 实例化LoginPage对象
		LoginPage loginPage = new LoginPage();
		loginPage.inputMobilephone(LoginDatas.CORRECT_MOBILEPHONE);
		loginPage.inputPassword(LoginDatas.CORRECT_PASSWORD);
		loginPage.clickLoginButton();

		// 第二种断言方式--根据“我的帐户”元素是否显示出来 加等待
		IndexPage indexPage = new IndexPage();
		Assert.assertTrue(false);

		// 第一种断言方式：根据页面的title,因为这里没有元素的定位，所以不能用显示/隐式等待-->智能方式
		/*
		 * Thread.sleep(3000); //实际值 String actualValue = driver.getTitle();
		 * //期望值 String expectedValue="前程贷官网  业内领先的社群互联网金融平台";
		 * Assert.assertEquals(actualValue, expectedValue);
		 */

		// 报告显示的结果，由断言+代码执行有没有报错
	}

	/**
	 * 反向用例 帐号未注册/帐号/密码错误的情况
	 * 
	 * @param mobilephone
	 * @param password
	 * @param tips
	 */
	@Test(priority = 1, dataProviderClass = LoginDatas.class, 
			dataProvider = "getLoginDatas01", description = "帐号未注册/帐号/密码错误的情况")
	public void testLogin_failure01(String mobilephone, String password, String tips) {
		// 实例化LoginPage对象
		LoginPage loginPage = new LoginPage();
		loginPage.inputMobilephone(mobilephone);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();

		// 断言-根据提示信息(此账号没有经过授权，请联系管理员!)

		// 获取到元素的文本值
		String actualValue = loginPage.getShowTipsText();
		String expectedValue = tips;
		Assert.assertNotEquals(actualValue, expectedValue);

	}

	/**
	 * 反向用例 用户名为空/密码为空的情况
	 */
	@Test(priority = 2, dataProviderClass = LoginDatas.class, dataProvider = "getLoginDatas02", enabled = false)
	public void testLogin_failure02(String mobilephone, String password, String tips) {
		// 实例化LoginPage对象
		LoginPage loginPage = new LoginPage();
		loginPage.inputMobilephone(mobilephone);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		// 获取到元素的文本值
		String actualValue = loginPage.getInputTipsText();
		String expectedValue = tips;
		Assert.assertEquals(actualValue, expectedValue);
	}

	/**
	 * 记住手机号的测试用例
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4, enabled = false)
	public void testLogin_remeber() throws InterruptedException {
		// 实例化LoginPage对象
		LoginPage loginPage = new LoginPage();
		loginPage.inputMobilephone(LoginDatas.CORRECT_MOBILEPHONE);
		loginPage.inputPassword(LoginDatas.CORRECT_PASSWORD);
		loginPage.clickLoginButton();
		// 进入到主页定位到退出元素
		// 实例化IndexPage对象
		IndexPage indexPage = new IndexPage();
		indexPage.clickQuit();
		// 点击登录元素
		indexPage.clickLogin();
		// 断言--根据手机号码输入框有没有原来的手机号码
		String actualValue = loginPage.getPhoneAttribute();
		String expectedValue = LoginDatas.CORRECT_MOBILEPHONE;
		Assert.assertEquals(actualValue, expectedValue);

	}

	@AfterMethod
	public void tearDown() {
		// 测试结束之后
		// 关闭浏览器
		closeBrowser();
	}

}
