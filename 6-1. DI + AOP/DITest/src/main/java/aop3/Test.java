package aop3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * AOP : 관점에 따라 구분
 * 핵심 관심사항
 * 공통 관심사항
 * OOP 단점을 보완 : AOP를 통해서 핵심관심사항과 공통 관심사항을 분리해서 구현
 * 
 * 공통관심사항이 적용할 코드 + 적용 지점
 * Pointcut - AOP 구성을 위해서 지정한 시점
 * Aspect - AOP 구현체
 * 
 * 
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop3/ApplicationContext.xml");
		
		// 위빙 : 핵심관심사항, 공통관심사항을 하나로 묶는 작업
		IPerson boy = context.getBean("boy", IPerson.class); // 부모타입으로 받지 않으면 위빙이 안됨
		IPerson girl = context.getBean("girl", IPerson.class); // 부모타입으로 받지 않으면 위빙이 안됨
		try {
			girl.doSomething();
			System.out.println();
			boy.doSomething();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
