package di4_1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

class Car implements InitializingBean, DisposableBean {
	private ChinaTire chinaTire;

	public Car() {
		chinaTire = new ChinaTire();
		System.out.println("Car 생성자");
	}

	public void drive() {
		System.out.println(chinaTire.getName() + "로 굴러가는 자동차 di4_1 => applicationContext.xml에 빈 설정");
		// => applicationContext.xml에 빈 설정
	}

	public void myInitMethod() {
		System.out.println("객체 초기화시 호출");
	}

	public void myDestroyMethod() {
		System.out.println("객체 죽을 때 호출");
	}

	public void afterPropertiesSet() throws Exception { // 초기화시 호출되는 콜백메서드
		System.out.println("얘도 초기화시 호출됨");
	}

	public void destroy() throws Exception { // 객체 소멸시 호출되는 콜백메서드
		System.out.println("얘도 객체 소멸시 호출됨");
	}
}
// 초기화/소멸 메서드 지정하는 방법
// 1. xml Bean 등록시 설정 : 
// 2. 인터페이스를 구현하는 방법 : InitializeBean, DisposibleBean
// 3. Annotation을 이용하는 방법
