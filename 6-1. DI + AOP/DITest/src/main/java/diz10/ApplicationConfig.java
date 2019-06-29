package diz10;

import org.springframework.context.annotation.ComponentScan;

//@Configuration // 이 자바파일은 설정파일
//@ComponentScan(basePackages = {"diz10"}) // 지정한 패키지의 모든 클래스를 스캔
@ComponentScan(basePackageClasses = {Car.class}) // 지정한 클래스가 속해있는 패키지 전체의 클래스를 스캔
class ApplicationConfig {
//	// 자바 설정파일을 이용해서 빈을 등록하기
//	@Bean		// 객체관리를 받을 빈객체임을 표시
//	KoreaTire koreaTire() { // 메서드명 koreaTire이 빈의 아이디
//		KoreaTire tire = new KoreaTire();
//		return tire;
//	}
//	@Bean
//	ChinaTire chinaTire() {
//		return new ChinaTire();
//	}
//	@Bean
//	Car car(Tire tire) {
//		Car c = new Car();
//		c.setTire(tire);
//		return c;
//	}
}
