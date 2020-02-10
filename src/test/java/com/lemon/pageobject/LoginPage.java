package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lemon.common.BasePage;

/**  
 * @Title: LoginPage.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年2月4日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved. 
 */
public class LoginPage extends BasePage {

	//手机号码输入框的定位器
	private By mobilephone = By.name("phone");
	//密码输入框的定位器
	private By password = By.name("password");
	//登录按钮
	private By loginButton = By.xpath("//button[text()='登录']");
	//提示信息-此账号没有经过授权，请联系管理员!
	private By showTips = By.className("layui-layer-content");
	//提示信息-输入框的错误提示信息
	private By inputTips = By.className("form-error-info");
	
	public void inputMobilephone(String data){
		input(mobilephone, data);
	}
	
	public void inputPassword(String data){
		input(password, data);
	}
	
	public void clickLoginButton(){
		click(loginButton);
	}
	
	/**
	 * 得到提示信息的文本值的-此账号没有经过授权，请联系管理员!
	 * @return
	 */
	public String getShowTipsText(){
		return getWebElementText(showTips);
	}
	
	/**
	 * 得到提示信息的文本值的-输入框的错误提示信息
	 * @return
	 */
	public String getInputTipsText(){
		return getWebElementText(inputTips);
	}
	
	/**
	 * 获取手机号码输入框的value属性值
	 * @return
	 */
	public String getPhoneAttribute(){
		return getWebElemetAttribute(mobilephone, "value");
	}
}
