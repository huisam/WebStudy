package aop5;

import java.util.Random;

/**
 * aop1 => aop2 복붙
 * 
 */
public class Boy implements IPerson {
	// 오버라이딩 : 부모의 메서드를 자식클래스에서 재정의하는 기법
	// 조건 : 선언부는 동일해야함,
	// 부모의 접근제어자보다 자식의 접근제어자가 더 넓은 범위로 갈 수 있다
	// 부모의 예외처리보다 더많은 예외를 선언해서는 안된다
	public String doSomething() throws Exception {
		System.out.println("게임을 한다");
		Random ran = new Random();
		if(ran.nextBoolean()) {
			throw new Exception("불이야!!");
		}
		return "I'm a boy";	
	}
	
	public void hello() { // 핵심관심객체에 어떤 핵심관심구현외 멤버가 존재할 때
		System.out.println("안녕하세요!");
	}
}
