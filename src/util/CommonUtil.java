/**
 * �����к�̨����ϵͳ
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
 * ��ͨ������
 * 
 * @author ֣��
 * 
 */
public class CommonUtil {

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @param pageSize
	 *            һҳ��ʾ������
	 * @param totalCount
	 *            �ܼ�¼��
	 * @return String
	 */
	public static int getTotalPage(int pageSize, int totalCount) {

		// �õ�ҳ������
		int totalPageCount = ((totalCount + pageSize) - 1) / pageSize;

		return totalPageCount;
	}

	/**
	 * ���ڸ�ʽ����yyyy��MM��dd�գ�
	 * 
	 * @param date
	 *            ����
	 * @return String
	 */
	public static String formatDateToYYYYMMDD(Date date) {
		if (date == null) {
			return "";
		}

		DateFormat format = new SimpleDateFormat("yyyy��MM��dd��");
		return format.format(date);
	}

	/**
	 * ���ڸ�ʽ����yyyyMMdd��
	 * 
	 * @param date
	 *            ����
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
	 * MD5����
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
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param string
	 *            �ַ���
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
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param string
	 *            �ַ���
	 * @return boolean
	 */
	public static boolean isEmpty(String string) {
		if (string == null || Contants.EMPTY.equals(string)) {
			return true;
		}
		return false;
	}

	/**
	 * �ж϶����Ƿ�ΪNULL
	 * 
	 * @param object
	 *            ����
	 * @return boolean
	 */
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	/**
	 * ��ȡ�ļ���չ��
	 * 
	 * @param fileName
	 *            �ļ�����
	 * @return String
	 */
	public static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length()).toLowerCase();
	}

	/**
	 * �ж��ַ����Ƿ�����ȷ������
	 * 
	 * @param str
	 *            �ַ���
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
	 * �ж��ַ����Ƿ�����ȷ������
	 * 
	 * @param str
	 *            �ַ���
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
	 * ʵ��Ŀ¼���͵�ת��
	 * 
	 * @param catalog
	 *            Ŀ¼ʵ��
	 * @param level
	 *            ����
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
	 * ʵ��Ŀ¼���͵�ת��
	 * 
	 * @param catalog
	 *            Ŀ¼ʵ��
	 * @param level
	 *            ����
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
	 * ʵ���������͵�ת��
	 * 
	 * @param catalog
	 *            Ŀ¼ʵ��
	 * @param level
	 *            ����
	 * @return LabelValueIntBean
	 */
	public static LabelValueIntBean languageConvertToLabelValueBean(
			Language language) {
		LabelValueIntBean catalogDetil = new LabelValueIntBean(language
				.getLanguageName(), language.getLanguageId());
		return catalogDetil;
	}

	/**
	 * ʵ���������͵�ת��
	 * 
	 * @param catalog
	 *            Ŀ¼ʵ��
	 * @param level
	 *            ����
	 * @return LabelValueIntBean
	 */
	public static LabelValueIntBean areaConvertToLabelValueBean(Area area) {
		LabelValueIntBean catalogDetil = new LabelValueIntBean(area
				.getAreaName(), area.getAreaId());
		return catalogDetil;
	}

	/**
	 * ʵ���������͵�ת��
	 * 
	 * @param catalog
	 *            Ŀ¼ʵ��
	 * @param level
	 *            ����
	 * @return LabelValueIntBean
	 */
	public static LabelValueIntBean serviceConvertToLabelValueBean(
			ServiecType service) {
		LabelValueIntBean serviceDetil = new LabelValueIntBean(service
				.getServiceName(), service.getServiceId());
		return serviceDetil;
	}

	/**
	 * �ַ������ڱȽϣ��뵱�죩
	 * 
	 * @param date
	 *            ����
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
	 * �ַ���ת��������
	 * 
	 * @param date
	 *            ����
	 * @return String
	 */
	public static Integer formatStringToInteger(String param) {
		if (CommonUtil.isNumber(param)) {
			return Integer.valueOf(param);
		}
		return null;
	}

	/**
	 * ����ת�����ַ���
	 * 
	 * @param date
	 *            ����
	 * @return String
	 */
	public static String formatIntegerToString(Integer param) {
		if (CommonUtil.isEmpty(param)) {
			return null;
		}
		return param.toString();
	}

	/**
	 * ��������ַ����������ɲ���ָ����
	 * 
	 * @param length
	 *            �������ַ����ĳ���
	 * @return �Ѳ������ַ���
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
