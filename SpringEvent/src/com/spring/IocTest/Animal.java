package com.spring.IocTest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Animal implements ApplicationContextAware{
	private ApplicationContext ac;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		this.ac=arg0;
		
	}
	public String speak(){
		ac.publishEvent(new AnimalSpeakEvent(this,this.name));
		return "我的名字是:"+this.name+",我的年龄是:"+this.age;
	}
    //事件是在这里发布出去的
}
//这样 就在Animal类中把事件发布出去了，现在就要监听该事件的发生了