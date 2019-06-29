package di6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Test {
	public static void main(String[] args) {
//		Car c = new Car();
//		c.setTire(new ChinaTire()); // 사용할 타이어를 주입, setter 주입을 더 많이 사용한다
//		c.drive();
		ApplicationContext context = new GenericXmlApplicationContext("di6/ApplicationContext.xml");
		Car c = context.getBean("car", Car.class);
		c.drive();
		// 설정파일에 Bean 등록, 객체, setter 메서드로 자동 주입받음
		// 
	}
}

// 객체를 만들거나 setter 메서드로 주입시키는 작업은
// 스프링컨테이너에서 모두 진행 완료
