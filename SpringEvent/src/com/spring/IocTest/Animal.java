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
		return "�ҵ�������:"+this.name+",�ҵ�������:"+this.age;
	}
    //�¼��������﷢����ȥ��
}
//���� ����Animal���а��¼�������ȥ�ˣ����ھ�Ҫ�������¼��ķ�����