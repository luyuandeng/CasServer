package com.gzeport.casserver.util;


import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

// Referenced classes of package com.gzeport.logistics.common.util:
//            Md5

public class StringHelp {

	public StringHelp() {
	}

	public static String filterHTML(String strToFilter) {
		if (strToFilter == null || strToFilter.trim().length() == 0) {
			return "";
		} else {
			String returnString = "";
			returnString = strToFilter.replaceAll("<", "&lt;");
			returnString = returnString.replaceAll(">", "&gt;");
			return returnString;
		}
	}

	public static String unFilterHTML(String strToFilter) {
		if (strToFilter == null || strToFilter.trim().length() == 0) {
			return "";
		} else {
			String returnString = "";
			returnString = strToFilter.replaceAll("&lt;", "<");
			returnString = returnString.replaceAll("&gt;", ">");
			return returnString;
		}
	}

	public static String getGBString(String strToTrans) {
		if (strToTrans == null || strToTrans.trim().length() == 0)
			return "";
		String tmpString = strToTrans;
		try {
			return new String(tmpString.getBytes("ISO8859_1"), "GBK");
		} catch (UnsupportedEncodingException ex) {
			System.out.println((new StringBuilder(
					"StringKit.getGBString()  wrong")).append(ex.getMessage())
					.toString());
		}
		return "";
	}

	public static String getValidXml(String strToTrans) {
		String returnString = "";
		returnString = strToTrans.replaceAll("&nbsp;", "");
		return returnString;
	}

	public static String getSqlStr(String strToTrans) {
		String returnString = "";
		returnString = strToTrans.replaceAll("'", "''");
		return returnString;
	}

	public static String toHTMLString(String in) {
		StringBuffer out = new StringBuffer();
		for (int i = 0; in != null && i < in.length(); i++) {
			char c = in.charAt(i);
			if (c == '\'')
				out.append("&#039;");
			else if (c == '"')
				out.append("&#034;");
			else if (c == '<')
				out.append("&lt;");
			else if (c == '>')
				out.append("&gt;");
			else if (c == '&')
				out.append("&amp;");
			else if (c == ' ')
				out.append("&nbsp;");
			else if (c == '\n')
				out.append("<br/>");
			else
				out.append(c);
		}

		return out.toString();
	}

	public static String replace(String parentStr, String ch, String rep) {
		int i = parentStr.indexOf(ch);
		StringBuffer sb = new StringBuffer();
		if (i == -1)
			return parentStr;
		sb
				.append((new StringBuilder(String.valueOf(parentStr.substring(
						0, i)))).append(rep).toString());
		if (i + ch.length() < parentStr.length())
			sb.append(replace(parentStr.substring(i + ch.length(), parentStr
					.length()), ch, rep));
		return sb.toString();
	}

	public static boolean isInStr(String id, String str) {
		if (str.indexOf("@") != -1) {
			String strArrary[] = str.split("@");
			for (int i = 0; i < strArrary.length; i++)
				if (id.equalsIgnoreCase(strArrary[i]))
					return true;

		} else if (id.equalsIgnoreCase(str))
			return true;
		return false;
	}

	public static String[] getStrArrary(String csv, String sep) {
		if (csv.indexOf(sep) != -1) {
			String rtn[] = csv.split(sep);
			return rtn;
		} else {
			String rtn[] = { csv };
			return rtn;
		}
	}

	public static String trimNull(String inString, String reString) {
		if (inString == null || inString.equals(""))
			inString = reString;
		else
			inString = inString.trim();
		return inString;
	}

	public static String[] trimNull(String inString[], String reString[]) {
		int theLength_1 = inString.length;
		int theLength_2 = reString.length;
		if (theLength_1 > theLength_2)
			return inString;
		for (int i = 0; i < theLength_1; i++)
			if (inString[i] == null || inString[i].equals(""))
				inString[i] = reString[i];
			else
				inString[i] = inString[i].trim();

		return inString;
	}

	public static String trimNull(String inString) {
		if (inString == null)
			inString = "";
		else
			inString = inString.trim();
		return inString;
	}

