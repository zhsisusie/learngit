package com.spring.IocTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ApplicationContext.ApplicationContextMethodExecutonEventPublisher;

public class AnimalTest {

	@Test
	public void test() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("/beans.xml");
		Animal animal=(Animal) ac.getBean("animal");
	    System.out.println(animal.speak());
	    //��beans.xml�ļ�������������ֱ��ͨ��getBean��ö��󣬶�����new һ������
	    ApplicationContextMethodExecutonEventPublisher eventPublisher=(ApplicationContextMethodExecutonEventPublisher) ac.getBean("evtPublisher");
	    eventPublisher.methodToMonitor();
	}

}
