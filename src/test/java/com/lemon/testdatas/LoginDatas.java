package com.lemon.testdatas;

import org.testng.annotations.DataProvider;

/**
 * @Title: LoginDatas.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年2月6日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class LoginDatas {
	// 登录正确手机号码
	public static final String CORRECT_MOBILEPHONE = "13323234545";
	// 登录正确密码
	public static final String CORRECT_PASSWORD = "lemon123456";

	/**
	 * 数据提供源 1、用户账号没有注册的情况 2、用户名/密码错误的请求
	 */
	@DataProvider
	public Object[][] getLoginDatas01() {
		Object[][] datas = { { "15859019266", "lemon123456", "此账号没有经过授权，请联系管理员!" } };
		return datas;
	}

	/**
	 * 数据提供源 1、帐号为空 2、密码为空 3、手机号格式不正确的情况
	 */
	@DataProvider
	public Object[][] getLoginDatas02() {
		Object[][] datas = { { "", "123456", "请输入手机号" }, { "13323234545", "", "请输入密码" },
				{ "1585901925", "123456", "请输入正确的手机号" }, { "158590192534", "123456", "请输入正确的手机号" },
				{ "1585901925%", "123456", "请输入正确的手机号" } };
		return datas;
	}

}
