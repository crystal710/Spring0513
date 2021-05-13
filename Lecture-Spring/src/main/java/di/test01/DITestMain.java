package di.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DITestMain {

	public static void main(String[] args) {
		
		ApplicationContext container = new GenericXmlApplicationContext("ditest01/beanContainer.xml");
		
		/*
		Calculator c = new Calculator();
		MyCalculator my = new MyCalculator(c);
		*/

		MyCalculator my = (MyCalculator)container.getBean("myCal");
		
		my.setFirstNum(15);
		my.setSecondNum(4);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
		
	}
}
