package com.chatRoom.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chatRoom.model.Photo;
import com.chatRoom.service.IPhotoService;
import com.chatRoom.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet{
     private static final long serialVersionUID=95163763702302820L;
     @Resource
	 private IUserService userService;
     @Resource
 	private IPhotoService photoService;
     //获取session
     HttpSession session;
     ServletContext application;
     
     /**
      * 控制跳转到登录界面
      */
     @RequestMapping(value="/toLogin.html")
     public String toLogin(HttpServletRequest request,Model model){
    	 //System.out.println("张思");
    	 return "login";
     }
     /**
      * 执行登录操作
      */
     @RequestMapping(value="/login.html",method=RequestMethod.GET)
     public void login(HttpServletRequest request,Model model,PrintWriter out){
    	 /**login.js中有name和pawword参数信息，发送到http请求中
    	  * data:{"name":name,"password":password},
    	  * 下面的name和password是Request parameters are extra information sent with the request
    	  */
    	 String name=request.getParameter("name");
    	 String password=request.getParameter("password");
    	 String s=userService.login(name, password);
    	 session=request.getSession();
    	 if(s=="success"){
    		 session.setAttribute("name", name);//保存当前登录的用户名
    		 /**
        	  * Returns the ServletContext to which this session belongs.
        	  * The ServletContext object for the web application
        	  */
    		 application=request.getSession().getServletContext();
    		 if(application.getAttribute("onLine")==null){
    			 application.setAttribute("onLine", "");
    		 }
    		 String onLine=application.getAttribute("onLine").toString();
    		 onLine+=name+"<br/>";
    		 application.setAttribute("onLine", onLine);
    	 }
    	 //写入返回结果
    	 out.write(s);//这里便是把数据写到服务器端，传递到前台
     }
     /**
      * 控制跳转到聊天主界面
      */
     @RequestMapping("/toChatMain.html")
     public String toChatMain(HttpServletRequest request,Model model){
    	 return "chatMain";
     }
     
     //登录之后控制跳转到瀑布墙的界面
     @RequestMapping("/toWaterfullPic.html")
     public String toWaterfullPic(HttpServletRequest request,Model model){
    	 return "waterfullPic";
     }
     
     //从数据库中读取信息转换成json格式传递到前台
     @RequestMapping("/picToJsonReturn.do")
     @ResponseBody
     public String picToJsonReturn(HttpServletRequest request,Model model){
    	 JSONArray jsonArray=new JSONArray();
 		for(int i=10;i<30;i++){
 			Photo p=photoService.getPhotoById(new BigDecimal(i));
 			jsonArray.add(p);
 		}
 		return jsonArray.toString();
     }
     /**
      * 前端发送聊天内容
      */
     @RequestMapping("/sentContent.html")
     public void sentContent(HttpServletRequest request,Model model,PrintWriter out){
    	 //存储信息的全局变量
    	 application=request.getSession().getServletContext();
    	 session=request.getSession();
    	 if(application.getAttribute("message")==null){
    		 application.setAttribute("message", "");
    	 }
    	 //获取application中存储的聊天内容
    	 String sourceMessage=application.getAttribute("message").toString();
    	 //获取前端发送的聊天内容
    	 String content=request.getParameter("content");
    	 content=content.replace("<","<img src='/Login_ssm_mav/static/pic");
    	 content=content.replace(":>", ".jpg'/>");
    	 //获取session中的登录者
    	 String name=session.getAttribute("name").toString();
    	 sourceMessage+=this.getTime()+"<font color='blue'><strong>"+name+"</strong></font>:"+content+"</br>";
    	 application.setAttribute("message", sourceMessage);
    	 //写入返回结果
    	 out.write("success");
     }
     
     /**
      * 前端定时获取聊天信息
      */
     @RequestMapping("/getMessageList.html")
     public void getMessageList(HttpServletRequest request,Model model,PrintWriter out){
    	 application=request.getSession().getServletContext();
    	 if(application.getAttribute("message")==null){
    		 application.setAttribute("message", "");
    	 }
    	 //获取application中存储的聊天内容
    	 String sourceMessage=application.getAttribute("message").toString();
    	 String str=null;
    	 try {
			str=new String(sourceMessage.getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	 out.write(str);
     }
     
     /**
      * 前端定时获取在线人员
      */
     @RequestMapping("/getOnlineList.html")
     public void getOnlineList(HttpServletRequest request,Model model,PrintWriter out){
    	 application=request.getSession().getServletContext();
    	 if(application.getAttribute("onLine")==null){
    		 application.setAttribute("onLine", "");
    	 }
    	 //获取application中存储的在线人员
    	 String sourceOnline=application.getAttribute("onLine").toString();
    	 System.out.println("ssss"+sourceOnline);
    	 out.write(sourceOnline);
     }
     /**
      * 自定义日期格式
      */
     private String getTime(){
    	 Date date=new Date();
    	 SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	 return df.format(date);
     }
}

