/**
 * 
 */
package com.yutai.exuetang.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yutai.exuetang.model.beans.audio.Music;
import com.yutai.exuetang.model.beans.audio.Typephoto;
import com.yutai.exuetang.model.dao.audio.IMusicDAO;
import com.yutai.exuetang.model.dao.audio.ITypephotoDAO;
import com.yutai.exuetang.model.impl.audio.IMusicDAOImpl;
import com.yutai.exuetang.model.impl.audio.ITypephotoDAOImpl;
import com.yutai.exuetang.utils.ParamUtils;
import com.yutai.exuetang.utils.UpYun;

/**
 * @author Administrator 2016年7月29日 上午9:13:05
 * 
 */
@WebServlet("/musicfileservlet")
public class MusicFileUploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 用于输出数据
	private PrintWriter mPrintWriter;

	private Music music;
	private IMusicDAO musicDAO;
	
	private Typephoto typephoto;
	private ITypephotoDAO typephotoDAO;

	/**
	 * Constructor of the object.
	 */
	public MusicFileUploadServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 初始化
		String action=request.getParameter("action");
	    mPrintWriter = response.getWriter();
		music = new Music();
		typephoto=new Typephoto();
//		自己写文件上传的话就很难从input的file取得他的文件路径
		// 初始化SmartUpload
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(this.getServletConfig(), request, response);
		try {
			smartUpload.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> parameterMap = new HashMap<String, String>();
		@SuppressWarnings("rawtypes")
//		必须这样才能接受到对象的属性 要不然会是null
		Enumeration em = smartUpload.getRequest().getParameterNames();
		/*
		 * 这一块处理获取普通表单， 存储到Map中然后用beanutils进行封装
		 */
		while (em.hasMoreElements()) {
			String key = (String) em.nextElement();
//			String value = new String(smartUpload.getRequest().getParameter(key).getBytes("GBK"),"UTF-8");
			String value=smartUpload.getRequest().getParameter(key);
			System.out.println("转换后的 "+value);
			parameterMap.put(key, value);
		}

		String dir = ParamUtils.SAVEPATP + ParamUtils.SAVEPATP_MUSIC;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();// 文件夹不存在，创建
		}
		
		switch (action){
		case "musicfile":
//			音乐文件上传
			try {
				BeanUtils.populate(music, parameterMap);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 我们在这里获取自己封装的数据
			System.out.println("测试打印music:" + music);
			for (int i = 0; i < smartUpload.getFiles().getCount(); i++) {
				// 用户上传少于四张时处理
				if (smartUpload.getFiles().getFile(i).getSize() == 0)
					continue;
				com.jspsmart.upload.File myFile = smartUpload.getFiles().getFile(i);
				System.out.println("i的值：："+myFile.getFilePathName().toString());
				String fileName = myFile.getFileName();
				long currentTimeMillis = System.currentTimeMillis();
				String saveName = currentTimeMillis
						+ fileName.substring(fileName.lastIndexOf("."));
				System.out.println("保存地址" + saveName);
				String saveFullPath = dir + saveName;
				try {
					smartUpload.getFiles().getFile(i).saveAs(saveFullPath);
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 这里完成又拍云图片上传
				String absPath = ParamUtils.PAN + saveFullPath;// 绝对路径
				File file2=new File(absPath);
				UpYun upyun = new UpYun(ParamUtils.BUCKET_NAME,
						ParamUtils.USER_NAME, ParamUtils.USER_PWD);
				boolean result = upyun.writeFile(ParamUtils.MUSIC_FILE_PATH+saveName, file2);
				System.out.println("上传结果" + result);
				// 保存之后，立刻删除原有图片
				File f = new File(absPath);
				if (f.delete()) {
					System.out.println("上传又拍云，删除原有文件成功");
				} else {
					System.out.println("上传又拍云，删除原有文件失败");
				}
//				String str=saveName.substring(saveName.lastIndexOf(".")+1);//截取的文件后缀名
				if(result){
					switch (i){
					case 0:
						music.setMusic_path_mp3(ParamUtils.UPYUN_URL+ParamUtils.MUSIC_FILE_PATH+saveName);
						break;
					case 1:
						music.setMusic_path_lrc(ParamUtils.UPYUN_URL+ParamUtils.MUSIC_FILE_PATH+saveName);
						break;
					case 2:
						music.setMusic_photo(ParamUtils.UPYUN_URL+ParamUtils.MUSIC_FILE_PATH+saveName);
						break;
					case 3:
						music.setMusic_bg_photo(ParamUtils.UPYUN_URL+ParamUtils.MUSIC_FILE_PATH+saveName);
						break;
					case 4:
						music.setMusic_main_photo(ParamUtils.UPYUN_URL+ParamUtils.MUSIC_FILE_PATH+saveName);
						break;
					}
				}
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			music.setMusic_upload_time(df.format(new Date()));
			System.out.println(music.toString());
			musicDAO=new IMusicDAOImpl();
			boolean flog=musicDAO.addMusic(music);
			System.out.println("插入数据库"+flog);
			mPrintWriter.write("文件上传完毕，已经插入到数据库中");
			mPrintWriter.close();
			break;
		case "typephoto":
//			二级类型图片上传
			try {
				BeanUtils.populate(typephoto, parameterMap);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 我们在这里获取自己封装的数据
			System.out.println("测试打印typephoto:" + typephoto);
			
			for (int i = 0; i < smartUpload.getFiles().getCount(); i++) {
				// 用户上传少于四张时处理
				if (smartUpload.getFiles().getFile(i).getSize() == 0)
					continue;
				com.jspsmart.upload.File myFile = smartUpload.getFiles().getFile(i);
				System.out.println("i的值：："+myFile.getFilePathName().toString());
				String fileName = myFile.getFileName();
				long currentTimeMillis = System.currentTimeMillis();
				String saveName = currentTimeMillis
						+ fileName.substring(fileName.lastIndexOf("."));
				System.out.println("保存地址" + saveName);
				String saveFullPath = dir + saveName;
				try {
					smartUpload.getFiles().getFile(i).saveAs(saveFullPath);
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 这里完成又拍云图片上传
				String absPath = ParamUtils.PAN + saveFullPath;// 绝对路径
				File file2=new File(absPath);
				UpYun upyun = new UpYun(ParamUtils.BUCKET_NAME,
						ParamUtils.USER_NAME, ParamUtils.USER_PWD);
				boolean result = upyun.writeFile(ParamUtils.MUSIC_FILE_PATH+saveName, file2);
				System.out.println("上传结果" + result);
				// 保存之后，立刻删除原有图片
				File f = new File(absPath);
				if (f.delete()) {
					System.out.println("上传又拍云，删除原有文件成功");
				} else {
					System.out.println("上传又拍云，删除原有文件失败");
				}
//				String str=saveName.substring(saveName.lastIndexOf(".")+1);//截取的文件后缀名
				if(result){
					switch (i){
					case 0:
						typephoto.setMusic_type2_path(ParamUtils.UPYUN_URL+ParamUtils.MUSIC_FILE_PATH+saveName);
						break;
					}
				}
			}
			typephotoDAO=new ITypephotoDAOImpl();
			boolean flog1=typephotoDAO.addTypephoto(typephoto);
			System.out.println("插入数据库"+flog1);
			mPrintWriter.write("二级图片文件上传完毕，已经插入到数据库中");
			mPrintWriter.close();
			break;
		}
		
	}
}
