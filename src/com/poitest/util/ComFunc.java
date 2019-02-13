package com.poitest.util;

public class ComFunc {

	/**
	 * 检查字符串是否为空，且有记录
	 * 
	 * @param String
	 * @return
	 */
	public static boolean checkNullOrEmpty(String s) {
		return s == null || s.length() <= 0;
	}

}
