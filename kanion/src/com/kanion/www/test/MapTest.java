/**
* Filename: HashMapTest.java
* Project Name: kanion
* @author: cyz	63954008(at)qq.com
* @version: 1.0
* @since: JDK 1.7.0_45
* Copyright © 2014 CCNT. All Rights Reserved
* Create at: 2014年11月9日  下午9:22:28
* Description:
*
* Modification History:
* Date			Author		Version		Description
* ------------------------------------------------------------------
* 2014年11月9日	cyz    		1.0			1.0 Version
*/
package com.kanion.www.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: HashMapTest
 * @Description: TODO
 * @date 2014年11月9日 下午9:22:28
 *
 */
public class MapTest{
	
	public static void main(String[] args) {
		//测试map是复制put还是直接put
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		List<String> list=new ArrayList<String>();
		list.add(0,"aaaa");
		list.add(1, "bbbb");
		map.put("lits", list);
		System.out.println(map);
		list.add(2, "ccc");
		System.out.println(map);
		/**
		 * 运行结果是
		 * {lits=[aaaa, bbbb]}
		 * {lits=[aaaa, bbbb, ccc]}
		 * 可知，map是直接把对象加入其中，而不是复制。
		 */
		
	}
	
	


}
