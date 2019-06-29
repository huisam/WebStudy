package di7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Test {
	public static void main(String[] args) {
//		Car c = new Car();
//		c.drive();
		ApplicationContext context = new GenericXmlApplicationContext("di7/ApplicationContext.xml");
		Car c = context.getBean("c", Car.class);
		c.drive();
		((GenericXmlApplicationContext) context).close(); // 컨테이너 닫기
	} // end of main
} // end of class
