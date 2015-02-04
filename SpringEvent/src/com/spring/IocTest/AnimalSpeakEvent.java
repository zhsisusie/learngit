package com.spring.IocTest;

import org.springframework.context.ApplicationEvent;

public class AnimalSpeakEvent extends ApplicationEvent{

	private static final long serialVersionUID=1L;
	private String animalName;
	public String getAnimalName() {
		return animalName;
	}
	public AnimalSpeakEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	public AnimalSpeakEvent(Object source,String animalName) {
		super(source);
		this.animalName=animalName;
		
	}
	/*
	 * 创建好该事件类后，就应该把它再合适的时候发布出去。既然它时一个“动物讲话事件”，那么就应该再动物“讲话”的时候发布，如何发布呢？我们知道要发布一个事件，就必须要调用ApplicationContext的publishEvent方法。要在Animal类中获得ApplicationContext的实例，就要实现ApplicationContextAware接口
	 */
}
