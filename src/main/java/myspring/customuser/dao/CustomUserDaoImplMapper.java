package myspring.customuser.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.customuser.dao.mapper.CustomUserMapper;
import myspring.customuser.vo.CustomUserVO;

@Repository("CustomUserDao")

public class CustomUserDaoImplMapper implements CustomUserDao{

	@Autowired
	private CustomUserMapper customusermapper;
	
	@Override
	public List<CustomUserVO> readAll() {
		List<CustomUserVO> customUserList = customusermapper.selectCustomUserList();
		return customUserList;
	}

	@Override
	public CustomUserVO read(int id) {
		CustomUserVO customuser = customusermapper.selectCustomUserById(id);
		return customuser;
	}

}
