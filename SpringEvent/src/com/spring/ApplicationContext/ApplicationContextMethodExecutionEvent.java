package com.spring.ApplicationContext;

import org.springframework.context.ApplicationEvent;
/**
 * 
 * @author zhsi
 * @date 2014年11月7日 下午4:22:48
 * @ClassName ApplicationContextMethodExecutionEvent.java
 * @description  事件类
 */
public class ApplicationContextMethodExecutionEvent extends ApplicationEvent{

	private String methodName;
	
	

	private int status;
	private static final long serialVersionUID=1L;
	public ApplicationContextMethodExecutionEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public ApplicationContextMethodExecutionEvent(Object source,
			String methodName, int status) {
		super(source);
		this.methodName = methodName;
		this.status = status;
	}
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
