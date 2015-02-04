package com.spring.IocTest;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class AnimalEventListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		if(event instanceof AnimalSpeakEvent){
			AnimalSpeakEvent a=(AnimalSpeakEvent)event;
			System.out.println("�¼������� "+this.getClass().getSimpleName()+":��һ�������ڽ���,����������:"+a.getAnimalName());
		}
	}

}
