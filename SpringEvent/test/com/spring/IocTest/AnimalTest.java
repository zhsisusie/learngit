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
	    //在beans.xml文件中声明后，这里直接通过getBean获得对象，而不用new 一个对象
	    ApplicationContextMethodExecutonEventPublisher eventPublisher=(ApplicationContextMethodExecutonEventPublisher) ac.getBean("evtPublisher");
	    eventPublisher.methodToMonitor();
	}

}