	public static String[] trimNull(String inString[]) {
		int theLength = inString.length;
		for (int i = 0; i < theLength; i++)
			if (inString[i] == null)
				inString[i] = "";
			else
				inString[i] = inString[i].trim();

		return inString;
	}

	public static final String getFatherCode(int codeRule[], String code) {
		int length1 = 0;
		int length2 = 0;
		int codeLength = code.length();
		String fatherCode = "0";
		for (int i = 0; i < codeRule.length; i++) {
			length1 += codeRule[i];
			if (i > 0)
				length2 += codeRule[i - 1];
			if (codeLength != length1 || length2 == 0)
				continue;
			fatherCode = code.substring(0, length2);
			break;
		}

		return fatherCode;
	}

	public static int getTopNodeLength(int codeRule[]) {
		if (codeRule.length >= 1)
			return codeRule[0];
		else
			return 0;
	}

	public static int getSecondNodeLength(int codeRule[]) {
		if (codeRule.length >= 2)
			return codeRule[0] + codeRule[1];
		else
			return 0;
	}

	public static int getNextSubNodeLength(int codeRule[], int subNodeLength) {
		int nextSubNodeLength = 0;
		int length1 = 0;
		for (int i = 0; i < codeRule.length; i++) {
			length1 += codeRule[i];
			if (i < codeRule.length - 1) {
				if (length1 == subNodeLength)
					return length1 + codeRule[i + 1];
			} else {
				if (length1 == subNodeLength)
					length1 += 3;
				return length1;
			}
		}

		return nextSubNodeLength;
	}

	public static final int getSubNodeLength(int codeRule[], String code) {
		int codeLength = code.length();
		int length1 = 0;
		for (int i = 0; i < codeRule.length; i++) {
			length1 += codeRule[i];
			if (i < codeRule.length - 1) {
				if (codeLength == length1)
					return length1 + codeRule[i + 1];
			} else {
				return length1;
			}
		}

		return 0;
	}

	public static boolean checkCodeRule(int codeRule[], String code) {
		return getCodeLevel(codeRule, code) != 0;
	}

	public static int getCodeLevel(int codeRule[], String code) {
		int codeLevel = 0;
		int length1 = 0;
		int codeLength = code.length();
		for (int i = 0; i < codeRule.length; i++) {
			length1 += codeRule[i];
			if (codeLength == length1)
				codeLevel = i + 1;
		}

		return codeLevel;
	}

	public static int getNextNodeLength(int codeRule[], String code) {
		int codeLevel = getCodeLevel(codeRule, code);
		if (codeLevel < codeRule.length)
			return codeRule[codeLevel];
		else
			return 0;
	}

	public static int getNodeLength(int codeRule[], String code) {
		int codeLevel = getCodeLevel(codeRule, code);
		if (codeLevel <= codeRule.length && codeLevel > 0)
			return codeRule[codeLevel - 1];
		else
			return 0;
	}

	public static int getCodeRuleAllLength(int codeRule[]) {
		int length = 0;
		for (int i = 0; i < codeRule.length; i++)
			length += codeRule[i];

		return length;
	}

	public static final String getFirstCode(String code, int codeRule[]) {
		return code.substring(0, codeRule[0]);
	}

	public static String getCodeRuleTag(int codeRule[]) {
		String codeRuleTag = "";
		for (int i = 0; i < codeRule.length; i++)
			codeRuleTag = (new StringBuilder(String.valueOf(codeRuleTag)))
					.append(codeRule[i]).append("-").toString();

		codeRuleTag = codeRuleTag.substring(0, codeRuleTag.length() - 1);
		return (new StringBuilder("�����ʽ��<font color='#D10000'>")).append(
				codeRuleTag).append("</font>").toString();
	}

	public static String inputStreamParseString(InputStream in)
			throws IOException {
		StringBuffer out = new StringBuffer();
		byte b[] = new byte[4096];
		int n;
		while ((n = in.read(b)) != -1)
			out.append(new String(b, 0, n));
		return out.toString();
	}

