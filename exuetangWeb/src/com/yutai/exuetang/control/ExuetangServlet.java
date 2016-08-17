package com.yutai.exuetang.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yutai.exuetang.model.beans.exuetang.Child;
import com.yutai.exuetang.model.beans.exuetang.GsonMeInfo;
import com.yutai.exuetang.model.beans.exuetang.GsonUserInfo;
import com.yutai.exuetang.model.beans.exuetang.User;
import com.yutai.exuetang.model.dao.exuetang.IChildDAO;
import com.yutai.exuetang.model.dao.exuetang.IUserDAO;
import com.yutai.exuetang.model.impl.exuetang.IChildDAOImpl;
import com.yutai.exuetang.model.impl.exuetang.IUserDAOImpl;

@WebServlet("/exuetangservlet")
public class ExuetangServlet extends HttpServlet {

	/**
	 * e学堂的servlet
	 */
	private static final long serialVersionUID = 1L;
	// 用于输出数据
	private PrintWriter mPrintWriter;
	boolean flog;//操作成功还是失败
	private Gson gson;
	private String result;
	
	private int user_id;
	private User user;
	private IUserDAO userDAO;
	
	private Child child;
	private IChildDAO childDAO;
	
	public ExuetangServlet() {
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
		case "getMeInfo":
			userDAO=new IUserDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			GsonMeInfo gsonMeInfo=userDAO.getUserSomeInfo(user_id);
			if(gsonMeInfo!=null){
				gsonMeInfo.setCode(200);
			}else{
				gsonMeInfo=new GsonMeInfo(user_id, null, null, null, 0.0, 222);
			}
//			返回 结果
			gson = new Gson();
			result = gson.toJson(gsonMeInfo);
			System.out.println(result);
			mPrintWriter.write(result);
			mPrintWriter.close();
			break;
		case "getMyInfo":
			userDAO=new IUserDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			user=userDAO.selectUserByID(user_id);
			childDAO=new IChildDAOImpl();
			child=childDAO.selectChildByUserID(user_id);
			GsonUserInfo gsonUserInfo;
			if(user!=null&&child!=null){
				gsonUserInfo=new GsonUserInfo(user, child, 200);
			}else{
				gsonUserInfo=new GsonUserInfo(user, child, 222);
			}
//			返回 结果
			gson = new Gson();
			result = gson.toJson(gsonUserInfo);
			System.out.println(result);
			mPrintWriter.write(result);
			mPrintWriter.close();
			break;
		case "updateUserNickname":
			userDAO=new IUserDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String new_nickname=request.getParameter("new_nickname");
			flog=userDAO.updateUserNickname(user_id, new_nickname);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildSex":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_sex=request.getParameter("child_sex");
			System.out.println("user_id:"+user_id+";child_sex"+child_sex);
			flog=childDAO.updateChildSex(user_id, child_sex);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildBirthday":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_birthday=request.getParameter("child_birthday");
			System.out.println("user_id:"+user_id+";child_birthday"+child_birthday);
			flog=childDAO.updateChildBirthday(user_id, child_birthday);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildArea":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_home_province=request.getParameter("child_home_province");
			String child_home_city=request.getParameter("child_home_city");
			String child_home_county=request.getParameter("child_home_county");
			System.out.println("user_id:"+user_id+";child_home_province"+child_home_province+child_home_city+child_home_county);
			flog=childDAO.updateChildProvinceCity(user_id, child_home_province, child_home_city, child_home_county);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildSchoolClass":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_school_class_name=request.getParameter("child_school_class_name");
			System.out.println("user_id:"+user_id+";child_school_class_name"+child_school_class_name);
			flog=childDAO.updateChildSchoolClass(user_id, child_school_class_name);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildDream":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_dream=request.getParameter("child_dream");
			System.out.println("user_id:"+user_id+";child_dream"+child_dream);
			flog=childDAO.updateChildDream(user_id, child_dream);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildHobby":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_hobby=request.getParameter("child_hobby");
			System.out.println("user_id:"+user_id+";child_hobby"+child_hobby);
			flog=childDAO.updateChildHobby(user_id, child_hobby);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateTrainplan":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_trainplan=request.getParameter("child_trainplan");
			System.out.println("user_id:"+user_id+";child_trainplan"+child_trainplan);
			flog=childDAO.updateChildTrainplan(user_id, child_trainplan);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildPhoto":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_photo=request.getParameter("child_photo");
			System.out.println("user_id:"+user_id+";child_photo"+child_photo);
			flog=childDAO.updateChildPhoto(user_id, child_photo);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		case "updateChildAddress":
			childDAO=new IChildDAOImpl();
			user_id=Integer.parseInt(request.getParameter("user_id"));
			String child_address=request.getParameter("child_address");
			System.out.println("user_id:"+user_id+";child_address"+child_address);
			flog=childDAO.updateChildAddress(user_id, child_address);
			if(flog){
				mPrintWriter.write("200");
				mPrintWriter.close();
			}else{
				mPrintWriter.write("222");
				mPrintWriter.close();
			}
			break;
		}
	}

}