package diz10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * di9 설정자 주입 => diz10
 * 객체관리를 받을 클래스들을 지정
 * xml applicationContext.xml 에서 지정(<bean>, <context:component-scan> + @Component 클래스에)
 * java ApplicationConfig 에서 지정
 * 
 */
class Test {
	public static void main(String[] args) {
//		ApplicationContext context = new GenericXmlApplicationContext("di9/ApplicationContext.xml");
//		Car c = context.getBean("car", Car.class);
//		c.drive();
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// 자바 설정파일에서 설정정보를 읽어오기 // 각객체는 싱글톤 정책을 같이 사용한다
		KoreaTire tire = context.getBean("koreaTire", KoreaTire.class);
		System.out.println(tire);
		Car c = context.getBean("car", Car.class);
		c.drive();
	}
}

// 소스코드의 의존성이 들어가는 코드를 모두 제거하고,
// 의존성이 꼭 들어가야하는 코드는 한곳에 몰아 놓음 (스프링 컨테이너)
// IoC = 제어의 역전