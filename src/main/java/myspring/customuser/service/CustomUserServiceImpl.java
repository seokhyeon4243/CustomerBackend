package myspring.customuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.customuser.dao.CustomUserDao;
import myspring.customuser.vo.CustomUserVO;

@Service("customUserService")
public class CustomUserServiceImpl implements CustomUserService{
	
	@Autowired
	CustomUserDao customUserDao;

	@Override
	public CustomUserVO getCustomUser(int id) {
		// TODO Auto-generated method stub
		return customUserDao.read(id);
	}

	@Override
	public List<CustomUserVO> getCustomUserList() {
		// TODO Auto-generated method stub
		return customUserDao.readAll();
	}

}
