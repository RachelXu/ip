/**
 * 机顶盒后台管理系统
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import dao.Area;
import dao.Catalog;
import dao.Language;
import dao.ServiecType;
import form.CatalogDetil;
import form.LabelValueIntBean;

/**
 * 共通工具类
 * 
 * @author 郑悦
 * 
 */
public class CommonUtil {

	/**
	 * 获取总页数
	 * 
	 * @param pageSize
	 *            一页显示的数量
	 * @param totalCount
	 *            总记录数
	 * @return String
	 */
	public static int getTotalPage(int pageSize, int totalCount) {

		// 得到页面总数
		int totalPageCount = ((totalCount + pageSize) - 1) / pageSize;

		return totalPageCount;
	}

	/**
	 * 日期格式化（yyyy年MM月dd日）
	 * 
	 * @param date
	 *            日期
	 * @return String
	 */
	public static String formatDateToYYYYMMDD(Date date) {
		if (date == null) {
			return "";
		}

		DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		return format.format(date);
	}

	/**
	 * 日期格式化（yyyyMMdd）
	 * 
	 * @param date
	 *            日期
	 * @return String
	 */
	public static String formatDateToCharYYYYMMDD(Date date) {
		if (date == null) {
			return "";
		}

		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
	}

	/**
	 * MD5加密
	 * 
	 * @param orgPassword
	 * @return String
	 */
	public static String chgPasswordByMD5(String orgPassword) {
		String chgPassword = null;

		if (orgPassword == null || orgPassword.length() == 0) {
			return chgPassword;
		}
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(orgPassword.getBytes());
			byte[] hash = md.digest();
			chgPassword = hashByte2MD5(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return chgPassword;

	}

	private static String hashByte2MD5(byte[] hash) {

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}

		return hexString.toString();
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param string
	 *            字符串
	 * @return boolean
	 */
	public static boolean isEmpty(Integer[] string) {
		if (string == null) {
			return true;
		} else if (string != null && string.length == 0) {
			return true;
		} else if (string != null && string[0] == null) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param string
	 *            字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String string) {
		if (string == null || Contants.EMPTY.equals(string)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断对象是否为NULL
	 * 
	 * @param object
	 *            对象
	 * @return boolean
	 */
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param fileName
	 *            文件名称
	 * @return String
	 */
	public static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length()).toLowerCase();
	}

	/**
	 * 判断字符串是否是正确的数字
	 * 
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是正确的日期
	 * 
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean isyyyyMMdd(String str) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		simpleDateFormat.setLenient(false);
		try {
			simpleDateFormat.parse(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 实现目录类型的转换
	 * 
	 * @param catalog
	 *            目录实例
	 * @param level
	 *            级别
	 * @return CatalogDetil
	 */
	public static CatalogDetil catalogConvertToCatalogDetil(Catalog catalog,
			int level) {
		CatalogDetil catalogDetil = new CatalogDetil();
		catalogDetil.setCatalogId(catalog.getCatalogId());
		catalogDetil.setCatalogZhName(Contants.CATALOG_LEVEL[level]
				+ catalog.getCatalogZhName());
		catalogDetil.setCatalogEnName(catalog.getCatalogEnName());
		catalogDetil.setOrder(catalog.getOrder1());
		return catalogDetil;
	}

	/**
	 * 实现目录类型的转换
	 * 
	 * @param catalog
	 *            目录实例
	 * @param level
	 *            级别
	 * @return LabelValueIntBean
	 */
	public static LabelValueIntBean catalogConvertToLabelValueBean(
			Catalog catalog, int level) {
		LabelValueIntBean catalogDetil = new LabelValueIntBean(
				Contants.CATALOG_LEVEL_BLANK[level]
						+ catalog.getCatalogZhName(), catalog.getCatalogId());
		return catalogDetil;
	}

	/**
	 * 实现语言类型的转换
	 * 
	 * @param catalog
	 *            目录实例
	 * @param level
	 *            级别
	 * @return LabelValueIntBean
	 */
	public static LabelValueIntBean languageConvertToLabelValueBean(
			Language language) {
		LabelValueIntBean catalogDetil = new LabelValueIntBean(language
				.getLanguageName(), language.getLanguageId());
		return catalogDetil;
	}

	/**
	 * 实现语言类型的转换
	 * 
	 * @param catalog
	 *            目录实例
	 * @param level
	 *            级别
	 * @return LabelValueIntBean
	 */
	public static LabelValueIntBean areaConvertToLabelValueBean(Area area) {
		LabelValueIntBean catalogDetil = new LabelValueIntBean(area
				.getAreaName(), area.getAreaId());
		return catalogDetil;
	}

	/**
	 * 实现语言类型的转换
	 * 
	 * @param catalog
	 *            目录实例
	 * @param level
	 *            级别
	 * @return LabelValueIntBean
	 */
	public static LabelValueIntBean serviceConvertToLabelValueBean(
			ServiecType service) {
		LabelValueIntBean serviceDetil = new LabelValueIntBean(service
				.getServiceName(), service.getServiceId());
		return serviceDetil;
	}

	/**
	 * 字符串日期比较（与当天）
	 * 
	 * @param date
	 *            日期
	 * @return String
	 */
	public static boolean isGreaterThanToday(String paramDay) {
		Date today = new Date();
		String paramToday = CommonUtil.formatDateToCharYYYYMMDD(today);
		if (paramDay.compareTo(paramToday) >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 字符串转换成数字
	 * 
	 * @param date
	 *            日期
	 * @return String
	 */
	public static Integer formatStringToInteger(String param) {
		if (CommonUtil.isNumber(param)) {
			return Integer.valueOf(param);
		}
		return null;
	}

	/**
	 * 数字转换成字符串
	 * 
	 * @param date
	 *            日期
	 * @return String
	 */
	public static String formatIntegerToString(Integer param) {
		if (CommonUtil.isEmpty(param)) {
			return null;
		}
		return param.toString();
	}

	/**
	 * 产生随机字符串，长度由参数指定。
	 * 
	 * @param length
	 *            产生的字符串的长度
	 * @return 已产生的字符串
	 */
	public static String getRandString(int length) {
		String charList = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String rev = "";
		java.util.Random f = new Random();
		for (int i = 0; i < length; i++) {
			rev += charList.charAt(Math.abs(f.nextInt()) % charList.length());
		}
		return rev;
	}
}
