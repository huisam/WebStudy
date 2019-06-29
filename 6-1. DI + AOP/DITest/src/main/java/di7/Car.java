package di7;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("c") // 이 어노테이션이 붙어있는 class는 Bean으로 등록된다, ("c") id 값을 지정할 수 있음
				// ("c")을 지정하지 않으면 "car" 클래스명의 첫글자를 소문자로 바꾼 이름이 id가 된다.
class Car {
	private ChinaTire chinaTire;

	public Car() {
		chinaTire = new ChinaTire();
	}

	public void drive() {
		System.out.println(chinaTire.getName() + "로 굴러가는 자동차 di7");
	}
	
	@PostConstruct
	public void myinit() {
		System.out.println("초기화 메서드...");
	}
	
	@PreDestroy
	public void mydestory() {
		System.out.println("소멸자 메서드...");
	}
}
// 의존성을 걷어내래려면 타입, 객체 생성 코드를 걷어내야함
// 타입 걷어내기 - 인터페이스를 사용 (느슨한 결합)
// 객체 생성 - 직접 안만들고 매개변수로 받기(생성자, Setter 메서드)
