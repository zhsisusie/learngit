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
	 * �����ø��¼���󣬾�Ӧ�ð����ٺ��ʵ�ʱ�򷢲���ȥ����Ȼ��ʱһ�������ｲ���¼�������ô��Ӧ���ٶ����������ʱ�򷢲�����η����أ�����֪��Ҫ����һ���¼����ͱ���Ҫ����ApplicationContext��publishEvent������Ҫ��Animal���л��ApplicationContext��ʵ������Ҫʵ��ApplicationContextAware�ӿ�
	 */
}
