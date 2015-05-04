package com.spring.ApplicationContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
/**
 * 
 * @author zhsi
 * @date 2014��11��7�� ����4:34:41
 * @ClassName ApplicationContextMethodExecutionEventListener.java
 * @description  ��������
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
