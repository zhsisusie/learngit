/**
* Filename: MybatisTest.java
* Project Name: kanion
* @author: cyz	imchyz(at)qq.com
* @version: 1.0
* @since: JDK 1.7.0_45
* Copyright © 2014 MZStudio. All Rights Reserved
* Company: www.MZStudio.com
* Create at: 2014-8-24  下午4:55:15
* Description:
*
* Modification History:
* Date			Author		Version		Description
* ------------------------------------------------------------------
* 2014-8-24	cyz    		1.0			1.0 Version
*/
package com.kanion.www.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kanion.www.service.UserService;

/**
 * @ClassName: MybatisTest
 * @Description: TODO
 * @author CYZ	imchyz@qq.com
 * @date 2014-8-24 下午4:55:15
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=
{ "/WEB-INF/cfg/spring.xml","/WEB-INF/cfg/spring-mybatis.xml"})
public class MybatisTest {
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService){
		this.userService=userService;
	}
	
	@Test
	public void testGetUser(){
		BigDecimal i=new BigDecimal(1);
		
		System.out.println(userService.getUser(i).getUsername());
	}

}
