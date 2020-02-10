package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lemon.common.BasePage;

/**  
 * @Title: IndexPage.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年2月4日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved. 
 */
public class IndexPage extends BasePage {

	//我的帐户元素定位器
	private By myAccout = By.xpath("//a[contains(text(),'我的帐户')]");
	//退出元素定位器 
	private By quit = By.partialLinkText("退出");
	//登录元素定位器
	private By login = By.partialLinkText("登录");
	
	public Boolean waitmyAccoutVisible(){
		return waitElementVisible(myAccout).isDisplayed();
	}
	
	public void clickQuit(){
		waitElementClickable(quit).click();
	}
	
	public void clickLogin(){
		waitElementClickable(login).click();
	}
}
