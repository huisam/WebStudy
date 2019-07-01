package dao;
/**
 * 세션의 객체는 우리가 만들지 않음, 알아서 처리해준다
 * 데이터베이스 연동하는 작업만
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Product;

@Component
public class ProductDAO {
	@Autowired // 일치하는 타입을 찾아서 객체를 담아준다
	private SqlSessionFactory sessionFactory;

	/**
	 * 테이블에서 code값을 기준으로 데이터를 조회하는 메서드
	 * 
	 * @param code
	 * @return Product
	 */
	public Product selectOne(int code) {
		SqlSession session = null;
		try {
			// sql 작업을 위해서 세션을 얻고, 작업후에 바로 닫아줌
			session = sessionFactory.openSession(false); // false
			Product p = session.selectOne("dao.mapper.productMapper.selectOne", code); //
			return p;
		} finally {
			session.close();
		}
	}
	
	public List<Product> selectAll() {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession(); // false
			List<Product> p = session.selectList("dao.mapper.productMapper.selectAll"); //
			return p;
		} finally {
			session.close();
		}
	}

	public void update(Product product) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession(false);
			session.update("dao.mapper.productMapper.update", product);
		} finally {
			session.close();
		}
	}
	
	public void insert(Product product) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("dao.mapper.productMapper.insert", product);
		} finally {
			session.close();
		}
	}
}
