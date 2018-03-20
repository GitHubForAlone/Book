package com.alone.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
	// 移动电话 和 固定电话的正则表达式
	private static final String REGEX_TELEPHONE = "((^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$))|((^(0\\d{2}\\d{8}(\\d{1,4})?)|(0\\d{3,4}\\d{7,8}(\\d{1,4})?)$))";
	
	//省份证号码 正则表达式
	private static final String REGEX_CARDID = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";
	
	public static boolean pMString(String phoneNumber, String cardId) {

		boolean isOk = false;
		Pattern p = null;
		Matcher m = null;
		/*
		 * 电话号码
		 */
		p = Pattern.compile(REGEX_TELEPHONE);
		m = p.matcher(phoneNumber);
		if (m.find()) {
			if (IsBlank.isBlank(m.group())) {
				isOk = true;
			}else {
				isOk = false;
			}
		}
		/*
		 * 身份证ID
		 */
		if (isOk) {
			p = Pattern.compile(REGEX_CARDID);
			m = p.matcher(cardId);
			if (m.find()) {
				if (IsBlank.isBlank(m.group())) {
					isOk = true;
				}
			}else {
				isOk = false;
			}
		}
		
		return isOk;
	}
}
