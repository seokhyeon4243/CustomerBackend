package myspring.customeruser;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.customuser.dao.mapper.CustomUserMapper;
import myspring.customuser.service.CustomUserService;
import myspring.customuser.vo.CustomUserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-customeruser.xml")
public class CustomerUserDBTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	CustomUserMapper userMapper;
	

	@Autowired
	CustomUserService customUserService;
	
	@Test
	public void service() {
		CustomUserVO customUser = customUserService.getCustomUser(0);
		System.out.println(customUser);
	}
	
	@Test
	public void mapper() {
		// id가 메서드 이름이 되어 argument 전달 
		CustomUserVO user = userMapper.selectCustomUserById(0); 
		System.out.println(user);
	}
	
	@Test @Disabled
	public void session() {
		CustomUserVO user = sqlSession.selectOne("userNS.selectCustomUserById", 0);
		System.out.println(user);
	}
	
	@Test
	public void sessionFactory() {
		System.out.println(sessionFactory.getClass().getName()); // injection 잘 되었는지 확인 org.apache.ibatis.session.defaults.DefaultSqlSessionFactory

	}

	@Test
	public void conn() {
		
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name : " + metaData.getDatabaseProductName());
			System.out.println("DB Driver : " + metaData.getDriverName());
			System.out.println("DB URL : " + metaData.getURL());
			System.out.println("DB Username : " + metaData.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //conn
}
