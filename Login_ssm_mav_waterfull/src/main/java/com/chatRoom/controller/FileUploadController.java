package com.chatRoom.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chatRoom.model.Photo;
import com.chatRoom.service.IPhotoService;
import com.chatRoom.util.JsonUtil;

@Controller
@Configuration
@ImportResource("classpath:spring.xml")
@RequestMapping("/photo")
public class FileUploadController {
	@Resource
	private IPhotoService photoService;
	// @Value("#{settings['picPath.picUrl']}")
		@Value("${picUrl}")
		private String picUrl;
		private String fileName = "";
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

	@RequestMapping(value = "/tofile")
	public String toFileUpLoad(HttpServletRequest request, Model model) {
		return "fileUpLoad";
	}

	@RequestMapping(value="/addAction.do")
	@ResponseBody
	public String save(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam(value = "photo", required = false) MultipartFile filedata)
			throws UnsupportedEncodingException {
		
		  response.setCharacterEncoding("UTF-8");
		  response.setHeader("Cache-Control", "no-cache");
		  response.setDateHeader("Expires", 0);  
		 /* response.setContentType("application/json");
		 */
		// PrintWriter out=null;
		  int pre=0;
		  int fina=0;
		  int dur=0;
		  JSONArray jsonArray = new JSONArray();
			for (int i = 10; i < 30; i++) {
				Photo p = photoService.getPhotoById(new BigDecimal(i));
				jsonArray.add(p);
			}
		if (filedata != null && !filedata.isEmpty()) {
			
			pre=(int)System.currentTimeMillis();
			// 获取图片的文件名
			fileName = filedata.getOriginalFilename();
			
			
			// 获取图片的扩展名
			String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
			// 新的图片名=获取时间戳+"."图片扩展名
			String newFileName = String.valueOf(System.currentTimeMillis())
					+ "." + extensionName;
			
			// 将图片上传到服务器
			fina=saveFile(request, fileName, filedata);
			
			dur=fina-pre;
			System.out.println("上传文件 "+fileName+" 耗时: "+dur);
			// 将图片名称保存至数据库
			// photoService.insert(fileName);
			
		}
		
		return fileName;
		
		// 获取单个json对象
		/*
		 * JSONObject json=null; Photo p1=photoService.getPhotoById(new
		 * BigDecimal(3)); json=JSONObject.fromObject(p1);
		 */

		/*--------------------下面是将图片的信息以json格式返回---------------------*/
		// return jsonArray.toString();
		/*----------------------------------------------------------------------*/
		
	}
	
	
	
	private int saveFile(HttpServletRequest request, String newFileName,
			MultipartFile filedata) {
		int finalTime=0;
		
		// 根据配置文件获取服务器图片存放路径
		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println("路径:" + path);// 输出为：路径:C:\Program Files\Tomcat7.0\wtpwebapps\Login_ssm_mav_waterfull\
		String saveFilePath = path;

		// 根据配置文件中设置路径为:E:\\picture
		 //String saveFilePath=picUrl;

		// String
		// realPath=request.getSession().getServletContext().getRealPath(saveFilePath+"\\"+newFileName);
		// System.out.println("cddd:"+realPath);
		// 输出为E:\workspace\Login_ssm_mav_waterfull\src\main\webapp\E:\picture\6.jpg

		// 构建文件目录
		File tempFile = new File(saveFilePath);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		// 保存文件到服务器
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(saveFilePath + "\\" + newFileName);
			fos.write(filedata.getBytes());
			fos.close();
			finalTime=(int)System.currentTimeMillis();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return finalTime;
	}

}
