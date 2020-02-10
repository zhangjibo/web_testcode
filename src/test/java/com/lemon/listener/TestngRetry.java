package com.lemon.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**  
 * @Title: TestngRetry.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年2月8日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved. 
 */
/**
 * 实现IRetryAnalyzer可以实现重试机制
 * 
 */
public class TestngRetry implements IRetryAnalyzer {
	private Logger logger = Logger.getLogger(TestngRetry.class);

	// 最大的重试次数--》限制
	private int maxRetryCount = 2;
	// 已经重试的次数
	private int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		// 当用例执行失败的时候，那么会执行到这里的retry方法里面
		// retry方法的返回值决定了是不是需要重试
		// 如果返回为true：表示需要执行重试
		// 如果返回为false，表示不需要执行重试
		// 控制他执行的原理：设置一个值，当变量小于它的时候就会返回true
		if (retryCount < maxRetryCount) {
			logger.info("开始运行第【"+(retryCount+1)+"】次重试机制");
			retryCount++;
			return true;
		} else {
			// 不满足 我就不再去执行重试了
			return false;
		}

	}

}
