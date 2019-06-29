package aop4;

import org.aspectj.lang.JoinPoint;

/**
 * 각각의 공통 관심사항을 시점별로 함수로 나눠서 구현하기
 *
 */
public class MyAspect {
	public void doBefore(JoinPoint jp) { // 핵심관심사항 실행전
		if(jp.getTarget() instanceof Boy) {
			((Boy) jp.getTarget()).hello();
		}
		System.out.println("문을 열고 집에 들어감");
	}

	public void deAfterRnnning(String rt) {
		System.out.println(rt);
		System.out.println("불끄고 잔다");
	}

	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage() + " 119에 신고한다");
	}

	public void doAfter() {
		System.out.println("문을 열고나온다!");
	}
	
}
