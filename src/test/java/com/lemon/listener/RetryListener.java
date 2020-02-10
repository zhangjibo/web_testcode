package com.lemon.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**  
 * @Title: RetryListener.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年2月8日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved. 
 */
/** 
* 在Testng运行的时候可以动态的修改(增加)注解对应的属性 eg.retryAnalyzer
*  
*/
public class RetryListener implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		//1、得到注解的retryAnalyzer属性 对象
		IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
		//2、判断属性是不是有设置，如果没有，就给设置属性值
		if (iRetryAnalyzer == null) {
			annotation.setRetryAnalyzer(TestngRetry.class);
		}
	}

}
