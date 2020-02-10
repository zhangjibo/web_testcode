package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Title: BasePage.java
 * @Description: TODO(页面的共性操作-等待元素可见、等待元素可被点击、获取元素属性...)
 * @author 歪歪欧巴
 * @date 2020年2月6日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BasePage {
	
	public Logger logger = Logger.getLogger(BasePage.class);

	/**
	 * 二次封装的显示等待，等待元素可见
	 * @param locator
	 * @return
	 */
	public WebElement waitElementVisible(By locator) {
		// 显示等待，条件：元素可见为止
		WebDriverWait webDriverWait = new WebDriverWait(BaseCase.driver, 5);
		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * 二次封装的显示等待，等待元素可被点击
	 * @param locator
	 * @return
	 */
	public WebElement waitElementClickable(By locator) {
		// 显示等待，条件：元素可被点击
		WebDriverWait webDriverWait = new WebDriverWait(BaseCase.driver, 5);
		return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void click(By locator){
		logger.info("点击了元素【"+locator+"】");
		waitElementClickable(locator).click();
	}

	/**
	 * 往控件中输入数据
	 * @param locator
	 * @param data
	 */
	public void input(By locator, String data){
		logger.info("往元素【"+locator+"】输入数据【"+data+"】");
		waitElementVisible(locator).sendKeys(data);
	}
	
	/**
	 * 获取到元素的文本值
	 * @param locator
	 * @return
	 */
	public String getWebElementText(By locator){
		String text = waitElementVisible(locator).getText();
		logger.info("获取到元素的文本值【"+text+"】");
		return text;
	}
	
	/**
	 * 获取元素的某个属性
	 * @param locator
	 * @param attributeKey 对应的属性名
	 */
	public String getWebElemetAttribute(By locator,String attributeKey){
		String value = waitElementVisible(locator).getAttribute(attributeKey);
		logger.info("获取到元素的属性【"+attributeKey+"值为【"+value+"】");
		return value;
	}
}
