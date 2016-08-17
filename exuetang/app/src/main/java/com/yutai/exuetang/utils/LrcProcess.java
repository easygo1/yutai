package com.yutai.exuetang.utils;


import android.os.Environment;
import android.util.Log;

import com.yutai.exuetang.model.beans.audio.music.LrcContent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


/**
 *	处理歌词的类
 */
public class LrcProcess {
	private List<LrcContent> lrcList;	//List集合存放歌词内容对象
	private LrcContent mLrcContent;		//声明一个歌词内容对象
	public static final String lrcRootPath = Environment
			.getExternalStorageDirectory().toString()
			+ "/exuetangmusic/";
	/**
	 * 无参构造函数用来实例化对象
	 */
	public LrcProcess() {
		mLrcContent = new LrcContent();
		lrcList = new ArrayList<LrcContent>();
	}
	
	/**
	 * 读取歌词
	 *        localPath 本地地址
	 * @return
	 */
	public String readLRC(String localPath) {
		/*try {
			URL url = new URL(path);
			java.net.URLEncoder.encode(String.valueOf(url), "iso8859-1");//编码以下，保证不能乱码、、
			Log.e("url", String.valueOf(url));
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) urlConnection;
			int code = httpConn.getResponseCode();
			Log.e("code", "" + code);
			urlConnection.connect();
			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				File file = new File(lrcRootPath);
				if (!file.exists()) {
					file.mkdirs();
				}
				BufferedReader bf = new BufferedReader(new InputStreamReader(
						urlConnection.getInputStream(), "GBK"));
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(localPath),
								"GBK")));
				char c[] = new char[1024];
				int temp = -1;
				while ((temp = bf.read()) != -1) {
					bf.read(c);
					out.write(c);
				}
				bf.close();
				out.close();
			}
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		};*/
		/*File savePath = new File(localPath);
		if (!savePath.exists()) {
			savePath.mkdir();
		}
		String[] urlname = path.split("/");
		int len = urlname.length-1;
		String uname = urlname[len];//获取文件名
		try {
			File file = new File(savePath+"/"+uname);//创建新文件
			if(file!=null && !file.exists()){
				file.createNewFile();
			}
			OutputStream oputstream = new FileOutputStream(file);
			URL url = new URL(path);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
			uc.connect();
			InputStream iputstream = uc.getInputStream();
			System.out.println("file size is:"+uc.getContentLength());//打印文件长度
			byte[] buffer = new byte[4*1024];
			int byteRead = -1;
			while((byteRead=(iputstream.read(buffer)))!= -1){
				oputstream.write(buffer, 0, byteRead);
			}
			oputstream.flush();
			iputstream.close();
			oputstream.close();
		} catch (Exception e) {
			System.out.println("读取失败！");
			e.printStackTrace();
		}*/
		//定义一个StringBuilder对象，用来存放歌词内容
		StringBuilder stringBuilder = new StringBuilder();
		//Log.e("lrcProcesspath",path);
		//File f = new File(path.replace(".mp3", ".lrc"));
		File f = new File(localPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		try {
			//创建一个文件输入流对象
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			BufferedReader br = new BufferedReader(isr);
			String s = "";
			while((s = br.readLine()) != null) {
				//替换字符
				s = s.replace("[", "");
				s = s.replace("]", "@");
				
				//分离“@”字符
				String splitLrcData[] = s.split("@");
				if(splitLrcData.length > 1) {
					mLrcContent.setLrcStr(splitLrcData[1]);
					
					//处理歌词取得歌曲的时间
					int lrcTime = time2Str(splitLrcData[0]);
					mLrcContent.setLrcTime(lrcTime);
					//Log.e("mcontent",mLrcContent.toString());
					//添加进列表数组
					lrcList.add(mLrcContent);
					
					//新创建歌词内容对象
					mLrcContent = new LrcContent();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			stringBuilder.append("this木有歌词文件，赶紧去下载！...");
		} catch (IOException e) {
			e.printStackTrace();
			stringBuilder.append("木有读取到歌词哦！");
		}
		return stringBuilder.toString();
	}
	/**
	 * 解析歌词时间
	 * 歌词内容格式如下：
	 * [00:02.32]陈奕迅
	 * [00:03.43]好久不见
	 * [00:05.22]歌词制作  王涛
	 * @param timeStr
	 * @return
	 */
	public int time2Str(String timeStr) {
		timeStr = timeStr.replace(":", ".");
		timeStr = timeStr.replace(".", "@");
		
		String timeData[] = timeStr.split("@");	//将时间分隔成字符串数组
		
		//分离出分、秒并转换为整型
		int minute = Integer.parseInt(timeData[0]);
		int second = Integer.parseInt(timeData[1]);
		int millisecond = Integer.parseInt(timeData[2]);
		
		//计算上一行与下一行的时间转换为毫秒数
		int currentTime = (minute * 60 + second) * 1000 + millisecond * 10;
		return currentTime;
	}
	public List<LrcContent> getLrcList() {
		return lrcList;
	}
}
