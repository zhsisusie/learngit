/**
* Filename: UserServiceImpl.java
* Project Name: kanion
* @author: cyz	imchyz(at)qq.com
* @version: 1.0
* @since: JDK 1.7.0_45
* Copyright © 2014 MZStudio. All Rights Reserved
* Company: www.MZStudio.com
* Create at: 2014-8-24  下午4:51:28
* Description:
*
* Modification History:
* Date			Author		Version		Description
* ------------------------------------------------------------------
* 2014-8-24	cyz    		1.0			1.0 Version
*/
package com.kanion.www.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanion.www.dao.UserMapper;
import com.kanion.www.model.User;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author CYZ	imchyz@qq.com
 * @date 2014-8-24 下午4:51:28
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {

	
	private UserMapper userMapper;
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public User getUser(BigDecimal uid) {
		return userMapper.selectByPrimaryKey(uid);
	}


	/* (non-Javadoc)
	 * @see com.kanion.www.service.UserService#addUser(com.kanion.www.model.User)
	 */
	@Override
	public String addUser(User user) {
		userMapper.insert(user);
			return "success";
		
	}

}
