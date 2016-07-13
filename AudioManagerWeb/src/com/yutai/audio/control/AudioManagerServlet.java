package com.yutai.audio.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yutai.audio.model.beans.user.Child;
import com.yutai.audio.model.beans.user.User;
import com.yutai.audio.model.dao.user.IChildDAO;
import com.yutai.audio.model.dao.user.IUserDAO;
import com.yutai.audio.model.impl.user.IChildDAOImpl;
import com.yutai.audio.model.impl.user.IUserDAOImpl;
import com.yutai.audio.utils.MD5Utils;

@WebServlet("/audioservlet")
public class AudioManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 用于输出数据,打印出来
	private PrintWriter mPrintWriter;
	Gson gson;
	// gson.toJson()的结果
	String result;
	boolean flog;
	
	private IUserDAO userdao;
	private User user;
	private int user_id;
	private List<User> userlist;
	
	private IChildDAO childdao;
	private Child child;
	private List<Child> childList;
	
	/**
	 * Constructor of the object.
	 */
	public AudioManagerServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("methods");
		mPrintWriter = response.getWriter();

		switch (method) {
		case "adduser":
			//用户表中插入数据
			userdao = new IUserDAOImpl();
			String user_phone=request.getParameter("user_phone");
			String user_password_input=request.getParameter("user_password");
			String user_password=MD5Utils.md5(user_password_input);
			String user_nickname=request.getParameter("user_nickname");
			String user_token=request.getParameter("user_token");
			String user_openid=request.getParameter("user_openid");
			String user_realname=request.getParameter("user_realname");
			String user_sex=request.getParameter("user_sex");
			int user_type=Integer.parseInt(request.getParameter("user_type"));
			String user_remarks=request.getParameter("user_remarks");
			//user=new User(1215,"123645","小孩子","测试","测试","测试","女",1,"测试");
			user=new User(user_phone,user_password,user_nickname,user_token,user_openid,user_realname,user_sex,user_type,user_remarks);
			flog=userdao.addUser(user);
			mPrintWriter.write(""+flog);// 将数据写回android端
			mPrintWriter.close();
		break;
		case "selectuserbyid":
			//根据用户ID查找该用户所有信息
			userdao = new IUserDAOImpl();
			user=userdao.selectUserByID(10000);
			System.out.println(user);
			gson = new Gson();
			result = gson.toJson(user);
			mPrintWriter.write(result);// 将数据写回android端
			mPrintWriter.close();
			break;
		case "selectuserbyphone":
			//根据手机号查询出用户的所有信息
			userdao = new IUserDAOImpl();
			userlist=new ArrayList<>();
			user=userdao.selectUserByPhone("123456");
			System.out.println(user.toString());
			mPrintWriter.write(user.toString());// 将数据写回android端
			mPrintWriter.close();
			break;
		case "selectAllUser":
			//查询出所有的用户
			userdao = new IUserDAOImpl();
			userlist=new ArrayList<>();
			userlist=userdao.selectAllUser();
			System.out.println(userlist.size());
			break;
		case "updateUserByID":
			//根据userid更新用户信息
			userdao = new IUserDAOImpl();
			//user_id=Integer.parseInt(request.getParameter("user_id"));
			user=new User("111111",MD5Utils.md5("123645"),"小孩子","更新测试","更新测试","更新测试","女",1,"更新测试");
			flog=userdao.updateUserByID(user, 10000);
			//userdao.updateUserByID(user, user_id);
			mPrintWriter.write(""+flog);// 将数据写回android端
			mPrintWriter.close();
			break;
		case "updateUserPasswordByID":
			//根据用户ID，新旧密码，修改用户密码
			userdao = new IUserDAOImpl();
			/*String user_password_old=MD5Utils.md5(request.getParameter("user_password_old"));
			String user_password_new=MD5Utils.md5(request.getParameter("user_password_new"));
			user_id=Integer.parseInt(request.getParameter("user_id"));
			//判断旧密码是否一致
			boolean isok=userdao.selectUserOKPasswordByID(user_password_old, user_id);
			if(isok){
				//密码一致 进行修改密码操作
				userdao.updateUserPasswordByID(user_password_new, user_id);
			}else{
				//密码不一致
			}*/
			boolean isok=userdao.selectUserOKPasswordByID(MD5Utils.md5("123645"), 10000);
			if(isok){
				//密码一致 进行修改密码操作
				flog=userdao.updateUserPasswordByID(MD5Utils.md5("123456"), 10000);
			}else{
				//密码不一致
				flog=false;
				System.out.println("更新密码出现error：密码不一致");
			}
			mPrintWriter.write(""+flog);// 将数据写回android端
			mPrintWriter.close();
			break;	
		case "addChild":
			childdao=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_birthday=request.getParameter("child_birthday");
			String child_name=request.getParameter("child_name");
			String child_photo=request.getParameter("child_photo");
			String child_sex=request.getParameter("child_sex");
			String child_school_province=request.getParameter("child_school_province");
			String child_school_city=request.getParameter("child_school_city");
			String child_school_county=request.getParameter("child_school_county");
			String child_school_town=request.getParameter("child_school_town");
			String child_school_name=request.getParameter("child_school_name");
			String child_school_class=request.getParameter("child_school_class");
			String child_home_province=request.getParameter("child_home_province");
			String child_home_city=request.getParameter("child_home_city");
			String child_home_county=request.getParameter("child_home_county");
			String child_home_address=request.getParameter("child_home_address");
			String child_hobby=request.getParameter("child_hobby");
			String child_remarks=request.getParameter("child_remarks");
			child=new Child(user_id, child_birthday, child_name, child_photo, child_sex, child_school_province, child_school_city, child_school_county, child_school_town, child_school_name, child_school_class, child_home_province, child_home_city, child_home_county, child_home_address, child_hobby, child_remarks);
			childdao.addChild(child);
			break;
		}
	}
}
