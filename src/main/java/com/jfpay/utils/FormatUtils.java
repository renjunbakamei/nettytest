package com.jfpay.utils;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FormatUtils {

	private static int sequence = 0;

	/**
	 * string类型当前日期
	 *
	 * @return
	 */
	public static String formatDate() {
		String sdate = time();
		return sdate.substring(0, 8);
	}

	/**
	 * String类型当前时间
	 *
	 * @return
	 */
	public static String formatTime() {
		String sdate = time();
		return sdate.substring(8, 14);
	}

	public static String time() {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		String sdate = sd.format(date);
		return sdate;
	}

	public static String getRandom() {
		StringBuffer random = new StringBuffer();
		Random r = new Random();
		for (int i = 0; i < 6; i++) {
			random.append(r.nextInt(9));
		}
		return random.toString();
	}

	public static Date StrToTime(String str) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		Date sdate = null;
		try {
			sdate = sd.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdate;
	}

	/**
	 * 6位自增长码
	 *
	 * @return
	 */
	public static synchronized String getTrmSeqNum() {
		sequence = sequence >= 999999 ? 1 : sequence + 1;
		String s = Integer.toString(sequence);
		return addLeftZero(s, 6);
	}

	/**
	 * YYYYMMDDHHMMSS+6位自增长码(20位)
	 *
	 * @return
	 */
	public static synchronized String getLocalTrmSeqNum() {
		sequence = sequence >= 999999 ? 1 : sequence + 1;
		String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		String s = Integer.toString(sequence);
		return datetime + addLeftZero(s, 6);
	}

	/**
	 * 左填0
	 *
	 * @param s
	 * @param length
	 * @return
	 */
	public static String addLeftZero(String s, int length) {
		// StringBuilder sb=new StringBuilder();
		int old = s.length();
		if (length > old) {
			char[] c = new char[length];
			char[] x = s.toCharArray();
			if (x.length > length) {
				throw new IllegalArgumentException(
						"Numeric value is larger than intended length: " + s
								+ " LEN " + length);
			}
			int lim = c.length - x.length;
			for (int i = 0; i < lim; i++) {
				c[i] = '0';
			}
			System.arraycopy(x, 0, c, lim, x.length);
			return new String(c);
		}
		return s.substring(0, length);

	}

	/**
	 * 二进制转16进制
	 *
	 * @param bString
	 * @return
	 */
	public static String binaryString2hexString(String bString) {
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}

	/**
	 * 16进制转二进制
	 *
	 * @param hexString
	 * @return
	 */
	public static String hexString2binaryString(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0)
			return null;
		StringBuffer bString = new StringBuffer();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < hexString.length(); i++) {
			tmp.append("0000").append(Integer.toBinaryString(Integer.parseInt(hexString
					.substring(i, i + 1), 16)));

			bString.append(tmp.substring(tmp.length() - 4));
		}
		System.out.println(bString);
		return bString.toString();
	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {

		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	/**
	 * String 分转元
	 *
	 * @param amount
	 * @return
	 */
	public static String fty(String amount) {

		DecimalFormat df = new DecimalFormat("0.00");
		double temp = Double.valueOf(amount);
		temp = temp / 100;
		return df.format(temp);
	}

	/**
	 * Long 分转元
	 *
	 * @param amount
	 * @return
	 */
	public static Long fty(Long amount) {

		amount = amount / 100;
		return Long.valueOf(String.valueOf(amount));
	}

	public static String random() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		Random random = new Random();
		int x = random.nextInt(999999);
		if (x < 100000) {
			x = x + 100000;
		}
		return df.format(new Date()) + x;
	}

	public static String changeY2F(String amount) {
		String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
		int index = currency.indexOf(".");
		int length = currency.length();
		Long amLong = 0l;
		if (index == -1) {
			amLong = Long.valueOf(currency + "00");
		} else if (length - index >= 3) {
			amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
		} else if (length - index == 2) {
			amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
		} else {
			amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
		}
		return amLong.toString();
	}

	public static void main(String[] args) {
//        try {
//            System.out.println("结果："+changeF2Y("-000a00"));
//        } catch(Exception e){
//            System.out.println("----------->>>"+e.getMessage());
////          return e.getErrorCode();
//        }
//      System.out.println("结果："+changeY2F("1.00000000001E10"));

		System.out.println(changeY2F("1.33"));
//		try {
//			System.out.println(changeF2Y("1322"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        System.out.println(Long.parseLong(AmountUtils.changeY2F("1000000000000000")));
//        System.out.println(Integer.parseInt(AmountUtils.changeY2F("10000000")));
//        System.out.println(Integer.MIN_VALUE);
//        long a = 0;
//        System.out.println(a);
	}
}

