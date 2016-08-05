/**
 * 
 */
package com.yutai.exuetang.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author Administrator 2016年7月29日 上午11:15:00
 * 
 */
public class CodeUtils {
	public static String getNewString(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes("GBK"), "UTF-8");
	}

	public static String getNewStringApp(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes("iso8859-1"), "UTF-8");
	}
}
