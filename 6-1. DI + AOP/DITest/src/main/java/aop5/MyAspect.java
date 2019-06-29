package aop5;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 각각의 공통 관심사항을 시점별로 함수로 나눠서 구현하기
 *
 */
public class MyAspect {
	public void doAround(ProceedingJoinPoint pt) {
		// around 적용시점
		// 핵심관심사항 실행전, 후, 에러, 마지막항상
		System.out.println("문 열고 집에 들어감");
		try {
			String str = (String) pt.proceed();
			// 핵심관심사항을 실행하는 코드
			System.out.println("불끄고 잔다, 리턴값 :" + str);
		} catch (Throwable e) {
			System.out.println(e.getMessage() + " 119에 신고한다");
		} finally {
			System.out.println("문을 열고나온다!");
		} 

	}
	
//	public void doBefore(JoinPoint jp) { // 핵심관심사항 실행전
//		System.out.println("문을 열고 집에 들어감");
//	}
//
//	public void deAfterRnnning(String rt) {
//		System.out.println(rt);
//		System.out.println("불끄고 잔다");
//	}
//
//	public void doAfterThrowing(Throwable th) {
//		System.out.println(th.getMessage() + " 119에 신고한다");
//	}
//
//	public void doAfter() {
//		System.out.println("문을 열고나온다!");
//	}
	
}
