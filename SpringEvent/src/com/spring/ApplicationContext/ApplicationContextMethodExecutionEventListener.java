package com.spring.ApplicationContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
/**
 * 
 * @author zhsi
 * @date 2014年11月7日 下午4:34:41
 * @ClassName ApplicationContextMethodExecutionEventListener.java
 * @description  监听器类
 */
public class ApplicationContextMethodExecutionEventListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent evt) {
		// TODO Auto-generated method stub
		if(evt instanceof ApplicationContextMethodExecutionEvent){
			System.out.println("applicationEvent log:want to do something");
		}
	}

}
