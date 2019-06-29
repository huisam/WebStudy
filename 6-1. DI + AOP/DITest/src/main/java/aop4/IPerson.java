package aop4;

// 1. 원하는 기능의 원형을 가지는 인터페이스를 정의
public interface IPerson {
	public String doSomething() throws Exception; // 어노테이션 기법을 쓰려면 Exception 을 등록해줘야함
	
}
