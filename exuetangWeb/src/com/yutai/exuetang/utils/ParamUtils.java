/**
 * 
 */
package com.yutai.exuetang.utils;

/**
 * @author Administrator
   2016年7月29日 上午9:32:05
 *
 */
public class ParamUtils {
	// 设置保存盘符
	public static final String PAN = "D:";// 主要用于文件上传（又拍云），要用全路径,,,,需要改盘符
    //又拍云的相关配置
	// 运行前先设置好以下三个参数  
    public static final String BUCKET_NAME = "easygo";  
    public static final String USER_NAME = "e123";  
    public static final String USER_PWD = "easygo123456";  
    /*
	 * 定义一个存储的全局位置，注意，这是一个根节点，全部img在此文件夹下.前面加“/”相对于tomcat所在的盘符的根目录，不加“/”，
	 * 相对于myeclipse安装目录为根目录
	 */
	public static final String SAVEPATP = "/save";
	public static final String SAVEPATP_MUSIC = "/music/";
	public static final String MUSIC_FILE_PATH = "/music/";
	public static final String UPYUN_URL="http://easygo.b0.upaiyun.com";

}
