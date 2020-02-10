package com.lemon.listener;

import java.io.File;
import java.io.IOException;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.lemon.common.BaseCase;

import io.qameta.allure.Attachment;

/**
 * @Title: AllureReportListener.java
 * @Description: TODO(监听测试类的运行状态)
 * @author 歪歪欧巴
 * @date 2020年2月8日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class AllureReportListener implements IHookable {

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		// TODO Auto-generated method stub
		// callBack去执行测试方法，测试结果放到了testResult里面
		callBack.runTestMethod(testResult);
		// 测试结果有没有出现异常 getThrowable()-->获取异常为空
		if (testResult.getThrowable() != null) {
			// 如果有出现异常就去截图
			try {
				saveScreenShot(testResult.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Attachment(value = "Failure on method {0}", type = "image/png")
	public byte[] saveScreenShot(String methodName) throws IOException {
		// 1、调用截图
		// 截图的路径D:\eclipse-workspace\web_auto_test_java15\target\ScreenShot\图片名字
		File file = BaseCase.takeScreenshot(
				System.getProperty("user.dir") + "\\target\\ScreenShot\\" + System.currentTimeMillis() + ".png");
		// 2、嵌入到Allure报表里面，直接返回byte[]数组即可
		return Files.toByteArray(file);
	}

}
