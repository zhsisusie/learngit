package com.spring.ApplicationContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
/**
 * 
 * @author zhsi
 * @date 2014年11月7日 下午4:52:40
 * @ClassName ApplicationContextMethodExecutonEventPublisher.java
 * @description   发布器类
 */
public class ApplicationContextMethodExecutonEventPublisher implements ApplicationEventPublisherAware{

	private ApplicationEventPublisher eventPublisher;
	
	public void methodToMonitor(){
		ApplicationContextMethodExecutionEvent beginEvt=new 
				ApplicationContextMethodExecutionEvent(this,"methodToMonitor",0);
		this.eventPublisher.publishEvent(beginEvt);
		
		System.out.println("this is what i want to do");
		
		ApplicationContextMethodExecutionEvent endEvt=new 
				ApplicationContextMethodExecutionEvent(this,"methodToMonitor",1);
		this.eventPublisher.publishEvent(endEvt);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO Auto-generated method stub
		this.eventPublisher = applicationEventPublisher;
	}
	

}
