package di.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ListMain {

	public static void main(String[] args) {
		ApplicationContext container = new GenericXmlApplicationContext("di-collection01.xml");
		
//		ListAddress list =  container.getBean("list", ListAddress.class);
//		ListAddress list =  container.getBean("list02", ListAddress.class);
		ListAddress list =  container.getBean("list03", ListAddress.class);
		
		for(String addr : list.getAddress()) {
			System.out.println(addr);
		}
		
		for(int number : list.getNumbers()) {
			System.out.println(number);
		}
		
		
	}
}
