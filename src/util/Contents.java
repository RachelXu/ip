package util;

/**
 * ϵͳ�������ò���
 * 
 * @author ֣��
 */
public class Contents {

	/** ���������� */
	public static String SERVER_NAME = "��������";
	/** ��С�����˿ں� */
	public static int MIN_PORT = 30000;
	/** �������˿ں� */
	public static int MAX_PORT = 30005;
	/** ������ش�С */
	public static int READ_POOL_SIZE = 10;
	/** д����ش�С */
	public static int WRITE_POOL_SIZE = 10;
	/** �߼�����ش�С */
	public static int LOGIC_POOL_SIZE = 10;
	/** ���ݿ����� */
	public static String DB_URL = "jdbc:mysql://127.0.0.1:3306/iptvm";
	/** ���ݿ��û��� */
	public static String DB_UESER_NAME = "root";
	/** ���ݿ����� */
	public static String DB_PASSWORD = "admin123";
	/** ���ݿ����� */
	public static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	/** ���ݿ����ӳس�ʼ��С */
	public static int DB_INIT_POOL_SIZE = 3;
	/** ���ݿ����ӳ�������� */
	public static int DB_MAX_POOL_SIZE = 3;
	/** ���ݿ����ӳ���С���� */
	public static int DB_MIN_POOL_SIZE = 3;
	/** ���ݿ����ӳؿ���ʱ�� */
	public static int DB_IDLE_TIME = 100;
	/** ����س�ʼ��С */
	public static int BUFFER_SIZE = 200;
	/** ������Զ���չ */
	public static boolean AUTO_EXPAND = true;
	/** �������չ��С */
	public static int EXPAND_SIZE = 100;

	/** һ���Դ����������ݿ������� */
	public static int ACQUIRE_INCREMENT = 3;

}
