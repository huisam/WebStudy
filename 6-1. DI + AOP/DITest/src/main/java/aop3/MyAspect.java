package aop3;

/**
 * 각각의 공통 관심사항을 시점별로 함수로 나눠서 구현하기
 *
 */
public class MyAspect {
	public void doBefore() { // 핵심관심사항 실행전
		System.out.println("문을 열고 집에 들어감");
	}

	// 핵심기능 실행
	public void deAfterRnnning() { // 핵심 정상실행후, 핵심관심사항의 매개변수가 있을 때 리턴값을 받을 수 있다
		System.out.println("불끄고 잔다");
	}

	public void doAfterThrowing() { // 핵심 실행 예외 발생, 예외 발생시점의 객체를 매개변수로 등록
		System.out.println(" 119에 신고한다");
	}

	public void doAfter() {
		System.out.println("문을 열고나온다!");
	}
	
}
