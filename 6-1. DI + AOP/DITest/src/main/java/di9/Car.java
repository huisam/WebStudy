package di9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class Car {
	private Tire tire; // 다형성 : 부모의 참조변수에 자식의 객체를 저장할 수 있는 성질
	
	@Autowired() // setter 앞에 필요한 객체를 알아서 주입해라, (required=false) 주입된 객체가 없어도 에러하지말고 진행하기 
	// NoSuchBeanException 맞는 타입의 빈 객체를 찾지 못했을 때,
	// NoUniqueBeanDefinitionException 맞는 타입의 빈 객체가 2개이상일 때!
	@Qualifier("chinaTire") // 매칭되는 타입의 빈이 2개 이상일 때 Bean의 id로 원하는 객체를 지정
	// 매칭되는 타입의 빈이 2개이상이지만, @Qualifier 없을때, setter의 변수명과 같은 id 객체를 사용한다
	void setTire(Tire t) {
		tire = t; // Property Injection
	}
	
	void drive() {
		System.out.println(tire.getName() + "로 굴러가는 자동차 di3");
	}
}
// 의존성을 걷어내래려면 타입, 객체 생성 코드를 걷어내야함
// 타입 걷어내기 - 인터페이스를 사용 (느슨한 결합)
// 객체 생성 - 직접 안만들고 매개변수로 받기(생성자, Setter 메서드)
// 생성자로 작업 => Car, KoreaTire, ChinaTire 간의 의존성이 사라짐 => Test로 전가