	public static List getAllStringBySplit(StringBuffer strBuffer,
			String beginStr, String endStr) {
		StringTokenizer st = new StringTokenizer(strBuffer.toString(), beginStr);
		List list = new ArrayList();
		while (st.hasMoreTokens()) {
			StringTokenizer sq = new StringTokenizer(st.nextToken(), endStr);
			if (sq.hasMoreTokens())
				list.add(sq.nextToken());
		}
		return list;
	}

	public static List getAllStringBySplit(StringBuffer strBuffer,
			String delimiter, boolean bool) {
		String str = strBuffer.toString();
		List result = new ArrayList();
		if (str == null)
			return null;
		if (delimiter == null) {
			result.add(str);
			return result;
		}
		if ("".equals(delimiter)) {
			for (int i = 0; i < str.length(); i++)
				if (bool)
					result.add((new StringBuilder(String.valueOf(str.substring(
							i, i + 1)))).append(delimiter).toString());
				else
					result.add(str.substring(i, i + 1));

		} else {
			int pos = 0;
			int delPos = 0;
			int m = 0;
			while ((delPos = str.indexOf(delimiter, pos)) != -1) {
				if (bool)
					result.add((new StringBuilder(String.valueOf(str.substring(
							pos, delPos)))).append(delimiter).toString());
				else
					result.add(str.substring(pos, delPos));
				pos = delPos + delimiter.length();
			}
			if (str.length() > 0 && pos <= str.length()
					&& !"".equals(trimNull(str.substring(pos).trim())))
				if (bool)
					result.add((new StringBuilder(String.valueOf(str.substring(
							pos).trim()))).append(delimiter).toString());
				else
					result.add(str.substring(pos).trim());
		}
		return result;
	}

	public static List getAllStringBySplit(StringBuffer strBuffer,
			String delimiter) {
		return getAllStringBySplit(strBuffer, delimiter, false);
	}

	public static String toUpperString(String str) {
		String strBuer = "";
		strBuer = trimNull(str);
		if ("".equals(strBuer)) {
			return "";
		} else {
			strBuer = strBuer.toUpperCase();
			return strBuer;
		}
	}

	public static boolean isLetter(char c) {
		int k = 128;
		return c / k == 0;
	}

