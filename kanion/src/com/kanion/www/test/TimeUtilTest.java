/**
* Filename: TimeUtilTest.java
* Project Name: kanion
* @author: cyz	63954008(at)qq.com
* @version: 1.0
* @since: JDK 1.7.0_45
* Copyright © 2014 CCNT. All Rights Reserved
* Create at: 2014年10月29日  下午3:24:30
* Description:
*
* Modification History:
* Date			Author		Version		Description
* ------------------------------------------------------------------
* 2014年10月29日	cyz    		1.0			1.0 Version
*/
package com.kanion.www.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.kanion.www.util.TimeUtil;

/**
 * @ClassName: TimeUtilTest
 * @Description: TODO
 * @date 2014年10月29日 下午3:24:30
 *
 */
public class TimeUtilTest {
	
	

	/**
	 * Test method for {@link com.kanion.www.util.TimeUtil#changeToHour(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testChangeToHour() {
		double test2=0.01+0.05;
		
		BigDecimal test=new BigDecimal(Double.toString(test2));

		System.out.println(test2);
		
		double v1=0.01,v2=0.05;
		BigDecimal b1=new BigDecimal(Double.toString(v1));
		BigDecimal b2=new BigDecimal(Double.toString(v2));
		double v3=b1.add(b2).doubleValue();
		System.out.println(v3);
	

	}

}
