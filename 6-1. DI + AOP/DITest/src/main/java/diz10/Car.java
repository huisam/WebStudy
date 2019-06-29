package diz10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Car {
	private Tire tire; // 다형성 : 부모의 참조변수에 자식의 객체를 저장할 수 있는 성질
	
	@Autowired // 맞는 타입을 알아서 넣어줘라
	void setTire(Tire t) {
		tire = t; // Property Injection
	}
	
	void drive() {
		System.out.println(tire.getName() + "로 굴러가는 자동차 di3");
	}
}
