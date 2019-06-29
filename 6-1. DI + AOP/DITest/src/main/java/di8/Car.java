package di8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Car {
	private Tire tire; // 다형성 : 부모의 참조변수에 자식의 객체를 저장할 수 있는 성질
	@Autowired // 객체를 생성시 필요한 매개변수를 타입에 맞는 것을 찾아 알아서 지정해줌
	//  필요한 타입이랑 맞는 타입의 Bean이 등록되지 않을 때 NoSuchBeanDefinitionException
	public Car(Tire t) {
		tire = t;
	}
	
	public void drive() {
		System.out.println(tire.getName() + "로 굴러가는 자동차 di2");
	}
}
// 의존성을 걷어내래려면 타입, 객체 생성 코드를 걷어내야함
// 타입 걷어내기 - 인터페이스를 사용 (느슨한 결합)
// 객체 생성 - 직접 안만들고 매개변수로 받기(생성자, Setter 메서드)
// 생성자로 작업 => Car, KoreaTire, ChinaTire 간의 의존성이 사라짐 => Test로 전가