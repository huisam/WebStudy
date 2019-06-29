package di8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Test {
	public static void main(String[] args) {
//		Car c = new Car(new KoreaTire());
//		c.drive();
		ApplicationContext context = new GenericXmlApplicationContext("di8/ApplicationContext.xml");
		Car c = context.getBean("car", Car.class);
		c.drive();
	}
}

// 설정파일 생성
// di8 패키지 파일들을 scan하고 싶다. namespace 에서 추가, 설정파일에도 선언
// Car Class에서 scan 대상이 될 수 있도록 선언