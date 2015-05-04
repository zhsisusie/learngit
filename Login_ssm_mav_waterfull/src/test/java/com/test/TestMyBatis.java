package com.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chatRoom.model.Photo;
import com.chatRoom.model.User;
import com.chatRoom.service.IPhotoService;
import com.chatRoom.service.IUserService;
import com.chatRoom.util.CreTableUtil;
import com.chatRoom.util.ImgHelper;
import com.chatRoom.util.JsonUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring.xml"})
public class TestMyBatis{
	//这是对应配置文件中的变量，给变量注入值
	@Value("${picUrl}")
	private String picUrl;
	
	private JdbcTemplate jdbcTemplate;
	private static Logger logger=Logger.getLogger(TestMyBatis.class);
	@Resource
	private IPhotoService photoService;
	@Autowired
	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}
	@Resource
	private IUserService userService;
	@Resource
	private DataSource dataSource;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@org.junit.Test
	public void test1() throws IllegalArgumentException, IllegalAccessException{
//		PropertyConfigurator
//		.configure(".//WebContent/WEB-INF/cfg/log4j.properties");
		User user=userService.getUserById(new BigDecimal(105));
		//logger.info(JSON.toJSONString(user));
		Photo photo=photoService.getPhotoById(new BigDecimal(3));
		LinkedList<Photo>list=new LinkedList<Photo>();
		list.add(photo);
		list.add(photo);
		System.out.println("\n张思\n");
		System.out.println(JsonUtil.toJson(user));
		System.out.println(JsonUtil.toJson(photo));
		System.out.println(JsonUtil.listToJson(list));
		
		/**
		 * 创建id自增的数据库的执行语句块
		 */
		/*jdbcTemplate=new JdbcTemplate(dataSource);
		CreTableUtil create=new CreTableUtil();
		create.create("photo", jdbcTemplate);
		create.createSequence("zhsi", jdbcTemplate);
		create.idIncrement("photo","zhsi", jdbcTemplate);
		create.create_trigger("photo", "zhsi","triiii", jdbcTemplate);*/
	}
}
