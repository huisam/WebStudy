package di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * di2 => di5 복붙
 * 스프링 설정파일 객체간의 의존관계를 모두 설정
 * 
 *
 */
class Test {
	public static void main(String[] args) {
//		Car c = new Car(new KoreaTire());
//		c.drive();
		ApplicationContext context = new GenericXmlApplicationContext("di5/ApplicationContext.xml");
		Car c = context.getBean("car", Car.class);
		c.drive();
	}
}
