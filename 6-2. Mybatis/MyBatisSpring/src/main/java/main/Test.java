package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.ProductDAO;
import model.Product;

/**
 * src : 프로젝트 클래스들의 루트
 * src/main/java		Test.java - 자바
 * src/main/resource	xml, 이미지..
 * src/test/java 
 * 폴더구조 : 종류별로 구분할 수 있도록 분류
 * 
 * 클래스의 경로 : "oo.oo.클래스명" 하위폴더를  . 으로 구분
 * xml의 경로 : "oo/oo/oo.xml" 하위폴더를 / 로 구분
 *
 * Mybatis + Spring 연동
 * 1. 자바코드로부터 SQL문을 분리
 * 2. 'id=? and name=?'파라미터, ResultSet 결과값 매핑을 편리하게 해줌
 * 3. SqlSession 로 Connection 관리 + 트랜잭션 관리
 * 4. Spirng = 객체 관리 컨테이너
 * 
 * 해야할 작업
 * pom.xml에 dependency 추가
 * 	Spring Core, Spring jdbc, Mybatis-Spring, MySql
 * 
 * applicationContext.xml 데이터베이스 정보, 알리아스, 매퍼파일의 위치
 * 							빈 객체 관리하고 싶은 패키지를 스캔
 * 
 * dao.mapper productMapper.xml 작성 SQL문을 저장해놓음
 * model 에 VO 객체 Product 클래스 등록
 * dao 패키지에서 ProductDAO 작성
 * @Autowired 로 일치하는 객체 SqlSessionFactory를 변수로 가져옴
 * 
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("ApplicationContext.xml");
		ProductDAO dao = context.getBean("productDAO", ProductDAO.class);
		System.out.println();
		Product p = dao.selectOne(10);
		System.out.println(p);
		p.setDescription("나는 잘못됬어!");
		dao.update(p);
		p = dao.selectOne(10);
		System.out.println(p);
		
//		p = new Product();
//		p.setName("go");
//		p.setPrice(2000);
//		p.setPictureurl("gogoCing");
//		dao.insert(p);
		
		List<Product> list = dao.selectAll();
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