	public static int length(String s) {
		if (s == null)
			return 0;
		char c[] = s.toCharArray();
		int len = 0;
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i]))
				len++;
		}

		return len;
	}

	public static String getSubString(String strVal, int beginInt, int endInt) {
		String str = null;
		int endLen = getChinesChar(strVal);
		str = strVal.substring(beginInt, endInt - endLen);
		endInt -= endLen;
		return str;
	}

	public static int getChinesChar(String strVal) {
		int iLen = 0;
		int len = 0;
		if (strVal == null)
			return 0;
		char c[] = strVal.toCharArray();
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i]))
				len++;
		}

		iLen = strVal.length() - len;
		return Math.abs(iLen);
	}

	public static int[] getCharLen(String strVal) {
		int iLen = 0;
		int charStr[] = new int[3];
		int len = 0;
		if (strVal == null)
			return charStr;
		char c[] = strVal.toCharArray();
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i]))
				len++;
		}

		iLen = strVal.length() - len;
		charStr[0] = len;
		charStr[1] = iLen;
		charStr[2] = strVal.getBytes().length;
		return charStr;
	}

	public static String processStrAppendTag(String str1, int maxLen,
			String appendStr) {
		return processStrAppendTag(str1, maxLen, appendStr, "suffix");
	}

	public static String processStrAppendTag(String str1, int maxLen,
			String appendStr, String addDirection) {
		String spaceTag = " ";
		if (appendStr != null)
			spaceTag = appendStr;
		String str = "";
		String subStrP = "";
		List list = getListForStrSplitSub(str1);
		if (list != null && list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				String strSub = String.valueOf(list.get(i));
				int k = maxLen - str.getBytes().length;
				if (strSub.getBytes().length > k) {
					if (strSub.length() == strSub.getBytes().length) {
						str = (new StringBuilder(String.valueOf(str))).append(
								strSub.substring(0, k)).toString();
						break;
					}
					if (strSub.length() != getChinesChar(strSub))
						continue;
					str = (new StringBuilder(String.valueOf(str))).append(
							strSub.substring(0, k / 2)).toString();
					break;
				}
				str = (new StringBuilder(String.valueOf(str))).append(strSub)
						.toString();
			}

		} else {
			for (int i = 0; i < maxLen; i++)
				if ("prefix".equals(addDirection))
					str = (new StringBuilder(String.valueOf(appendStr)))
							.append(str).toString();
				else
					str = (new StringBuilder(String.valueOf(str))).append(
							appendStr).toString();

		}
		if (str.getBytes().length < maxLen) {
			int p = maxLen - str.getBytes().length;
			for (int i = 0; i < p; i++)
				if ("prefix".equals(addDirection))
					str = (new StringBuilder(String.valueOf(appendStr)))
							.append(str).toString();
				else
					str = (new StringBuilder(String.valueOf(str))).append(
							appendStr).toString();

		}
		return str.toString();
	}

	public static List getListForStrSplitSub(String str) {
		List list = new ArrayList();
		if ("".equals(trimNull(str))) {
			list.add("");
			return list;
		}
		if (str.length() == str.getBytes().length)
			list.add(str);
		else if (str.length() == getChinesChar(str)) {
			list.add(str);
		} else {
			int m = 0;
			String strAgs[] = (String[]) null;
			String mStr2 = str;
			boolean bool = !isLetter(mStr2.charAt(0));
			while (m < str.length()) {
				strAgs = splitStrToArray(mStr2, bool);
				if (strAgs != null) {
					m += Integer.parseInt(String.valueOf(strAgs[0]));
					String booleanStr = strAgs[1];
					bool = Boolean.parseBoolean(booleanStr);
					String mStr1 = strAgs[2];
					mStr2 = strAgs[3];
					list.add(mStr1);
				}
			}
		}
		return list;
	}

	public static String[] splitStrToArray(String str, boolean bool) {
		String argStr[] = new String[4];
		String subStr1 = "";
		String subStr2 = "";
		int m = 0;
		boolean bool4 = bool;
		char charArray[] = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			bool4 = !isLetter(c);
			if (bool4 != bool) {
				m = i;
				subStr1 = str.substring(0, m);
				subStr2 = str.substring(m);
				argStr[0] = String.valueOf(m);
				argStr[1] = String.valueOf(bool4);
				argStr[2] = subStr1;
				argStr[3] = subStr2;
				break;
			}
			if (bool4 == bool && i == charArray.length - 1) {
				argStr[0] = String.valueOf(str.length());
				argStr[1] = String.valueOf(bool4);
				argStr[2] = str;
				argStr[3] = str;
			}
		}

		return argStr;
	}

	public static String getFormatDoubleVal(Double doub, String formatPattern) {
		DecimalFormat myformat3 = new DecimalFormat();
		myformat3.applyPattern(formatPattern);
		String decimalFormatValue = myformat3.format(doub);
		return decimalFormatValue;
	}

	public static String getFormatDoubleVal(Double doub, int totalPostion,
			int doubleValPostion) {
		DecimalFormat myformat3 = new DecimalFormat();
		String iStr = "";
		String dStr = "";
		String formatPattern = "";
		int interPosition = totalPostion - doubleValPostion - 1;
		for (int i = 0; i < interPosition; i++)
			iStr = (new StringBuilder(String.valueOf(iStr))).append("#")
					.toString();

		for (int i = 0; i < doubleValPostion; i++)
			dStr = (new StringBuilder(String.valueOf(dStr))).append("0")
					.toString();

		formatPattern = iStr;
		myformat3.applyPattern(formatPattern);
		String decimalFormatValue = myformat3.format(doub);
		if (doub.intValue() == 0) {
			decimalFormatValue = "0";
			if (doubleValPostion != 0)
				decimalFormatValue = (new StringBuilder("0.")).append(dStr)
						.toString();
		}
		return decimalFormatValue;
	}

	public static void main(String args[]) {
		
	//	String str = processStrAppendTag(content, 11, spaceTag);
		//System.out.println((new StringBuilder("str=")).append(str).append(
		//		",strlength=").append(str.getBytes().length).toString());
	//	System.out.println((new StringBuilder("str=")).append(str).toString());
	}


}


