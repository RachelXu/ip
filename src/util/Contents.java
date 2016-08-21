package util;

/**
 * 系统基本配置参数
 * 
 * @author 郑悦
 */
public class Contents {

	/** 服务器名称 */
	public static String SERVER_NAME = "天津服务器";
	/** 最小监听端口号 */
	public static int MIN_PORT = 30000;
	/** 最大监听端口号 */
	public static int MAX_PORT = 30005;
	/** 读处理池大小 */
	public static int READ_POOL_SIZE = 10;
	/** 写处理池大小 */
	public static int WRITE_POOL_SIZE = 10;
	/** 逻辑处理池大小 */
	public static int LOGIC_POOL_SIZE = 10;
	/** 数据库连接 */
	public static String DB_URL = "jdbc:mysql://127.0.0.1:3306/iptvm";
	/** 数据库用户名 */
	public static String DB_UESER_NAME = "root";
	/** 数据库密码 */
	public static String DB_PASSWORD = "admin123";
	/** 数据库驱动 */
	public static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	/** 数据库连接池初始大小 */
	public static int DB_INIT_POOL_SIZE = 3;
	/** 数据库连接池最大数量 */
	public static int DB_MAX_POOL_SIZE = 3;
	/** 数据库连接池最小数量 */
	public static int DB_MIN_POOL_SIZE = 3;
	/** 数据库连接池空闲时间 */
	public static int DB_IDLE_TIME = 100;
	/** 缓冲池初始大小 */
	public static int BUFFER_SIZE = 200;
	/** 缓冲池自动扩展 */
	public static boolean AUTO_EXPAND = true;
	/** 缓冲池扩展大小 */
	public static int EXPAND_SIZE = 100;

	/** 一次性创建的新数据库连接数 */
	public static int ACQUIRE_INCREMENT = 3;

}
