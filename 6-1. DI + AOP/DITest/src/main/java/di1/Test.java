package di1;

/**
 * Spring 적용 방법 
 * 1. STS(Spring Tool Suit) : Spring.io 공식 홈페이지
 * 2. Eclipse Plugin 설치 - Eclipse EE Photon 버전을 받음
 * 
 * Maven Repository - Global Repository - Rebuild Index 향후 프로젝트 진행시 Repository
 * 서버에서 필요한 파일검색하는 시간을 줄이기 위해 인덱싱 작업 실시
 * 
 * =======프로젝트 생성================ 
 * Spring Legacy Project - simple spring maven
 * pom.xml에서 java.version이랑 spring-framework.version 세팅
 * 
 * java.version - 1.8 
 * spring-framework.version - 4.2.5.RELEASE 
 * Build Path 도 1.8 * version으로 
 *
 * 
 */
class Test {
/*
 * 
 */
	public static void main(String[] args) {
		Car c = new Car();
		c.drive();
	}
}
