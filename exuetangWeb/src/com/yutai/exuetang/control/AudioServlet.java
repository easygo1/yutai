package com.yutai.exuetang.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;












import com.google.gson.Gson;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yutai.exuetang.model.beans.audio.Music;
import com.yutai.exuetang.model.beans.audio.Typephoto;
import com.yutai.exuetang.model.beans.exuetang.Coins;
import com.yutai.exuetang.model.dao.audio.IMusicDAO;
import com.yutai.exuetang.model.dao.audio.ITypephotoDAO;
import com.yutai.exuetang.model.dao.exuetang.ICoinsDAO;
import com.yutai.exuetang.model.impl.audio.IMusicDAOImpl;
import com.yutai.exuetang.model.impl.audio.ITypephotoDAOImpl;
import com.yutai.exuetang.model.impl.exuetang.ICoinsDAOImpl;
import com.yutai.exuetang.utils.CodeUtils;

@WebServlet("/audioservlet")
public class AudioServlet extends HttpServlet {

	/**
	 * 音频宝
	 */
	private static final long serialVersionUID = 1L;
	// 用于输出数据
	private PrintWriter mPrintWriter;
	
	private int user_id;

	private Music music;
	private IMusicDAO musicDAO;
	private List<Music> musiclist=new ArrayList<>();
	private int music_id;
	
	private Typephoto typephoto;
	private ITypephotoDAO typephotoDAO;
	private String music_type2_path;
	
	private Coins coins;
	private ICoinsDAO coinsDAO;
	private Gson gson;
//	查询结果
	private String result ;
	private boolean flog;

	public AudioServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 初始化
		mPrintWriter = response.getWriter();
		String method = request.getParameter("methods");
		switch (method) {
		case "addmusic":
			break;
		case "selecttwoStyleMusic":
			//查找符合一级分类二级分类的music
			musicDAO=new IMusicDAOImpl();
//			String type1=CodeUtils.getNewStringApp(request.getParameter("type1"));
			String type1=request.getParameter("type1");
			String type2=request.getParameter("type2");
			int cur=Integer.parseInt(request.getParameter("cur"));
			int typestyle=Integer.parseInt(request.getParameter("tabstyle"));
//			musiclist=musicDAO.selectMusicBytypesOrder1("儿歌学堂", "经典儿歌", 1, 3);
			musiclist=musicDAO.selectMusicBytypesOrder1(type1, type2, cur, typestyle);
			if(musiclist.size()!=0){
//				返回 结果
				gson = new Gson();
				result = gson.toJson(musiclist);
				System.out.println(result);
				mPrintWriter.write(result);
				mPrintWriter.close();
			}else if(musiclist.size()==0){
//				代表没有数据
				System.out.println("201");
				mPrintWriter.write("201");
				mPrintWriter.close();
			}else{
//				查找出现错误
				System.out.println("400");
				mPrintWriter.write("400");
				mPrintWriter.close();
			}
			break;
		case "getallmusic":
			musicDAO=new IMusicDAOImpl();
			musiclist=musicDAO.selectAllMusic();
			gson = new Gson();
			result = gson.toJson(musiclist);
			System.out.println(result);
			mPrintWriter.write(result);
			mPrintWriter.close();
			break;
		case "updateDownloadNum":
//			更新下载量
			musicDAO=new IMusicDAOImpl();
			music_id=Integer.parseInt(request.getParameter("music_id"));
			flog=musicDAO.updateDownloadNum(music_id);
			System.out.println(flog);
			mPrintWriter.write(""+flog);
			mPrintWriter.close();
			break;
		case "updateAuditionNum":
//			更新在线量
			musicDAO=new IMusicDAOImpl();
			music_id=Integer.parseInt(request.getParameter("music_id"));
			flog=musicDAO.updateAuditionNum(music_id);
			System.out.println(flog);
			mPrintWriter.write(""+flog);
			mPrintWriter.close();
			break;
		case "gettypephoto":
//			根据二级类型的名称得到二级类型图片的地址
			typephotoDAO=new ITypephotoDAOImpl();
			String music_type2=request.getParameter("music_type2");
			music_type2_path=typephotoDAO.selectTypephoto(music_type2);
			if(music_type2_path!=""){
				System.out.println("二级图片地址"+music_type2_path);
				mPrintWriter.write(music_type2_path);
				mPrintWriter.close();
			}else{
				mPrintWriter.write("error");
				mPrintWriter.close();
			}
			break;
		case "selectUserCoins":
//			根据用户id得到用户的学习币数量
			user_id=Integer.parseInt(request.getParameter("user_id"));
			coinsDAO=new ICoinsDAOImpl();
			double user_coins=coinsDAO.selectCoinsNumByUserID(user_id);
			System.out.println("用户id"+user_id);
			System.out.println("用户的学习币数"+user_coins);
			mPrintWriter.write(""+user_coins);
			mPrintWriter.close();
			break;
		case "updateMusicAndCoins":
//			下载完成的操作 第一要更新music表中的下载量+1，第二要更新用户的coins表 减去music的所需金币数
			user_id=Integer.parseInt(request.getParameter("user_id"));
			music_id=Integer.parseInt(request.getParameter("music_id"));
			musicDAO=new IMusicDAOImpl();
			coinsDAO=new ICoinsDAOImpl();
//			更新下载量
			flog=musicDAO.updateDownloadNum(music_id);
//			根据music_id得到该音乐的学习币
			double music_coins=musicDAO.getMusicCoins(music_id);
//			更新用户的学习币表
			boolean flog1=coinsDAO.updateCoinsByUserID(user_id, music_coins);
			if(flog1&&flog){
//				更新成功
				System.out.println("下载完成后的数据库更新操作完成");
				mPrintWriter.write(""+true);
				mPrintWriter.close();
			}
			break;
		}
	}
}
