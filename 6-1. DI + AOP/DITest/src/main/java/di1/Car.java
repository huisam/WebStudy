package di1;

class Car {
	private KoreaTire tire;
	private ChinaTire chinaTire;

	public Car() {
		tire = new KoreaTire();
		chinaTire = new ChinaTire();
	}

	public void drive() {
		System.out.println(chinaTire.getName() + "로 굴러가는 자동차 di1");
	}
}
// 의존성을 걷어내래려면 타입, 객체 생성 코드를 걷어내야함
// 타입 걷어내기 - 인터페이스를 사용 (느슨한 결합)
// 객체 생성 - 직접 안만들고 매개변수로 받기(생성자, Setter 메서드)
